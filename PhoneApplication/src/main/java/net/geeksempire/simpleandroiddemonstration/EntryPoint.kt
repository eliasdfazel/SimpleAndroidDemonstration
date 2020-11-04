package net.geeksempire.simpleandroiddemonstration

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abanabsalan.aban.magazine.HomePageConfigurations.UI.Adapters.InstagramStoryHighlights.AllUsersAdapter
import net.geeksempire.simpleandroiddemonstration.DatabaseProcess.UserInformationProcess
import net.geeksempire.simpleandroiddemonstration.Extensions.setupColorsOfViews
import net.geeksempire.simpleandroiddemonstration.SaveProcess.AddNewUser
import net.geeksempire.simpleandroiddemonstration.databinding.EntryPointViewBinding

class EntryPoint : AppCompatActivity() {

    var specificDataKey: String? = null
    var specificDataPosition: Int? = null

    private val userInformationProcess: UserInformationProcess = UserInformationProcess()

    private val allUsersAdapter: AllUsersAdapter by lazy {
        AllUsersAdapter(this@EntryPoint)
    }

    lateinit var entryPointViewBinding: EntryPointViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        entryPointViewBinding = EntryPointViewBinding.inflate(layoutInflater)
        setContentView(entryPointViewBinding.root)

        setupColorsOfViews()

        entryPointViewBinding.recyclerView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)

        entryPointViewBinding.recyclerView.adapter = allUsersAdapter

        entryPointViewBinding.addNewUser.setOnClickListener {

            startActivity(Intent(applicationContext, AddNewUser::class.java))

        }

        entryPointViewBinding.deleteView.setOnClickListener {

            if (specificDataKey != null && specificDataPosition != null) {

                userInformationProcess.deleteSpecificData(applicationContext, specificDataKey!!)

//                allUsersAdapter.allUsersData.clear()
//                allUsersAdapter.allUsersData.addAll(userInformationProcess.realAllSavedData(applicationContext))
//                allUsersAdapter.notifyDataSetChanged()

                allUsersAdapter.notifyItemRemoved(specificDataPosition!!)

                entryPointViewBinding.deleteView.visibility = View.INVISIBLE

            }

        }

    }

    override fun onResume() {
        super.onResume()

        allUsersAdapter.allUsersData.clear()

        allUsersAdapter.allUsersData.addAll(userInformationProcess.realAllSavedData(applicationContext))

        allUsersAdapter.notifyDataSetChanged()

    }

}