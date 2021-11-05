package com.delnortedevs.roomsencillo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.delnortedevs.roomsencillo.viewmodels.EmpleadoViewModel
import com.delnortedevs.roomsencillo.viewmodels.EmpleadosViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {


    // Activity / fragment class
    private lateinit var viewModel: EmpleadoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // onCreate
        viewModel = ViewModelProvider(
            this, EmpleadosViewModelFactory((application as EmpleadoApp).database.DaoPrincipal())).get(EmpleadoViewModel::class.java)

       // val db = Room.databaseBuilder(applicationContext,AppDatabase::class.java,"dbtest").build()

        lifecycleScope.launch {

            withContext(Dispatchers.IO) {

                //   val empleadoBusqueda = db.DaoPrincipal().getByName("Jorge")

                //   Log.d("DBTEST", empleadoBusqueda.id.toString() + empleadoBusqueda.nombre)

                val empleado = Empleado(1, "Jorge Flores", "RH")
                viewModel.addEmplado(empleado)
               // db.DaoPrincipal().eliminarEmplado(empleado)


                val todosEmpleados = viewModel.getAll()
               // val todosEmpleados = db.DaoPrincipal().getAll()
                Log.d("DBTEST", todosEmpleados.size.toString())

            }
        }


    }
}