package net.geeksempire.simpleandroiddemonstration

class UserInformationProcess (private val userInformationDataClass: UserInformationDataClass) {

    init {

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

        //val test: String = "TEST"

        /*repeat(test.length) { index ->



        }*/

        /*for (int i = 0; i < 10; i++) {

        }*/

        /*for (index in 0 until 10) {


        }*/

    }

}