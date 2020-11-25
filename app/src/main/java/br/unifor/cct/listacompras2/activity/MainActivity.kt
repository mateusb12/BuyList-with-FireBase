package br.unifor.cct.listacompras2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import br.unifor.cct.listacompras2.R
import br.unifor.cct.listacompras2.model.BuyList
import br.unifor.cct.listacompras2.repository.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bl1 = BuyList(name="Farmácia", description=null)
        val bl2 = BuyList(name="Mercado", description=null)
        val bl3 = BuyList(name="Feira", description=null)

        val db = Room.databaseBuilder(this, AppDatabase::class.java, "buildlist.db").build()

        GlobalScope.launch {
            db.getBuyListDAO().insert(bl1)
            db.getBuyListDAO().insert(bl2)
            db.getBuyListDAO().insert(bl3)

            val buyLists = db.getBuyListDAO().findAll()
            buyLists.forEach {
                Log.i("App", "${it.id} → ${it.name}")
            }
        }
    }
}