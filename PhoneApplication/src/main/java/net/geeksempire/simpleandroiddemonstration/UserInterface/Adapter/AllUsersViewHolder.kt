/*
 * Copyright © 2020 By Geeks Empire.
 *
 * Created by Elias Fazel on 8/8/20 7:32 AM
 * Last modified 8/8/20 7:30 AM
 *
 * Licensed Under MIT License.
 * https://opensource.org/licenses/MIT
 */

package com.abanabsalan.aban.magazine.HomePageConfigurations.UI.Adapters.InstagramStoryHighlights

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.add_new_user_view_item.view.*

/**
 * View is For The UI of Each Item
 **/
class AllUsersViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val rootViewItem: ConstraintLayout = view.rootViewItem
    val usernameView: TextView = view.usernameView
    val emailView: TextView = view.emailAddressView
    val phoneNumberView: TextView = view.phoneNumberView
}