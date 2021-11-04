package com.delnortedevs.roomsencillo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(applicationContext,AppDatabase::class.java,"dbtest").build()


        lifecycleScope.launch {

            withContext(Dispatchers.IO) {

                //   val empleadoBusqueda = db.DaoPrincipal().getByName("Jorge")

                //   Log.d("DBTEST", empleadoBusqueda.id.toString() + empleadoBusqueda.nombre)

                val empleado = Empleado(1, "Jorge Flores", "RH")
                db.DaoPrincipal().eliminarEmplado(empleado)

                val todosEmpleados = db.DaoPrincipal().getAll()
                Log.d("DBTEST", todosEmpleados.size.toString())

            }
        }


    }
}