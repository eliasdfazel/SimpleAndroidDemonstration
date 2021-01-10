package net.geeksempire.simpleandroiddemonstration.Services

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.geeksempire.simpleandroiddemonstration.databinding.PlayWithServicesLayoutBinding

class PlayWithServicesActivity : AppCompatActivity() {

    lateinit var playWithServicesLayoutBinding: PlayWithServicesLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        playWithServicesLayoutBinding = PlayWithServicesLayoutBinding.inflate(layoutInflater)
        setContentView(playWithServicesLayoutBinding.root)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            startForegroundService(Intent(applicationContext, LoadingServices::class.java).apply {
                putExtra("LinkToDownload", "https://geeksempire.xyz")
            })

        } else {

            startService(Intent(applicationContext, LoadingServices::class.java).apply {
                putExtra("LinkToDownload", "https://geeksempire.xyz")
            })

        }

        playWithServicesLayoutBinding.rootView.setOnClickListener {

            stopService(Intent(applicationContext, LoadingServices::class.java))

        }

    }

}