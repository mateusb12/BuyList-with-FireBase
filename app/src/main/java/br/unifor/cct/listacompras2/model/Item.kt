package br.unifor.cct.listacompras2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item (
        @PrimaryKey var id: Int? = null,
        var name: String,
        var quantity: Int,
        var price: Double,
        var description: String?,
        @ColumnInfo(name = "buy_list_id") var buyListId: Int
)