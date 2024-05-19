package com.example.calc.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Activity::class, Event::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ActivityDatabase: RoomDatabase() {

    abstract fun activityDao(): ActivityDao

    companion object{
        @Volatile
        private var INSTANCE: ActivityDatabase? = null

        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS `events` (`eventName` TEXT NOT NULL, `eventIcon` TEXT NOT NULL, `eventDescription` TEXT NOT NULL, `eventStartTime` TEXT NOT NULL, `eventEndTime` TEXT NOT NULL, `eventAssigned` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)")
            }
        }

        fun getDatabase(context: Context): ActivityDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ActivityDatabase::class.java,
                    "activity_database"
                ).addMigrations(MIGRATION_1_2).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}