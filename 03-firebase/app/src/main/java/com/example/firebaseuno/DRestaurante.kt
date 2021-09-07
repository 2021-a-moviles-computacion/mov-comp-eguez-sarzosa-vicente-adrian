package com.example.firebaseuno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DRestaurante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drestaurante)

        val botonCrear = findViewById<Button>(R.id.btn_crear_restaurante)
        botonCrear
            .setOnClickListener {
                crearRestaurante()
            }
        val botonDatosPrueba = findViewById<Button>(R.id. btn_datos_prueba)
        botonDatosPrueba
            .setOnClickListener {
                crearDatosPrueba()
            }
        val botonConsultar = findViewById<Button>(R.id.btn_consultar)
        botonConsultar
            .setOnClickListener {
                consultar()
            }
    }

    fun crearDatosPrueba(){
        val db = Firebase.firestore
        val cities = db.collection("cities")

        val data1 = hashMapOf(
            "name" to "San Francisco",
            "state" to "CA",
            "country" to "USA",
            "capital" to false,
            "population" to 860000,
            "regions" to listOf("west_coast", "norcal")
        )
        cities.document("SF").set(data1)

        val data2 = hashMapOf(
            "name" to "Los Angeles",
            "state" to "CA",
            "country" to "USA",
            "capital" to false,
            "population" to 3900000,
            "regions" to listOf("west_coast", "socal")
        )
        cities.document("LA").set(data2)

        val data3 = hashMapOf(
            "name" to "Washington D.C.",
            "state" to null,
            "country" to "USA",
            "capital" to true,
            "population" to 680000,
            "regions" to listOf("east_coast")
        )
        cities.document("DC").set(data3)

        val data4 = hashMapOf(
            "name" to "Tokyo",
            "state" to null,
            "country" to "Japan",
            "capital" to true,
            "population" to 9000000,
            "regions" to listOf("kanto", "honshu")
        )
        cities.document("TOK").set(data4)

        val data5 = hashMapOf(
            "name" to "Beijing",
            "state" to null,
            "country" to "China",
            "capital" to true,
            "population" to 21500000,
            "regions" to listOf("jingjinji", "hebei")
        )
        cities.document("BJ").set(data5)
    }

    fun consultar(){

        /*
            < less than
            <= less than or equal to
            == equal to
            > greater than
            >= greater than or equal to
            != not equal to
            array-contains
            array-contains-any
            in
            not-in
        * */

        val db = Firebase.firestore
        val citiesRef = db.collection("cities")
        /*
        citiesRef
            .document("BJ") // ID
            .get()
            .addOnSuccessListener {
                Log.i("consultas", "${it.data}")
            }
            .addOnFailureListener {  }

        // Buscar por un solo campo ==
        citiesRef
            .whereEqualTo("country", "China")
            .get()
            .addOnSuccessListener {
                Log.i("consultas", "${it.documents}")
                for (ciudad in it){
                    Log.i("consultas", "${ciudad.data}")
                    Log.i("consultas", "${ciudad.id}")
                }
            }
            .addOnFailureListener {  }


        // Buscar por dos o mas elementos campo '==' 'array-contains'
        citiesRef
            .whereEqualTo("capital", false)
            .whereArrayContainsAny("regions", arrayListOf("socal", "norcal"))
            .get()
            .addOnSuccessListener {
                for (ciudad in it){
                    Log.i("consultas", "== array-contains ${ciudad.data}")
                }
            }
        */

        // Buscar por dos o mas elementos campo '==' '>='
        citiesRef
            .whereEqualTo("capital", true)
            .whereGreaterThanOrEqualTo("population", 1000000)
            .get()
            .addOnSuccessListener {
                for (ciudad in it){
                    Log.i("consultas", "== array-contains ${ciudad.data}")
                }
            }




    }

    fun crearRestaurante(){
        val editTextNombre = findViewById<EditText>(R.id.et_nombre_restaurante)
        val nuevoRestaurante = hashMapOf<String, Any>(
            "nombre" to editTextNombre.text.toString()
        )
        val db = Firebase.firestore
        val referencia = db.collection("restaurante")
        referencia
            .add(nuevoRestaurante)
            .addOnSuccessListener {
                editTextNombre.text.clear()
            }
            .addOnFailureListener { }
    }










}