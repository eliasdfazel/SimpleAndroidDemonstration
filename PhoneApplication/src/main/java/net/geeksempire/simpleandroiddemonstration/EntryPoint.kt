package net.geeksempire.simpleandroiddemonstration

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abanabsalan.aban.magazine.HomePageConfigurations.UI.Adapters.InstagramStoryHighlights.AllUsersAdapter
import com.abanabsalan.aban.magazine.HomePageConfigurations.UI.Adapters.InstagramStoryHighlights.PassUserDataProcess
import net.geeksempire.simpleandroiddemonstration.DatabaseProcess.AfterBackgroundProcess
import net.geeksempire.simpleandroiddemonstration.DatabaseProcess.UserInformationProcess
import net.geeksempire.simpleandroiddemonstration.Extensions.setupColorsOfViews
import net.geeksempire.simpleandroiddemonstration.SaveProcess.AddNewUser
import net.geeksempire.simpleandroiddemonstration.databinding.EntryPointViewBinding

class EntryPoint : AppCompatActivity(), PassUserDataProcess, AfterBackgroundProcess {

    val userInformationProcess: UserInformationProcess = UserInformationProcess()

    lateinit var allUsersAdapter: AllUsersAdapter

    lateinit var entryPointViewBinding: EntryPointViewBinding

    var databaseSize = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        entryPointViewBinding = EntryPointViewBinding.inflate(layoutInflater)
        setContentView(entryPointViewBinding.root)

        setupColorsOfViews()

        allUsersAdapter = AllUsersAdapter(applicationContext, this@EntryPoint)

        entryPointViewBinding.recyclerView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)

        entryPointViewBinding.recyclerView.adapter = allUsersAdapter

        entryPointViewBinding.addNewUser.setOnClickListener {

            startActivity(Intent(applicationContext, AddNewUser::class.java))

        }

        userInformationProcess.setupAdapterData(this@EntryPoint, this@EntryPoint)

        databaseSize = userInformationProcess.databaseSize(applicationContext)

    }

    override fun onResume() {
        super.onResume()

        if (userInformationProcess.databaseSize(applicationContext) > databaseSize) {

            userInformationProcess.setupAdapterData(this@EntryPoint, this@EntryPoint)

        }

    }

    override fun onBackPressed() {

        entryPointViewBinding.deleteView.visibility = View.INVISIBLE

    }

    override fun userDataToDelete(specificDataKey: String, specificDataPosition: Int) {

        println("*** 2. ${specificDataKey} -- ${specificDataPosition}")

        entryPointViewBinding.deleteView.visibility = View.VISIBLE

        entryPointViewBinding.deleteView.setOnClickListener {

            allUsersAdapter.allUsersData.removeAt(specificDataPosition)

            userInformationProcess.deleteSpecificData(applicationContext, specificDataKey)

            allUsersAdapter.notifyItemRemoved(specificDataPosition)
            allUsersAdapter.notifyItemRangeChanged(specificDataPosition, allUsersAdapter.allUsersData.size)

            databaseSize = userInformationProcess.databaseSize(applicationContext)

            entryPointViewBinding.deleteView.visibility = View.INVISIBLE

        }

    }

    override fun notifyUserInterfaceForData() {

        runOnUiThread {

            //Foreground
            allUsersAdapter.notifyDataSetChanged()

        }

    }

}