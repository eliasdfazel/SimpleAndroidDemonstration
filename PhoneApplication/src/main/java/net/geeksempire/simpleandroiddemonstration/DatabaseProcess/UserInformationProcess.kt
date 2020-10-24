package net.geeksempire.simpleandroiddemonstration.DatabaseProcess

import android.content.Context
import android.content.SharedPreferences
import net.geeksempire.simpleandroiddemonstration.DataHolder.UserInformationDataClass
import java.io.File

class UserInformationProcess (private val userInformationDataClass: UserInformationDataClass) {

    companion object {
        const val STATIC_PARAMETER = "777"
    }

    init {

    }

    var somethingNew = 123

    fun onelineFunctionPlus(firstNumber: Int, secondNumber: Int) : Int = firstNumber.plus(secondNumber)

    /**
     * This Functions is to Save Users Data In Database - Offline
     **/
    fun saveUserDataInDatabase(context: Context) {

        val preferenceName = userInformationDataClass.uniqueUsername //EliasHussaini123

        //EliasHussaini123.xml
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
                preferenceName/* Put A Name For File Which Is UnqiueUsername */,
                Context.MODE_PRIVATE
        )

        val emailAddress = userInformationDataClass.emailAddress //elias.fazel@gmail.com
        val phoneNumber = userInformationDataClass.phoneNumber //666

        sharedPreferences.edit().let {

            it.putString("EmailAddress", emailAddress)
            it.putString("PhoneNumber", phoneNumber)

            //Apply To Save
            it.apply()

        }

    }

    fun readSpecificSharedPreferencesData(context: Context, preferenceName: String) : UserInformationDataClass {

        val uniqueUsername = preferenceName

        //EliasHussaini123.xml >>> 777EliasHussaini123.xml
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
                STATIC_PARAMETER + preferenceName/* Put A Name For File Which Is UnqiueUsername */,
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

        //shared_prefs
        val allFilesDirectory = File("/data/data/${context.packageName}/shared_prefs/")

        if (allFilesDirectory.isDirectory) {

            allFilesDirectory.listFiles().forEach { aFile ->

                if (aFile.name.contains(STATIC_PARAMETER)) {



                }

            }

        }

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