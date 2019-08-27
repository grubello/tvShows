package pl.rutaz.tvshows.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import pl.rutaz.tvshows.api.ShowRepository
import pl.rutaz.tvshows.model.api.Show
import java.util.concurrent.TimeUnit

class MainViewModel : ViewModel() {

    private val TAG: String = this.javaClass.name

    private var repository: ShowRepository = ShowRepository()
    private val mainViewModelDisposable: CompositeDisposable = CompositeDisposable()
    private val searchTextSubject: PublishSubject<String> = createSearchViewSubject()
    var showList: MutableLiveData<List<Show>> = MutableLiveData()

    private fun createSearchViewSubject(): PublishSubject<String> {
        val subject: PublishSubject<String> = PublishSubject.create()

        subject.debounce(500, TimeUnit.MILLISECONDS)
            .filter { text: String -> text != "" && text.length >= 3 }
            .map { text -> text.toLowerCase() }
            .distinctUntilChanged()
            .switchMap { text ->
                repository.getShows(text).onErrorReturn { ArrayList() }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<Show>> {
                override fun onComplete() {
                    Log.d(TAG, "Api call complete")
                }

                override fun onSubscribe(d: Disposable) {
                    mainViewModelDisposable.add(d)
                    Log.d(TAG, "onSubscribe")
                }

                override fun onNext(t: List<Show>) {
                    showList.value = t
                    Log.d(TAG, "onNext")
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "subject error: " + e.message)
                }
            })

        return subject
    }

    fun processQuery(text: String) {
        searchTextSubject.onNext(text)
    }

    override fun onCleared() {
        super.onCleared()
        mainViewModelDisposable.dispose()
    }
}