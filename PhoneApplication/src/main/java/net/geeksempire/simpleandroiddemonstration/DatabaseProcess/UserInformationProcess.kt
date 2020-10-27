package net.geeksempire.simpleandroiddemonstration.DatabaseProcess

import android.content.Context
import android.content.SharedPreferences
import net.geeksempire.simpleandroiddemonstration.DataHolder.UserInformationDataClass

class UserInformationProcess (private val userInformationDataClass: UserInformationDataClass) {

    init {

    }

    var somethingNew = 123

    fun onelineFunctionPlus(firstNumber: Int, secondNumber: Int) : Int = firstNumber.plus(secondNumber)

    /**
     * This Functions is to Save Users Data In Database - Offline
     **/
    fun saveUserDataInDatabase(context: Context) {

        val preferenceName = "AllUser.xml"

        //AllUsers.xml
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
                preferenceName,
                Context.MODE_PRIVATE
        )

        val uniqueUsername = userInformationDataClass.uniqueUsername //EliasHussaini123
        val emailAddress = userInformationDataClass.emailAddress //elias.fazel@gmail.com
        val phoneNumber = userInformationDataClass.phoneNumber //666

        sharedPreferences.edit().let {

            //EliasHussaini123 -> EliasHussaini123|elias.fazel@gmail.com|66666666
            it.putString(uniqueUsername, "${uniqueUsername}-${emailAddress}-${phoneNumber}")

            //Apply To Save
            it.apply()

        }

    }

    fun readSpecificSharedPreferencesData(context: Context, preferenceName: String) : UserInformationDataClass {

        val uniqueUsername = preferenceName

        //AllUsers.xml
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
                preferenceName,
                Context.MODE_PRIVATE
        )

        val emailAddress = sharedPreferences.getString("EmailAddress", null)
        val phoneNumber = sharedPreferences.getString("PhoneNumber", null)

        return UserInformationDataClass (
                uniqueUsername = uniqueUsername,
                emailAddress = emailAddress!!,
                phoneNumber = phoneNumber!!
        )

    }

    fun realAllSavedData(context: Context) {

        //AllUsers.xml
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
                "AllUsers.xml",
                Context.MODE_PRIVATE
        )

        sharedPreferences.all.keys.forEach { key ->

            val allUsersData = sharedPreferences.getString(key, null)

            allUsersData?.let {

                //EliasHussaini123|elias.fazel@gmail.com|66666666

                val splittedData = allUsersData.split("|")

                val username = splittedData[0]
                val email = splittedData[1]
                val phone = splittedData[2]



            }

        }

    }

    /**
     * Search In Database Based on Username
     **/
    fun searchInDatabase(username: String) {


    }

}