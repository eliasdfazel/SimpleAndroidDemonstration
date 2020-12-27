package net.geeksempire.simpleandroiddemonstration.WorkManager

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.work.*
import net.geeksempire.simpleandroiddemonstration.ViewModel.GalleryLiveData
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

        val workManager = WorkManager.getInstance(applicationContext)
//        workManager.beginWith(listOf(workRequest))
//        workManager.then(workRequest)
//        workManager.enqueue()
        workManager.enqueue(workRequest)

        workManager
                .getWorkInfoByIdLiveData(workRequest.id).observe(this@WorkManagerActivity, Observer { workerResult ->

                    if (workerResult != null
                            && workerResult.state == WorkInfo.State.SUCCEEDED) {

                        workerResult.outputData.getByteArray("KEY_IMAGE_FILE_NAME_PATH")?.let { byteArray ->

                            val imageFilePath = String(byteArray)

                            workManagerViewBinding.imageView.setImageBitmap(BitmapFactory.decodeFile(imageFilePath))

                        }

                    }

                })

    }

    override fun onStart() {
        super.onStart()

        val galleryLiveData = ViewModelProvider(this@WorkManagerActivity).get(GalleryLiveData::class.java)

        galleryLiveData.aLiveData.observe(this@WorkManagerActivity, Observer {

            it.forEach { aData ->

                println(">>> ${aData}")

            }

        })

        galleryLiveData.addSomeInformationToLiveData()

    }

}