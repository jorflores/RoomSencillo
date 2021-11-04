package com.delnortedevs.roomsencillo

import androidx.room.*

@Dao
interface EmpleadoDao {

    @Query("SELECT * from EMPLEADO")
    suspend fun getAll(): List<Empleado>

    @Query("SELECT * from EMPLEADO where nombre = :nombre")
    suspend fun getByName(nombre: String): Empleado

    @Insert
    suspend fun addEmplado(empleado: Empleado)

    @Insert
    suspend fun addEmplados(listaempleado: List<Empleado>)

    @Update
    suspend fun actualizarEmplado(empleado: Empleado)

    @Delete
    suspend fun eliminarEmplado(empleado: Empleado)

}