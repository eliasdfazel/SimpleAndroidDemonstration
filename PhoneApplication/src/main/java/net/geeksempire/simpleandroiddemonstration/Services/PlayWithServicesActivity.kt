package net.geeksempire.simpleandroiddemonstration.Services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.geeksempire.simpleandroiddemonstration.databinding.PlayWithServicesLayoutBinding

class PlayWithServicesActivity : AppCompatActivity() {

    lateinit var playWithServicesLayoutBinding: PlayWithServicesLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        playWithServicesLayoutBinding = PlayWithServicesLayoutBinding.inflate(layoutInflater)
        setContentView(playWithServicesLayoutBinding.root)

        playWithServicesLayoutBinding.rootView.setBackgroundColor(Color.BLUE)

        playWithServicesLayoutBinding.rootView.setOnClickListener {

            stopService(Intent(applicationContext, LoadingServices::class.java))

        }

        playWithServicesLayoutBinding.cancelService.setOnClickListener {

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

                startForegroundService(Intent(applicationContext, LoadingServices::class.java).apply {
                    putExtra("LinkToDownload", "https://geeksempire.xyz")
                })

            } else {

                startService(Intent(applicationContext, LoadingServices::class.java).apply {
                    putExtra("LinkToDownload", "https://geeksempire.xyz")
                })

            }

        }

        //Similar to Manifest Intent-Filter But We Can Define It Dynamically
        val intentFilter = IntentFilter()
        intentFilter.addAction("DataFromService")
        val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {

            override fun onReceive(context: Context?, intent: Intent?) {

                when (intent?.action) {
                    "DataFromService" -> {

                        if (intent.getStringExtra("Result") == "Success") {

                        } else {

                        }

                    }
                }

            }

        }

        applicationContext.registerReceiver(broadcastReceiver, intentFilter)

    }

}