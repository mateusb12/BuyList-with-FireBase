package br.unifor.cct.listacompras2.repository

import androidx.room.*
import br.unifor.cct.listacompras2.model.Item

@Dao
interface ItemDAO {

    @Insert
    fun insert(item: Item)

    @Update
    fun update(item: Item)

    @Delete
    fun delete(item: Item)

    @Query("SELECT * FROM items WHERE id = :id")
    fun find(id: Int): Item

    @Query("SELECT * FROM items")
    fun findAll(): List<Item>
}