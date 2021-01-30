package net.geeksempire.simpleandroiddemonstration.PlayingWithRegex

class RegexExtractor {

    val normalText = "<b> Hi. Call This Girl <b> 001666111333 To Do Programming. </b>"

    fun doRegex() {

        var postSummary = normalText.replace(Regex("/(<([^>]+)>)/ig"), "");

        //202.55.0125
        normalText.replace(Regex("^(\\d{3}[- .]?){2}\\d{4}$"), "")

    }

}