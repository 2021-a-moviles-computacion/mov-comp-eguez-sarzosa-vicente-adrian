package com.example.moviles_computacion_2021_b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class BListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blist_view)
        val arregloNumeros = BBaseDatosMemoria.arregloBEntrenador

        val adaptador = ArrayAdapter(
            this, // Contexto
            android.R.layout.simple_list_item_1, // Layout (visual)
            arregloNumeros // Arreglo
        )
        val listViewEjemplo = findViewById<ListView>(R.id.ltv_ejemplo)
        listViewEjemplo.adapter = adaptador

        val botonAnadirNumero = findViewById<Button>(R.id.btn_anadir_numero)
        botonAnadirNumero.setOnClickListener {
            anadirItemsAlListView(
                BEntrenador("Prueba", "d@d.com"),
                arregloNumeros,
                adaptador
            )
        }

//        listViewEjemplo
//            .setOnItemLongClickListener { adapterView, view, posicion, id ->
//
//                Log.i("list-view", "Dio click ${posicion}")
//
//                return@setOnItemLongClickListener true
//            }
         registerForContextMenu(listViewEjemplo)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)


        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

//        val info = menuInfo as AdapterView.AdapterContextMenuInfo
//        val id = info.position
        // posicionItemSeleccionado = id
    }



    fun anadirItemsAlListView(
        valor: BEntrenador,
        arreglo: ArrayList<BEntrenador>,
        adaptador: ArrayAdapter<BEntrenador>
    ) {
        arreglo.add(valor)
        adaptador.notifyDataSetChanged() // actualiza la interfaz
    }
}