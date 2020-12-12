/*
 * Copyright © 2020 By Geeks Empire.
 *
 * Created by Elias Fazel on 3/24/20 1:15 PM
 * Last modified 3/24/20 10:35 AM
 *
 * Licensed Under MIT License.
 * https://opensource.org/licenses/MIT
 */

package net.geekstools.floatshort.PRO.Widgets.RoomDatabase

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val DatabaseName = "WidgetData"

@Entity(tableName = DatabaseName)
data class DatabaseModel(
        @NonNull @PrimaryKey var uniqueUsername: String,

        @NonNull @ColumnInfo(name = "emailAddress") var emailAddress: String,
        @NonNull @ColumnInfo(name = "phoneNumber") var phoneNumber: String,
        @Nullable @ColumnInfo(name = "phoneCountryCode") var phoneCountryCode: String = "0098",
        @Nullable @ColumnInfo(name = "cityName") var cityName: String = "Mashhad",
        @NonNull @ColumnInfo(name = "selectedItem") var selectedItem: Boolean = false
)