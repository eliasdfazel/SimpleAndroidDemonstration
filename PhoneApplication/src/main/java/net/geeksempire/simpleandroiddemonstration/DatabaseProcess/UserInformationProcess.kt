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

        val preferenceName = userInformationDataClass.username//EliasHussaini123
        val emailAddress = userInformationDataClass.emailAddress//elias.fazel@gmail.com
        val phoneNumber = userInformationDataClass.phoneNumber//666

        //EliasHussaini123.xml
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(preferenceName/*Put A Name For File */, Context.MODE_PRIVATE)

        sharedPreferences.edit().let {

            it.putString("EmailAddress", emailAddress)
            it.putString("PhoneNumber", phoneNumber)

            //Apply To Save
            it.apply()

        }

        //let
        //apply
        //also




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