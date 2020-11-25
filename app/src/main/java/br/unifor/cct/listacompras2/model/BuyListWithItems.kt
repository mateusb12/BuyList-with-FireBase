package br.unifor.cct.listacompras2.model

import androidx.room.Embedded
import androidx.room.Relation

data class BuyListWithItems (
        @Embedded var buyList:BuyList,
        @Relation(
                parentColumn = "id",
                entityColumn = "buy_list_id"
        )
        var items:List<Item>
)