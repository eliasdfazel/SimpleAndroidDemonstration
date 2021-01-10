package net.geeksempire.simpleandroiddemonstration.Services

import android.app.*
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import net.geeksempire.simpleandroiddemonstration.R
import net.geeksempire.simpleandroiddemonstration.WebView.InternalWebView

class LoadingServices : Service() {

    override fun onBind(intent: Intent?): IBinder? {

        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        intent?.let {

            startForeground(123,
                    createNotification())

            val linkToDownload = intent.getStringExtra("LinkToDownload")



        }



        return Service.START_NOT_STICKY
    }

    override fun onCreate() {
        super.onCreate()



    }

    override fun onDestroy() {
        super.onDestroy()



    }

    fun createNotification() : Notification {

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val notificationBuilder = NotificationCompat.Builder(applicationContext, this@LoadingServices.javaClass.simpleName)
//        notificationBuilder.setContent(VIEW)
        notificationBuilder.setContentTitle("A Title")
        notificationBuilder.setContentText("Test Text")
        notificationBuilder.setTicker("📱📱📱📱📱📱📱📱📱📱")
        notificationBuilder.setSmallIcon(android.R.drawable.arrow_down_float)
        notificationBuilder.color = Color.GREEN
//        notificationBuilder.setOngoing(true)

        val intent = Intent(applicationContext, InternalWebView::class.java).apply {
            putExtra(Intent.EXTRA_TEXT, "https://gsmarena.com")
        }

        val pendingIntent = PendingIntent.getActivity(applicationContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        notificationBuilder.setContentIntent(pendingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val notificationChannel = NotificationChannel(
                    packageName,
                    getString(R.string.app_name),
                    NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
            notificationBuilder.setChannelId(packageName)

        }

        return notificationBuilder.build()
    }

}