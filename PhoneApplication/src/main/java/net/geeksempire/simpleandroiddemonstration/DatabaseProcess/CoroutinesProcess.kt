package net.geeksempire.simpleandroiddemonstration.DatabaseProcess

import kotlinx.coroutines.*

class CoroutinesProcess {

    suspend fun testFunctionsSuspend() {

        //

    }

    fun testFunctionsLaunch() = CoroutineScope(Dispatchers.IO).launch {

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

}