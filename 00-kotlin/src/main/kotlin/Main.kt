import java.util.*

fun main() {
    println("Hola mundo")
    // Tipo nombre = valor
    // Int edad = 12;

    // Duck Typing

    var edadProfesor = 32
    // var edadProsor: Int = 32
    var sueldoProfesor = 1.23
    edadProfesor = 23
    sueldoProfesor = 2.33

    // Mutables / Inmutables

    // MUTABLES ( RE asignar "=")
    var edadCachorro: Int = 0
    edadCachorro = 1
    edadCachorro = 2
    edadCachorro = 3

    // INMUTABLE ( NO RE asignar "=")
    val numeroCedula = 18123123123
    // numeroCedula = 123123

    // Tipos de variables (JAVA)
    val nombreProfesor: String = "Adrian Eguez"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'S'
    val fechaNacimiento: Date = Date()

    // Condicionales

    if (true) {
        // Verdadera
    } else {
        // Falso
    }

    // switch Estado -> S -> C -> :::::
    val estadoCivilWhen: String = "S"

    when (estadoCivilWhen) {
        ("S") -> {
            println("Acercarse")
        }
        "C" -> {
            println("Alejarse")
        }
        "UN" -> println("Hablar")
        else -> println("No reconocido")
    }

    val coqueteo = if (estadoCivilWhen == "S") "SI" else "NO"
    // condicion ? bloque-true : bloque-false

    imprimirNombre("Adrian")
    //    imprimirNombre("Adrian")
//    imprimirNombre(nombre:"Adrian") -> ESTA MAL
//    imprimirNombre()

    calcularSueldo(100.00)
    calcularSueldo(100.00, 14.00)
    calcularSueldo(100.00, 14.00, 25.00)
//    calcularSueldo()

    // Named Parameters
    // calcularSueldo(15.00,12.00,150.00)
    calcularSueldo(
        bonoEspecial = 15.00,
        // tasa = 12.00
        sueldo = 150.00,
    )

    calcularSueldo(
        tasa = 14.00,
        bonoEspecial = 30.00,
        sueldo = 1000.00
    )

    // Tipos de Arreglos

    // Arreglo Estáticos
    val arregloEstatico: Array<Int> = arrayOf(1, 2, 3)
    // arregloEstatico.add(12) -> NO TENEMOS AQUI, NO SE PUEDE MODIFICAR LOS
    //                            Elementos del arreglo

    // Arreglo Dinámicos
    val arregloDinamico: ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)

    // OPERADORES -> Sirven para los arreglos estáticos y dinámicos

    // FOR EACH -> Unit
    // Iterar un arreglo

    val respuestaForEach: Unit = arregloDinamico
        .forEach { valorActual: Int ->
            println("Valor actual: ${valorActual}")
        }
    arregloDinamico
        .forEach {
            // it:Int -> El valor o los valores que van a llegar a esta funcion
            //           Si solamente se recibe 1 parametro, este se va a llamar "it"
            println("Valor actual: ${it}")
        }
    println(respuestaForEach)
    arregloDinamico
        .forEachIndexed { indice: Int, valorActual: Int ->
            println("Valor ${valorActual} Indice: ${indice}")
        }

    // MAP -> Muta el arreglo (Cambia el arreglo)
    // 1) Enviemos el nuevo valor de la iteracion
    // 2) Nos devuelve es un NUEVO ARREGLO con los valores modificados

    val respuestaMap: List<Double> = arregloDinamico
        .map { valorActual: Int ->
            return@map valorActual.toDouble() + 100.00
        }
    val respuestaMapDos = arregloDinamico.map { it + 15 }
//        .map { valorActual: Int ->
//            return@map valorActual + 15
//        }
    println(respuestaMap)
    println(respuestaMapDos)

    // Filter -> FILTRAR EL ARREGLO
    // 1) Devolver una expresion (TRUE o FALSE)
    // 2) Nuevo arreglo filtrado
    val respuestaFilter: List<Int> = arregloDinamico
        .filter { valorActual:Int ->
            val mayoresACinco: Boolean = valorActual > 5 // Expresion Condicion
            return@filter mayoresACinco
        }
    val respuestaFilterDos = arregloDinamico.filter { it <= 5 }
    println(respuestaFilter)
    println(respuestaFilterDos)


} // FIN bloque MAIN

// void imprimirNombre (String nombre){}
fun imprimirNombre(nombre: String): Unit {
    println("Nombre: ${nombre}")
}

fun calcularSueldo(
    sueldo: Double, // Requerido
    tasa: Double = 12.00, // Opcional (Defecto)
    bonoEspecial: Double? = null, // Opcional (Null) -> nullable
): Double {
    // String -> String?
    // Int -> Int?
    // Date -> Date?
    if (bonoEspecial == null) { // Indentar -> (ctrl + a) -> (ctrl + alt + l)
        return sueldo * (100 / tasa)
    } else {
        return sueldo * (100 / tasa) + bonoEspecial
    }
}




