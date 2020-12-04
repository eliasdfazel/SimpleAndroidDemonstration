package net.geeksempire.simpleandroiddemonstration.DatabaseProcess

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import net.geeksempire.simpleandroiddemonstration.DataHolder.UserInformationDataClass
import net.geeksempire.simpleandroiddemonstration.EntryPoint

interface AfterBackgroundProcess {
    fun notifyUserInterfaceForData()
}

class UserInformationProcess {

    var loadProcessThread: Thread? = null

    fun databaseSize(context: Context) : Int {

        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
                "AllUser",
                Context.MODE_PRIVATE
        )

        return sharedPreferences.all.size
    }

    fun deleteSpecificData(context: Context, keyToSharedPreferences: String) {

        //AllUsers.xml
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            "AllUser",
            Context.MODE_PRIVATE
        )

        sharedPreferences.edit().remove(keyToSharedPreferences).apply()

    }

    /**
     * This Functions is to Save Users Data In Database - Offline
     **/
    fun saveUserDataInDatabase(context: Context, uniqueUsername: String, emailAddress: String, phoneNumber: String) {
        Log.d(this@UserInformationProcess.javaClass.simpleName, phoneNumber)

        //AllUsers.xml
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
            "AllUser",
                Context.MODE_PRIVATE
        )

        sharedPreferences.edit().let {

            //phoneNumber -> uniqueUsername|emailAddress|phoneNumber
            it.putString(phoneNumber, "${uniqueUsername}|${emailAddress}|${phoneNumber}")

            //Apply To Save
            it.apply()

        }

    }

    fun readAllSavedData(context: Context) : List<UserInformationDataClass> {

        context.deleteSharedPreferences("")

        val allUsersDataList: ArrayList<UserInformationDataClass> = ArrayList<UserInformationDataClass>()

        //AllUsers.xml
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(
                "AllUser",
                Context.MODE_PRIVATE
        )

        sharedPreferences.all.keys.forEach { key ->
            Log.d(this@UserInformationProcess.javaClass.simpleName, key)

            val allUsersData = sharedPreferences.getString(key, null)

            allUsersData?.let {
                Log.d(this@UserInformationProcess.javaClass.simpleName, allUsersData)

                //uniqueUsername -> uniqueUsername|emailAddress|phoneNumber
                val splittedData = allUsersData.split("|").toTypedArray()

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

        return allUsersDataList.sortedBy {

            it.phoneNumber
        }
    }

    /**
     * Search In Database Based on Username
     **/
    fun searchInDatabase(context: Context, usernameToSearch: String) : List<UserInformationDataClass> {

        val allData = readAllSavedData(context)

        val searchResult = ArrayList<UserInformationDataClass>()

        allData.forEach {

            if (it.uniqueUsername.contains(usernameToSearch)) {

                println("*** ** * ${it}")

                searchResult.add(it)

            }

        }

        return searchResult
    }

    fun setupAdapterData(entryPoint: EntryPoint, afterBackgroundProcess: AfterBackgroundProcess) {

        //Thread is Loading Data in Background
        loadProcessThread = Thread(Runnable {

            entryPoint.allUsersAdapter.allUsersData.clear()

            entryPoint.allUsersAdapter.allUsersData.addAll(
                    readAllSavedData(entryPoint)
            )

            //Data Is Ready!
            afterBackgroundProcess.notifyUserInterfaceForData()

        })

        if (!loadProcessThread!!.isAlive) {
            loadProcessThread!!.start()
        }

    }

}