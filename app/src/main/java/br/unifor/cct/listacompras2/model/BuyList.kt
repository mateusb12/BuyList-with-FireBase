package br.unifor.cct.listacompras2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "buy_lists")
data class BuyList(
        @PrimaryKey var id: Int?=null,
        var name:String?,
        var description: String?
)