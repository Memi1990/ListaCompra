package com.example.listacompra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listacompra.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var b:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityResultBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.tvLista.text = "LISTA\n\n"
        val myExtras = intent.extras
        if (myExtras != null){
            val keys = myExtras.keySet()
            for (key in keys){
                if (key != "TOTAL"){
                b.tvLista.text = b.tvLista.text.toString()
                    .plus("$key:\t\t\t${myExtras.get(key)}\n")
                }
            }
            b.tvLista.text =  b.tvLista.text.toString()
                .plus("El total de su compra es: ${myExtras.get("TOTAL")}€")
        }
        b.btnVolver.setOnClickListener {
            onBackPressed()
        }

    }
    fun msj (str:String){
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}