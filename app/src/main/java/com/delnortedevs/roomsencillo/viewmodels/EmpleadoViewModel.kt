package com.delnortedevs.roomsencillo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.delnortedevs.roomsencillo.Empleado
import com.delnortedevs.roomsencillo.EmpleadoDao

class EmpleadoViewModel (private val empleadoDao : EmpleadoDao) : ViewModel()  {

    suspend fun getAll() : List<Empleado> = empleadoDao.getAll()

    suspend fun getByName(nombre: String): Empleado = empleadoDao.getByName(nombre)

    suspend fun addEmplado(empleado: Empleado) = empleadoDao.addEmplado(empleado)

    suspend fun addEmplados(listaempleado: List<Empleado>) = empleadoDao.addEmplados(listaempleado)

    suspend fun actualizarEmplado(empleado: Empleado) = empleadoDao.actualizarEmplado(empleado)

    suspend fun eliminarEmplado(empleado: Empleado) = empleadoDao.eliminarEmplado(empleado)

}

class EmpleadosViewModelFactory (private val empleadoDao: EmpleadoDao) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EmpleadoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EmpleadoViewModel(empleadoDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}