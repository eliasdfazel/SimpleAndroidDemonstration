package net.geeksempire.simpleandroiddemonstration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.geeksempire.simpleandroiddemonstration.DataHolder.UserInformationDataClass
import net.geeksempire.simpleandroiddemonstration.DatabaseProcess.UserInformationProcess
import net.geeksempire.simpleandroiddemonstration.DatabaseProcess.addEvil
import net.geeksempire.simpleandroiddemonstration.Extensions.setupColorsOfViews
import net.geeksempire.simpleandroiddemonstration.databinding.EntryPointViewBinding

class EntryPoint : AppCompatActivity() {

    //Do Not Consider This DataClass
    val userInformationDataClass = UserInformationDataClass (
            phoneNumber = "98903666",
            emailAddress = "evil@hell.us",
            username = "Satan666",
            phoneCountryCode = 98
    )

    val userInformationProcess: UserInformationProcess by lazy {

        UserInformationProcess(userInformationDataClass)
    }

    lateinit var entryPointViewBinding: EntryPointViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        entryPointViewBinding = EntryPointViewBinding.inflate(layoutInflater)
        setContentView(entryPointViewBinding.root)

        setupColorsOfViews()

        val text: String = "Elias"
        println(text.addEvil()) //It Will Print >> Elias666

        val userInformationDataClass = UserInformationDataClass (
                phoneNumber = "98903666",
                emailAddress = "evil@hell.us",
                username = "Satan666",
                phoneCountryCode = 98
        )

//        val userInformationProcess = UserInformationProcess(userInformationDataClass)

        entryPointViewBinding.root.setOnClickListener {

            /*  */

            userInformationProcess.saveUserDataInDatabase(applicationContext)

        }





    }

}