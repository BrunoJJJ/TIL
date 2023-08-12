// App -> project 이름으로 보통 씀
package com.example.practice.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 2) // @Database를 위해 ksp를 쓰는 것
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE User ADD COLUMN phone TEXT")
        database.execSQL("ALTER TABLE User ADD COLUMN email TEXT")
				database.execSQL("ALTER TABLE User ADD COLUMN age INTEGER")
    }
}
