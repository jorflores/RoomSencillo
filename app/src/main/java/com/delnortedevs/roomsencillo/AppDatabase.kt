package com.delnortedevs.roomsencillo

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Empleado::class], version = 1)
abstract class AppDatabase : RoomDatabase()   {

    abstract fun DaoPrincipal(): EmpleadoDao

}