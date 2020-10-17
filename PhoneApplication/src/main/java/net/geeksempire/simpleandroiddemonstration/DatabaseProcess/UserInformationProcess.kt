package net.geeksempire.simpleandroiddemonstration.DatabaseProcess

import net.geeksempire.simpleandroiddemonstration.DataHolder.UserInformationDataClass

class UserInformationProcess (private val userInformationDataClass: UserInformationDataClass) {

    init {

    }

    var somethingNew = 123

    fun onelineFunctionPlus(firstNumber: Int, secondNumber: Int) : Int = firstNumber + secondNumber

    fun normalFunction() : Int {

        return 1 + 9
    }

    /**
     * This Functions is to Save Users Data In Database - Offline
     **/
    fun saveUserDataInDatabase() {

        userInformationDataClass.username//we will save you in future...
        userInformationDataClass.emailAddress
        userInformationDataClass.phoneNumber

    }

    /**
     * Search In Database Based on Username
     **/
    fun searchInDatabase(username: String) {

        val test: String = "TEST"

        repeat(test.length) { index ->



        }

        val testArray = arrayListOf<String>()
        testArray.add("one")
        testArray.add("two")
        testArray.add("three")

        testArray.forEach { text ->

        }

        testArray.forEachIndexed { index, text ->

        }

        for (i in 6 downTo 0 step 2) {


        }

        /*for (int i = 0; i < 10; i++) {

        }*/

        /*for (index in 0 until 10) {


        }*/

    }

}