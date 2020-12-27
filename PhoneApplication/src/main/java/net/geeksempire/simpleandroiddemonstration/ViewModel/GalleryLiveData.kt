package net.geeksempire.simpleandroiddemonstration.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class GalleryLiveData : ViewModel() {

    val aLiveData: MutableLiveData<ArrayList<DataStructure>> by lazy {
        MutableLiveData<ArrayList<DataStructure>>()
    }

    fun addSomeInformationToLiveData() = CoroutineScope(SupervisorJob() + Dispatchers.IO).launch {

        val someData = ArrayList<DataStructure>()

        (1..10).forEach {

            someData.add(DataStructure(it.toString()))

        }

        aLiveData.postValue(someData)

        /*You Can Continue Process*/
        delay(1000)

        (11..20).forEach {

            someData.add(DataStructure(it.toString()))

        }

        aLiveData.postValue(someData)

    }

}