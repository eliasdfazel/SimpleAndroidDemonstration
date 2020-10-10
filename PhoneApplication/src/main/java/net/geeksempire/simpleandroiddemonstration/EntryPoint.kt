package net.geeksempire.simpleandroiddemonstration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.geeksempire.simpleandroiddemonstration.databinding.EntryPointViewBinding

class EntryPoint : AppCompatActivity() {

    private lateinit var entryPointViewBinding: EntryPointViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        entryPointViewBinding = EntryPointViewBinding.inflate(layoutInflater)
        setContentView(entryPointViewBinding.root)

        val userInformationDataClass = UserInformationDataClass (
                phoneNumber = 666,
                email = "evil@hell.us",
                username = "Satan666",
        )

        val simpleClass: SimpleClass = SimpleClass(userInformationDataClass)

    }

}