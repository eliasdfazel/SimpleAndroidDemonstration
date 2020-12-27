package net.geeksempire.simpleandroiddemonstration.WorkManager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.work.*
import com.bumptech.glide.Glide
import net.geeksempire.simpleandroiddemonstration.ViewModel.GalleryLiveData
import net.geeksempire.simpleandroiddemonstration.databinding.WorkManagerViewBinding
import java.io.File
import java.util.*

class WorkManagerActivity : AppCompatActivity() {

    lateinit var workManagerViewBinding: WorkManagerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        workManagerViewBinding = WorkManagerViewBinding.inflate(layoutInflater)
        setContentView(workManagerViewBinding.root)

        val workRequestFirst = OneTimeWorkRequestBuilder<WorkBackgroundProcess>().build()
        val workRequestSecond = OneTimeWorkRequestBuilder<WorkBackgroundProcess>().build()
        val workRequestThird = OneTimeWorkRequestBuilder<WorkBackgroundProcess>().build()
        //PeriodicWorkRequestBuilder<WorkBackgroundProcess>(1, TimeUnit.HOURS).build()
        //OneTimeWorkRequestBuilder<WorkBackgroundProcess>().build()

        val workManager = WorkManager.getInstance(applicationContext)

        workManager
                .beginWith(listOf(workRequestFirst, workRequestSecond))
                .then(workRequestThird)
                .enqueue()

//        workManager.enqueue(workRequest)

        workManager
                .getWorkInfoByIdLiveData(workRequestFirst.id).observe(this@WorkManagerActivity, Observer { workerResult ->

                    if (workerResult != null
                            && workerResult.state == WorkInfo.State.SUCCEEDED) {

                        workerResult.outputData.getByteArray("KEY_IMAGE_FILE_NAME_PATH")?.let { byteArray ->

                            val imageFilePath = String(byteArray)

                            val imageFile = File(imageFilePath)

                            Glide.with(applicationContext)
                                    .load(imageFile)
                                    .into(workManagerViewBinding.imageView)

//                            workManagerViewBinding.imageView.setImageBitmap(BitmapFactory.decodeFile(imageFilePath))

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