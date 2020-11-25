package br.unifor.cct.listacompras2.repository

import androidx.room.*
import br.unifor.cct.listacompras2.model.BuyList
import br.unifor.cct.listacompras2.model.BuyListWithItems

@Dao
interface BuyListDAO {
    @Insert
    fun insert(buyList: BuyList)

    @Update
    fun update(buyList: BuyList)

    @Delete
    fun delete(buyList: BuyList)

    @Query("SELECT * FROM buy_lists WHERE id = :id")
    fun find(id: Int): BuyList

    @Query("SELECT * FROM buy_lists")
    fun findAll():List<BuyList>

    @Transaction
    @Query("SELECT * FROM buy_lists WHERE id = :id")
    fun findAllItemsByListId(id:Int): BuyListWithItems
}