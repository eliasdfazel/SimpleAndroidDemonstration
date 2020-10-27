package net.geeksempire.simpleandroiddemonstration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abanabsalan.aban.magazine.HomePageConfigurations.UI.Adapters.InstagramStoryHighlights.AllUsersAdapter
import net.geeksempire.simpleandroiddemonstration.DatabaseProcess.UserInformationProcess
import net.geeksempire.simpleandroiddemonstration.Extensions.setupColorsOfViews
import net.geeksempire.simpleandroiddemonstration.databinding.EntryPointViewBinding

class EntryPoint : AppCompatActivity() {

    val userInformationProcess: UserInformationProcess = UserInformationProcess()

    lateinit var entryPointViewBinding: EntryPointViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        entryPointViewBinding = EntryPointViewBinding.inflate(layoutInflater)
        setContentView(entryPointViewBinding.root)

        setupColorsOfViews()


        entryPointViewBinding.recyclerView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)

        val allUsersAdapter = AllUsersAdapter(applicationContext)

        allUsersAdapter.allUsersData.addAll(userInformationProcess.realAllSavedData(applicationContext))

        entryPointViewBinding.recyclerView.adapter = allUsersAdapter



    }

}