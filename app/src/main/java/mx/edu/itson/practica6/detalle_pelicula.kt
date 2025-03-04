package mx.edu.itson.practica6

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetallePelicula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val ivPeliculaImage: ImageView = findViewById(R.id.iv_pelicula_imagen)
        val tvNombrePelicula: TextView = findViewById(R.id.tv_nombre_pelicula)
        val tvPeliculaDesc: TextView = findViewById(R.id.tv_pelicula_desc)

        val bundle = intent.extras
        if (bundle != null) {
            ivPeliculaImage.setImageResource(bundle.getInt("header"))
            tvNombrePelicula.text = bundle.getString("titulo")
            tvPeliculaDesc.text = bundle.getString("sinopsis")
        }
    }
}