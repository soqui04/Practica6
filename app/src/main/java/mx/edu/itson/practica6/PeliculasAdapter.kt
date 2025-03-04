package mx.edu.itson.practica6

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class PeliculasAdapter(private val context: Context, private val peliculas: List<Pelicula>) : BaseAdapter() {

    override fun getCount(): Int {
        return peliculas.size
    }

    override fun getItem(position: Int): Any {
        return peliculas[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val pelicula = peliculas[position]
        val inflador = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val vista = inflador.inflate(R.layout.pelicula, null)

        val imagen = vista.findViewById<ImageView>(R.id.image_movie_cell)
        val titulo = vista.findViewById<TextView>(R.id.movie_title_cell)

        imagen.setImageResource(pelicula.imagen)
        titulo.text = pelicula.titulo

        vista.setOnClickListener {
            val intent = Intent(context, DetallePelicula::class.java)
            intent.putExtra("titulo", pelicula.titulo)
            intent.putExtra("header", pelicula.header)
            intent.putExtra("sinopsis", pelicula.descripcion)
            context.startActivity(intent)
        }

        return vista
    }
}