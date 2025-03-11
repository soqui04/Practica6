package mx.edu.itson.practica6

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SeatSelectionActivity : AppCompatActivity() {

    private lateinit var tvSeatsLeft: TextView
    private lateinit var btnConfirm: Button
    private lateinit var seatGroups: List<RadioGroup>
    private var selectedSeats = mutableListOf<Int>()
    private var pelicula: Pelicula? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        tvSeatsLeft = findViewById(R.id.tvSeatsLeft)
        btnConfirm = findViewById(R.id.btnConfirm)

        seatGroups = listOf(
            findViewById(R.id.seatRow1),
            findViewById(R.id.seatRow2),
            findViewById(R.id.seatRow3)
        )

        // Recibir datos de la película
        val tituloPelicula = intent.getStringExtra("titulo")
        pelicula = Catalogo.obtenerPeliculaPorTitulo(tituloPelicula)

        if (pelicula != null) {
            updateSeatsLeft()
            markOccupiedSeats()
        }

        btnConfirm.setOnClickListener {
            confirmSelection()
        }
    }

    private fun updateSeatsLeft() {
        val seatsAvailable = 20 - (pelicula?.seats?.size ?: 0)
        tvSeatsLeft.text = "$seatsAvailable seats available"
    }

    private fun markOccupiedSeats() {
        pelicula?.seats?.forEach { seatNumber ->
            val radioButton = findViewById<RadioButton>(seatNumber)
            radioButton?.isEnabled = false // Deshabilitar asientos ocupados
        }
    }

    private fun confirmSelection() {
        selectedSeats.clear()
        seatGroups.forEach { group ->
            val checkedId = group.checkedRadioButtonId
            if (checkedId != -1) {
                selectedSeats.add(checkedId)
            }
        }

        pelicula?.seats?.addAll(selectedSeats)
        updateSeatsLeft()
        markOccupiedSeats()
    }
}
