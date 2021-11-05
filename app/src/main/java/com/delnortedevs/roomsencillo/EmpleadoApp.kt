package com.delnortedevs.roomsencillo

import android.app.Application

class EmpleadoApp : Application()   {

    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }

}