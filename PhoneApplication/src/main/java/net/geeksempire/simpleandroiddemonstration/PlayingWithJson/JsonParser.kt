package net.geeksempire.simpleandroiddemonstration.PlayingWithJson

import org.json.JSONObject

class JsonParser {

    fun prepareJsonData(rawTextOfJson: String) {

        // [ -> Json Array
        // { -> Json Object

        val aJsonObject = JSONObject(rawTextOfJson)

        val idOfPost = aJsonObject.getInt("id")
        println(">>> ID -> ${idOfPost}")

        val allLinks = aJsonObject.getJSONObject("_links")
        println(">>> All Links -> ${allLinks}")

        val linkToPost = allLinks.getJSONArray("self")
        println(">>>  -> ${linkToPost}")

        for (i in 0 until linkToPost.length()) {

            println(">>> Link To Post -> ${(linkToPost[i] as JSONObject).getString("href")}")

        }

    }

}