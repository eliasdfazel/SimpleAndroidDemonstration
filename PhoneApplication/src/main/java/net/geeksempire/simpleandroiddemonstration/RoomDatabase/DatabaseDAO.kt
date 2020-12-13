/*
 * Copyright © 2020 By Geeks Empire.
 *
 * Created by Elias Fazel
 * Last modified 5/18/20 2:39 PM
 *
 * Licensed Under MIT License.
 * https://opensource.org/licenses/MIT
 */

package net.geekstools.floatshort.PRO.Widgets.RoomDatabase

import androidx.room.*

@Dao
interface DatabaseDAO {

    //Use It Inside Coroutines
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewWidgetDataSuspend(vararg arrayOfDatabaseModels: DatabaseModel)


    //Use It Inside Thread
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertNewWidgetDataSuspend(vararg arrayOfDatabaseModels: DatabaseModel)


    //Update Current Data
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateWidgetDataSuspend(vararg arrayOfDatabaseModels: DatabaseModel)


    @Delete
    suspend fun deleteSuspend(databaseModel: DatabaseModel)


    @Query("SELECT * FROM WidgetData ORDER BY emailAddress ASC")
    suspend fun getAllWidgetDataSuspend(): List<DatabaseModel>


    @Query("SELECT * FROM WidgetData WHERE emailAddress IN (:emailAddress) AND phoneCountryCode IN (:phoneCountryCode)")
    suspend fun loadWidgetByClassNameProviderWidgetSuspend(emailAddress: String, phoneCountryCode: String): DatabaseModel


    @Query("UPDATE WidgetData SET emailAddress = :WidgetId WHERE emailAddress = :emailAddress AND phoneCountryCode = :phoneCountryCode")
    suspend fun updateWidgetIdByPackageNameClassNameSuspend(WidgetId: Int, emailAddress: String, phoneCountryCode: String): Int


    @Query("DELETE FROM WidgetData WHERE emailAddress = :emailAddress AND phoneCountryCode = :phoneCountryCode")
    suspend fun deleteByWidgetClassNameProviderWidgetSuspend(emailAddress: String, phoneCountryCode: String)


    @Query("SELECT COUNT(uniqueUsername) FROM WidgetData")
    suspend fun getRowCountSuspend(): Int
}