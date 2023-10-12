package kr.hs.dgsw.dohyunwook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import kr.hs.dgsw.dohyunwook.databinding.ActivityIntroPageBinding

class IntroPage : AppCompatActivity() {
    private lateinit var binding: ActivityIntroPageBinding

    private lateinit var exoPlayer: ExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setExoPlayer()
        exoPlayer.play()
        binding.btnStart.setOnClickListener {
            startActivity(Intent(applicationContext, OneMakeActivity::class.java))
        }
    }
    private fun setExoPlayer() {
        exoPlayer = ExoPlayer.Builder(this).build()
        binding.playerView.player = exoPlayer

        val uri = RawResourceDataSource.buildRawResourceUri(R.raw.sammy111)
        val mediaItem = MediaItem.fromUri(uri)

        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.repeatMode = Player.REPEAT_MODE_ALL
        exoPlayer.prepare()
    }
    override fun onResume() {
        exoPlayer.prepare()
        super.onResume()
    }

    override fun onPause() {
        exoPlayer.pause()
        super.onPause()
    }

    override fun onDestroy() {
        exoPlayer.release()
        super.onDestroy()
    }
}