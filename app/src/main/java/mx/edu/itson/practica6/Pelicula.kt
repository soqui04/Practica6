package mx.edu.itson.practica6

data class Pelicula(
    val titulo: String,
    val imagen: Int,
    val descripcion: String,
    val header: Int,
    val categoria: String, // "Pelicula" o "Serie"
    val seats: ArrayList<Int> = arrayListOf() // Lista de asientos ocupados
)