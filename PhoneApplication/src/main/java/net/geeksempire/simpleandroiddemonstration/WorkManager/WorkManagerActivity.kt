package net.geeksempire.simpleandroiddemonstration.WorkManager

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import net.geeksempire.simpleandroiddemonstration.databinding.WorkManagerViewBinding
import java.util.*

class WorkManagerActivity : AppCompatActivity() {

    lateinit var workManagerViewBinding: WorkManagerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        workManagerViewBinding = WorkManagerViewBinding.inflate(layoutInflater)
        setContentView(workManagerViewBinding.root)

        val workRequest = OneTimeWorkRequestBuilder<WorkBackgroundProcess>().build()
        //PeriodicWorkRequestBuilder<WorkBackgroundProcess>(1, TimeUnit.HOURS).build()
        //OneTimeWorkRequestBuilder<WorkBackgroundProcess>().build()

        WorkManager.getInstance(applicationContext)
                .enqueue(workRequest)
//                .beginWith(listOf(workRequest))
//                .then(workRequest)
//                .enqueue()

        WorkManager.getInstance(applicationContext).getWorkInfoByIdLiveData(workRequest.id)
                .observe(this@WorkManagerActivity, Observer { workInfo ->


                    if (workInfo != null && workInfo.state == WorkInfo.State.SUCCEEDED) {

                        workInfo.outputData.getByteArray("KEY_IMAGE_FILE_NAME_PATH")?.let {

                            workManagerViewBinding.imageView.setImageBitmap(BitmapFactory.decodeFile(String(it)))

                        }

                    }

                })

    }

}