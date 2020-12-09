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
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.geeksempire.simpleandroiddemonstration.DataHolder.UserInformationDataClass
import net.geeksempire.simpleandroiddemonstration.R

interface PassUserDataProcess {
    fun userDataToDelete(specificDataKey: String, specificDataPosition: Int)
}

object ViewType {
    const val TypeMashhad = 0
    const val TypeTehran = 1
}

class AllUsersAdapter (val context: Context,
                       val passUserDataProcess: PassUserDataProcess) : RecyclerView.Adapter<AllUsersViewHolder>() {

    val allUsersData: ArrayList<UserInformationDataClass> = ArrayList<UserInformationDataClass>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AllUsersViewHolder {

        return if (viewType == ViewType.TypeMashhad) {

            AllUsersViewHolder(LayoutInflater.from(context).inflate(R.layout.add_new_user_view_item, viewGroup, false))

        } else {

            AllUsersViewHolder(LayoutInflater.from(context).inflate(R.layout.add_new_user_view_item_red, viewGroup, false))

        }
    }

    override fun getItemViewType(position: Int) : Int {
        super.getItemViewType(position)

        return if (position % 2 == 0) {
            ViewType.TypeMashhad
        } else {
            ViewType.TypeTehran
        }
    }

    override fun getItemCount(): Int {

        return allUsersData.size
    }

    override fun onBindViewHolder(allUsersViewHolder: AllUsersViewHolder, position: Int, payloads: MutableList<Any>) {

        if (payloads.isNotEmpty()) {

            allUsersViewHolder.usernameView.text = allUsersData[position].uniqueUsername

            allUsersViewHolder.emailView.text = allUsersData[position].emailAddress

            allUsersViewHolder.phoneNumberView.text = allUsersData[position].phoneNumber

        } else {
            super.onBindViewHolder(allUsersViewHolder, position, payloads)
        }

    }

    override fun onBindViewHolder(allUsersViewHolder: AllUsersViewHolder, position: Int) {

        allUsersViewHolder.usernameView.text = allUsersData[position].uniqueUsername

        allUsersViewHolder.emailView.text = allUsersData[position].emailAddress

        allUsersViewHolder.phoneNumberView.text = allUsersData[position].phoneNumber

        allUsersViewHolder.backgroundItem.setImageDrawable(context.getDrawable(android.R.drawable.ic_dialog_map))

        if (allUsersData[position].selectedItem) {

            allUsersViewHolder.selectedItem.visibility = View.VISIBLE

        } else {

            allUsersViewHolder.selectedItem.visibility = View.INVISIBLE

        }


        allUsersViewHolder.rootViewItem.setOnClickListener {

        }

        allUsersViewHolder.rootViewItem.setOnLongClickListener {

            if (allUsersViewHolder.selectedItem.isShown) {

                allUsersData[position].selectedItem = false

                allUsersViewHolder.selectedItem.visibility = View.INVISIBLE

            } else {

                allUsersData[position].selectedItem = true

                allUsersViewHolder.selectedItem.visibility = View.VISIBLE

            }

//            println("*** 1. ${allUsersData[position].phoneNumber} -- ${position}")

//            passUserDataProcess.userDataToDelete(
//                allUsersData[position].phoneNumber,
//                position
//            )

            true
        }

    }

}