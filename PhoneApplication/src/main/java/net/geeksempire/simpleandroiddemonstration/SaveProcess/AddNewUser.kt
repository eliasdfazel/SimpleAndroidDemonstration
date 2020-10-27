package net.geeksempire.simpleandroiddemonstration.SaveProcess

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.geeksempire.simpleandroiddemonstration.databinding.AddNewUserViewBinding

class AddNewUser : AppCompatActivity() {

    lateinit var addNewUserViewBinding: AddNewUserViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addNewUserViewBinding = AddNewUserViewBinding.inflate(layoutInflater)
        setContentView(addNewUserViewBinding.root)



    }

}