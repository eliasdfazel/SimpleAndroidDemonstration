package net.geeksempire.simpleandroiddemonstration.PlayingWithRegex

class RegexExtractor {

    val normalText = "Hi. Call This Girl 202.55.0125 To Do Programming."

    fun doRegex() {

        var postSummary = normalText.replace(Regex("/(<([^>]+)>)/ig"), "");

        //202.55.0125
        normalText.replace(Regex("^(\\d{3}[- .]?){2}\\d{4}$"), "")

    }

}