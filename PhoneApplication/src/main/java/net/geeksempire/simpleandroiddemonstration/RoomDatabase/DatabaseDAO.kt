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

    //Insert NEW Data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewWidgetDataSuspend(vararg arrayOfDatabaseModels: DatabaseModel)

    //Update Current Data
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateWidgetDataSuspend(vararg arrayOfDatabaseModels: DatabaseModel)

    @Delete
    suspend fun deleteSuspend(databaseModel: DatabaseModel)



    @Query("SELECT * FROM WidgetData ORDER BY emailAddress ASC")
    suspend fun getAllWidgetDataSuspend(): List<DatabaseModel>


    @Query("SELECT * FROM WidgetData WHERE emailAddress IN (:emailAddress) AND phoneCountryCode IN (:phoneCountryCode)")
    suspend fun loadWidgetByClassNameProviderWidgetSuspend(emailAddress: String, phoneCountryCode: String): DatabaseModel










    @Query("UPDATE WidgetData SET WidgetId = :WidgetId WHERE PackageName = :PackageName AND ClassNameProvider == :ClassNameProvider")
    suspend fun updateWidgetIdByPackageNameClassNameSuspend(PackageName: String, ClassNameProvider: String, WidgetId: Int): Int


    @Query("UPDATE WidgetData SET WidgetLabel = :WidgetLabel WHERE WidgetId = :WidgetId")
    suspend fun updateWidgetLabelByWidgetIdSuspend(WidgetId: Int, WidgetLabel: String): Int


    @Query("UPDATE WidgetData SET Recovery = :AddedWidgetRecovery WHERE PackageName= :PackageName AND ClassNameProvider = :ClassNameWidgetProvider")
    suspend fun updateRecoveryByClassNameProviderWidgetSuspend(PackageName: String, ClassNameWidgetProvider: String, AddedWidgetRecovery: Boolean): Int


    @Query("DELETE FROM WidgetData WHERE PackageName = :PackageName AND ClassNameProvider = :ClassNameWidgetProvider")
    suspend fun deleteByWidgetClassNameProviderWidgetSuspend(PackageName: String, ClassNameWidgetProvider: String)

    @Query("SELECT COUNT(IdKey) FROM WidgetData")
    suspend fun getRowCountSuspend(): Int
}