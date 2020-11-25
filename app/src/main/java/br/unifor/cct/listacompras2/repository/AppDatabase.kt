package br.unifor.cct.listacompras2.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import br.unifor.cct.listacompras2.model.BuyList
import br.unifor.cct.listacompras2.model.Item

@Database(entities = [BuyList::class, Item::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getBuyListDAO():BuyListDAO
    abstract fun getItemDAO():ItemDAO
}