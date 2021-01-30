package net.geeksempire.simpleandroiddemonstration.Network

import android.content.Context
import android.util.Log
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import java.io.DataOutputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

data class DownloadedFileInformation(var contentByteArray: ByteArray, var contentType: String, var contentSize: Int)

object EnqueueEndPointQuery {
    const val JSON_REQUEST_TIMEOUT = (1000 * 3)
    const val JSON_REQUEST_RETRIES = (3)
}

class HttpsRequests (val context: Context) {

    //Https.GET
    //Https.POST

    fun getJsonDataFromServer() {

        val addressToGetData = "https://abanabsalan.com/wp-json/wp/v2/posts/4749"

        val jsonRequest = JsonObjectRequest(
                Request.Method.GET,
                addressToGetData,
                null,
                { jsonResponse ->
                    Log.d("JsonObjectRequest ${this@HttpsRequests.javaClass.simpleName}", jsonResponse.toString())

                    if (jsonResponse != null) {



                    }

                },
                {
                    Log.d("JsonObjectRequestError", it?.networkResponse?.statusCode.toString())

                })

        jsonRequest.retryPolicy = DefaultRetryPolicy(
                EnqueueEndPointQuery.JSON_REQUEST_TIMEOUT,
                EnqueueEndPointQuery.JSON_REQUEST_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )

        jsonRequest.setShouldCache(false)

        val requestQueue = Volley.newRequestQueue(context)

        requestQueue.add(jsonRequest)
//        requestQueue.add(jsonRequest)
//        requestQueue.add(jsonRequest)
//        requestQueue.add(jsonRequest)

//        requestQueue.start()

    }

    fun downloadFileFromServer(linkToDownload: String) : DownloadedFileInformation {

        val url = URL(linkToDownload)

        val httpsConnection = url.openConnection() as HttpsURLConnection
        httpsConnection.requestMethod = "GET"

//        httpsConnection.setRequestProperty("Password", "ValuePassword")
        httpsConnection.setRequestProperty("User-Agent", "firefox")
        //setRequestProperty("Content-Type", "application/json");

        httpsConnection.doOutput = true

        httpsConnection.connect()

        val dataOutputStream = DataOutputStream(httpsConnection.outputStream)

        val contentLength = httpsConnection.contentLength
        println("Content Length -> ${httpsConnection.contentLength}")

        val contentType = httpsConnection.contentType
        println("Content Type -> ${httpsConnection.contentType}")

        val inputStream = httpsConnection.inputStream

        val byteArray = inputStream.readBytes()

        dataOutputStream.flush()
        dataOutputStream.close()

        inputStream.close()

        return DownloadedFileInformation(byteArray, getContentType(contentType), contentLength)

    }

    fun getContentType(httpsContentType: String) : String {

        return when (httpsContentType) {
            "image/jpeg", "image/png", "image/gif" -> {

                "." + httpsContentType.replace("image/", "")

            }
            "audio/mpeg" -> {

                "." + "mp3"

            }
            "video/mpeg" -> {

                "." + "mp4"

            }
            else -> {
                ""
            }
        }

    }

}