package com.patlejch.timetables.di

import android.content.Context
import androidx.room.Room
import com.patlejch.timetables.data.database.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { createDatabase(get()) }
    single { createFilterDao(get()) }
}

fun createDatabase(context: Context): AppDatabase =
    Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.NAME).build()

fun createFilterDao(db: AppDatabase) =
    db.filterDao()
