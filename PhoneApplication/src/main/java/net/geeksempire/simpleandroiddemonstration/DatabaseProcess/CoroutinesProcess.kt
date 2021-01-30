package net.geeksempire.simpleandroiddemonstration.DatabaseProcess

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class CoroutinesProcess {

    suspend fun testFunctionsSuspend() {

        //

    }

    fun testFunctionsLaunch(): Job = CoroutineScope(Dispatchers.IO).launch {

        //When You Want To Mix Some Results

        //testFunctionsLaunch is now supervisor of testFunctionsAsync
        testFunctionsAsync()


    }

    fun testFunctionsAsync() = CoroutineScope(SupervisorJob() +  Dispatchers.IO).async {

        //We Need Final Results

    }

    fun testFunctionsAsyncReturnResult() : Deferred<String> = CoroutineScope(SupervisorJob() +  Dispatchers.IO).async {

        //
        //We Need Final Results
        //

        "FinalResult"
    }

    fun testFlowOfData() = flow<String> {

        arrayListOf<String>("1", "2", "", "3")
            .asFlow()
            .filter {

                it.isNotEmpty()
            }
            .map {

                val newText = it + " Extra Text"

                emit(newText)
            }
            .onCompletion {//Foreground

                //After Loop Finished
                println(">>> Finished >> " + this)

            }
            .collect()
//            .collect {//Foreground
//                println(">>> ${it}")
//
//                emit(it)
//
//            }

    }

}