package net.geeksempire.simpleandroiddemonstration.Network

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class HttpsRequests (val context: Context) {

    val networkCheckpoint = NetworkCheckpoint(context)

    //Https.GET
    //Https.POST

    fun downloadFileFromServer(linkToDownload: String) : Deferred<String> = CoroutineScope(Dispatchers.IO).async {

        val url = URL(linkToDownload)

        val httpsConnection = url.openConnection() as HttpsURLConnection
        httpsConnection.requestMethod = "GET"

        httpsConnection.setDoOutput(true)

        val dataOutputStream = DataOutputStream(httpsConnection.outputStream)

        dataOutputStream.flush()
        dataOutputStream.close()

        val bufferReader = BufferedReader(InputStreamReader(httpsConnection.inputStream))

        var inputLine: String?

        val response = StringBuffer()

        while (bufferReader.readLine().also { inputLine = it } != null) {

            response.append(inputLine)

        }

        bufferReader.close()

        return@async response.toString()

    }

}