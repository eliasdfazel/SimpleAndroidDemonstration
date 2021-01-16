package net.geeksempire.simpleandroiddemonstration.WorkManager

import android.content.Context
import android.os.StrictMode
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.delay
import net.geeksempire.simpleandroiddemonstration.Network.HttpsRequests
import java.nio.charset.Charset

class WorkBackgroundProcess(appContext: Context, workerParams: WorkerParameters) : CoroutineWorker(appContext, workerParams) {

    var workerResult: Result = Result.failure()

    override suspend fun doWork() : Result {

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val getInputData = inputData
        getInputData.getByteArray("KEY")//Convert To Whatever...

        val httpsRequests = HttpsRequests(applicationContext)

        val imageData = httpsRequests.downloadFileFromServer(
                "https://play-lh.googleusercontent.com/0bUs4rGK3EwUiPiX6bm2CsOMJuq89RZbGtY0igaWxacXpqmyXy8wWJeYeUMJHG-JgQ=s180"
        )

        delay(1000)

        val imageFile = applicationContext.getFileStreamPath("ImageOne${imageData.contentType}")

        applicationContext.openFileOutput("ImageOne${imageData.contentType}", Context.MODE_PRIVATE)
            .write(imageData.contentByteArray)

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