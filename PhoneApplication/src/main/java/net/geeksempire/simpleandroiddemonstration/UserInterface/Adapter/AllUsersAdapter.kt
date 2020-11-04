/*
 * Copyright © 2020 By Geeks Empire.
 *
 * Created by Elias Fazel on 8/9/20 10:55 PM
 * Last modified 8/9/20 10:54 PM
 *
 * Licensed Under MIT License.
 * https://opensource.org/licenses/MIT
 */

package com.abanabsalan.aban.magazine.HomePageConfigurations.UI.Adapters.InstagramStoryHighlights

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.geeksempire.simpleandroiddemonstration.DataHolder.UserInformationDataClass
import net.geeksempire.simpleandroiddemonstration.R

interface PassDataForDeletingProcess {
    fun userData(specificDataKey: String, specificDataPosition: Int)

    fun optionProcess() {



    }
}

class AllUsersAdapter (val context: Context,
                       val passDataForDeletingProcess: PassDataForDeletingProcess) : RecyclerView.Adapter<AllUsersViewHolder>() {

    val allUsersData: ArrayList<UserInformationDataClass> = ArrayList<UserInformationDataClass>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AllUsersViewHolder {

        return AllUsersViewHolder(LayoutInflater.from(context).inflate(R.layout.add_new_user_view_item, viewGroup, false))
    }

    override fun getItemCount(): Int {

        return allUsersData.size
    }

    override fun onBindViewHolder(allUsersViewHolder: AllUsersViewHolder, position: Int) {

        allUsersViewHolder.usernameView.text = allUsersData[position].uniqueUsername

        allUsersViewHolder.emailView.text = allUsersData[position].emailAddress

        allUsersViewHolder.phoneNumberView.text = allUsersData[position].phoneNumber

        allUsersViewHolder.rootViewItem.setOnClickListener {

        }

        allUsersViewHolder.rootViewItem.setOnLongClickListener {

            passDataForDeletingProcess.userData(
                allUsersData[position].phoneNumber,
                position
            )

            true
        }

    }

}