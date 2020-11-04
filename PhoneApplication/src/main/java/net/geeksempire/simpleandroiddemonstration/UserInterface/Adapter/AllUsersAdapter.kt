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

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.geeksempire.simpleandroiddemonstration.DataHolder.UserInformationDataClass
import net.geeksempire.simpleandroiddemonstration.EntryPoint
import net.geeksempire.simpleandroiddemonstration.R

class AllUsersAdapter (val entryPoint: EntryPoint) : RecyclerView.Adapter<AllUsersViewHolder>() {

    val allUsersData: ArrayList<UserInformationDataClass> = ArrayList<UserInformationDataClass>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AllUsersViewHolder {

        return AllUsersViewHolder(LayoutInflater.from(entryPoint).inflate(R.layout.add_new_user_view_item, viewGroup, false))
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

            entryPoint.specificDataPosition = position
            entryPoint.specificDataKey = allUsersData[position].phoneNumber

            entryPoint.entryPointViewBinding.deleteView.visibility = View.VISIBLE

            true
        }

    }

}