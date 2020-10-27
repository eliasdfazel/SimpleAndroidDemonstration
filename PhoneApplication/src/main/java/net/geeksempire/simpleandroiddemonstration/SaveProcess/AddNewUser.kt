package net.geeksempire.simpleandroiddemonstration.SaveProcess

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import net.geeksempire.simpleandroiddemonstration.DatabaseProcess.UserInformationProcess
import net.geeksempire.simpleandroiddemonstration.databinding.AddNewUserViewBinding

class AddNewUser : AppCompatActivity() {

    private val userInformationProcess: UserInformationProcess = UserInformationProcess()

    lateinit var addNewUserViewBinding: AddNewUserViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addNewUserViewBinding = AddNewUserViewBinding.inflate(layoutInflater)
        setContentView(addNewUserViewBinding.root)

        addNewUserViewBinding.saveDataView.setOnClickListener {

            userInformationProcess.saveUserDataInDatabase(
                context = applicationContext,
                uniqueUsername = addNewUserViewBinding.usernameView.text.toString(),
                emailAddress = addNewUserViewBinding.emailAddressView.text.toString(),
                phoneNumber = addNewUserViewBinding.phoneNumberView.text.toString()
            )

            this@AddNewUser.finish()

        }

        addNewUserViewBinding.phoneNumberView.setOnEditorActionListener { view, actionId, keyEvent ->

            when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {

                    userInformationProcess.saveUserDataInDatabase(
                        context = applicationContext,
                        uniqueUsername = addNewUserViewBinding.usernameView.text.toString(),
                        emailAddress = addNewUserViewBinding.emailAddressView.text.toString(),
                        phoneNumber = addNewUserViewBinding.phoneNumberView.text.toString()
                    )

                    this@AddNewUser.finish()

                }
            }

            false
        }

    }

}