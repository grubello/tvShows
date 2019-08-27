package pl.rutaz.tvshows.ui

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_player.*
import pl.rutaz.tvshows.R
import pl.rutaz.tvshows.util.Constants


class PlayerActivity : AppCompatActivity() {

    private var player: SimpleExoPlayer? = null
    private lateinit var dataSourceFactory: DefaultDataSourceFactory
    private lateinit var videoSource: ProgressiveMediaSource
    private lateinit var videoUri: Uri

    private var playbackPos: Long? = 0L
    private var currentWindow: Int? = 0
    private var playWhenReady: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        videoUri = Uri.parse(intent.extras?.getString(Constants.videoUriKey, ""))

    }

    private fun initPlayer() {
        if (player == null) {
            player = ExoPlayerFactory.newSimpleInstance(this)
            playerView.player = player

            dataSourceFactory = DefaultDataSourceFactory(
                this,
                Util.getUserAgent(this, R.string.app_name.toString())
            )

            videoSource = ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(videoUri)

            player?.prepare(videoSource)
            player?.seekTo(currentWindow!!, playbackPos!!)
            player?.playWhenReady = playWhenReady
        }
    }

    private fun releasePlayer() {
        if (player != null) {
            playbackPos = player?.currentPosition
            currentWindow = player?.currentWindowIndex
            playWhenReady = player!!.playWhenReady
            playerView.player = null
            player?.release()
            player = null
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            initPlayer()
        }
    }

    //Android SDK 24 -> supports multiwindow so activity can be paused but still visible
    override fun onResume() {
        super.onResume()
        if (Util.SDK_INT <= 23 || player == null) {
            initPlayer()
        }
    }

    //SDK 24 -> multiwindow -> same as onResume
    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT <= 23) {
            releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT > 23) {
            releasePlayer()
        }
    }
}
