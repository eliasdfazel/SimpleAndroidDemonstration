package net.geeksempire.simpleandroiddemonstration

class SimpleClass (private val userInformationDataClass: UserInformationDataClass) {

    init {

    }

    /**
     * This Functions is to Save Users Data In Database - Offline
     **/
    fun saveUserDataInDatabase() {

        userInformationDataClass.username//we will save you in future...
        userInformationDataClass.email
        userInformationDataClass.phoneNumber

    }

}