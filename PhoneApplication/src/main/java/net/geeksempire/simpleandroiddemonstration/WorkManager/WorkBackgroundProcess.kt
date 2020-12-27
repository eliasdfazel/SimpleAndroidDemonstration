package net.geeksempire.simpleandroiddemonstration.WorkManager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.delay
import java.net.URL
import java.nio.charset.Charset

class WorkBackgroundProcess(appContext: Context, workerParams: WorkerParameters) : CoroutineWorker(appContext, workerParams) {

    var workerResult: Result = Result.failure()

    override suspend fun doWork() : Result {

        val imageData = URL("https://media.wired.com/photos/5c5354d391d0df22c1dee493/master/w_2560%2Cc_limit/Backchannel-Lena-Final.jpg").readBytes()

        delay(1000)

        val imageFile = applicationContext.getFileStreamPath("ImageOne.PNG")

        applicationContext.openFileOutput("ImageOne.PNG", Context.MODE_PRIVATE)
            .write(imageData)

        val workOutputData = workDataOf(
                "KEY_IMAGE_FILE_NAME_PATH" to imageFile.absolutePath.toByteArray(Charset.defaultCharset())
        )

        workerResult = if (imageFile.exists()) {

            Result.success(workOutputData)

        } else {

            Result.failure()

        }

        return workerResult
    }

}