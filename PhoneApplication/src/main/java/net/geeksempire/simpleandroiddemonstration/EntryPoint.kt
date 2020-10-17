package net.geeksempire.simpleandroiddemonstration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.geeksempire.simpleandroiddemonstration.DataHolder.UserInformationDataClass
import net.geeksempire.simpleandroiddemonstration.DatabaseProcess.UserInformationProcess
import net.geeksempire.simpleandroiddemonstration.Utils.doSomething
import net.geeksempire.simpleandroiddemonstration.databinding.EntryPointViewBinding

class EntryPoint : AppCompatActivity() {



    private lateinit var entryPointViewBinding: EntryPointViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        entryPointViewBinding = EntryPointViewBinding.inflate(layoutInflater)
        setContentView(entryPointViewBinding.root)

        val userInformationDataClass = UserInformationDataClass (
                phoneNumber = "98903666",
                emailAddress = "evil@hell.us",
                username = "Satan666",
                phoneCountryCode = 98
        )

        val userInformationProcess: UserInformationProcess = UserInformationProcess(userInformationDataClass)




        doSomething()


    }

}