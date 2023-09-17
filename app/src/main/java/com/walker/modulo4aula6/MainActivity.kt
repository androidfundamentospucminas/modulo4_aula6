package com.walker.modulo4aula6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class MainActivity : AppCompatActivity() {
    private lateinit var playerView: PlayerView
    private lateinit var player: ExoPlayer

    private lateinit var playButton: Button
    private lateinit var pauseButton: Button
    private lateinit var restartButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa os componentes da interface
        playerView = findViewById(R.id.player_view)
        playButton = findViewById(R.id.play_button)
        pauseButton = findViewById(R.id.pause_button)
        restartButton = findViewById(R.id.restart_button)

        player = ExoPlayer.Builder(this).build()

        playerView.player = player

        val mediaItem = MediaItem.Builder()
            .setUri("https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4")
            .setMimeType(MimeTypes.APPLICATION_MP4)
            .build()

        player.setMediaItem(mediaItem)

        // Configura os botões de reprodução
        playButton.setOnClickListener {
            play()
        }

        pauseButton.setOnClickListener {
            pause()
        }

        restartButton.setOnClickListener {
            restart()
        }
    }

    private fun play() {


        if (!player.isPlaying) {
            player.prepare()
            player.play()
        }
    }

    private fun pause() {
        if (player.isPlaying) {
            player.pause()
        }
    }

    private fun restart() {
        player.seekTo(0)
        player.prepare()
        player.play()
    }
}