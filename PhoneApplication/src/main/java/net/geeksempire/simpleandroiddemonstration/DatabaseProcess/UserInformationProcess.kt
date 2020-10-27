package net.geeksempire.simpleandroiddemonstration.DatabaseProcess

import android.content.Context
import android.content.SharedPreferences
import net.geeksempire.simpleandroiddemonstration.DataHolder.UserInformationDataClass

class UserInformationProcess () {


    /**
     * This Functions is to Save Users Data In Database - Offline
     **/
    fun saveUserDataInDatabase(context: Context, uniqueUsername: String, emailAddress: String, phoneNumber: String) {

        val preferenceName = "AllUser.xml"

        //AllUsers.xml
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
                preferenceName,
                Context.MODE_PRIVATE
        )

        sharedPreferences.edit().let {

            //uniqueUsername -> uniqueUsername|emailAddress|phoneNumber
            it.putString(uniqueUsername, "${uniqueUsername}-${emailAddress}-${phoneNumber}")

            //Apply To Save
            it.apply()

        }

    }

    fun realAllSavedData(context: Context) : ArrayList<UserInformationDataClass> {

        val allUsersDataList: ArrayList<UserInformationDataClass> = ArrayList<UserInformationDataClass>()

        //AllUsers.xml
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
                "AllUsers.xml",
                Context.MODE_PRIVATE
        )

        sharedPreferences.all.keys.forEach { key ->

            val allUsersData = sharedPreferences.getString(key, null)

            allUsersData?.let {

                //uniqueUsername -> uniqueUsername|emailAddress|phoneNumber
                val splittedData = allUsersData.split("|")

                val username = splittedData[0]
                val email = splittedData[1]
                val phone = splittedData[2]

                allUsersDataList.add(
                        UserInformationDataClass(
                                username,
                                email,
                                phone
                        )
                )

            }

        }

        return allUsersDataList
    }

    /**
     * Search In Database Based on Username
     **/
    fun searchInDatabase(username: String) {


    }

}