package mx.edu.itson.practica6

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class Catalogo : AppCompatActivity() {

    companion object {
        private val peliculas = listOf(
            Pelicula("Dune", R.drawable.dune, "Película de ciencia ficción basada en la novela de Frank Herbert.", R.drawable.dune, "Pelicula", arrayListOf()),
            Pelicula("Ghostbusters", R.drawable.ghostbusters, "Comedia y ciencia ficción con cazadores de fantasmas en acción.", R.drawable.ghostbusters, "Pelicula", arrayListOf()),
            Pelicula("Madame Web", R.drawable.madameweb, "Historia de la heroína del universo Spider-Man.", R.drawable.madameweb, "Pelicula", arrayListOf())
        )

        private val series = listOf(
            Pelicula("Halo", R.drawable.halo, "Serie basada en el popular videojuego de ciencia ficción.", R.drawable.halo, "Serie", arrayListOf()),
            Pelicula("Demon Slayer", R.drawable.demon, "Anime de acción y fantasía sobre cazadores de demonios.", R.drawable.demon, "Serie", arrayListOf()),
            Pelicula("El Monstruo", R.drawable.elmonstruo, "Serie de suspenso con giros inesperados.", R.drawable.elmonstruo, "Serie", arrayListOf())
        )

        // Método para encontrar una película por título
        fun obtenerPeliculaPorTitulo(titulo: String?): Pelicula? {
            return peliculas.find { it.titulo == titulo } ?: series.find { it.titulo == titulo }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalogo)

        val gridViewPeliculas = findViewById<GridView>(R.id.movies_catalogo)
        val gridViewSeries = findViewById<GridView>(R.id.series_catalogo)

        gridViewPeliculas.adapter = PeliculasAdapter(this, ArrayList(peliculas))
        gridViewSeries.adapter = PeliculasAdapter(this, ArrayList(series))
    }
}
