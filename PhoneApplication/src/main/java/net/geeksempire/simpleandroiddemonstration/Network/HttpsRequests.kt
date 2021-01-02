package net.geeksempire.simpleandroiddemonstration.Network

import android.content.Context
import java.io.DataOutputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

data class DownloadedFileInformation(var contentByteArray: ByteArray, var contentType: String, var contentSize: Int)

class HttpsRequests (val context: Context) {

    //Https.GET
    //Https.POST

    fun downloadFileFromServer(linkToDownload: String) : DownloadedFileInformation {

        val url = URL(linkToDownload)

        val httpsConnection = url.openConnection() as HttpsURLConnection
        httpsConnection.requestMethod = "GET"

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