package es.iescarrillo.myfirstappacr

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Clase para la main activity, extendiendo de AppCompatActivity e implementando OnClickListener
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    var btnMainToSecond: Button? = null

    /**
     * Cuando se crea la activity, se activa egde to edge (para que se adapte a los bordes del dispositivo y pone el contenido del main en pantalla. Además
     * añade el onClickListener al botón.
     * @param savedInstanceState Guarda los datos mas recientes en caso de cerrar la aplicación.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById<View?>(R.id.main),
            OnApplyWindowInsetsListener { v: View?, insets: WindowInsetsCompat? ->
                val systemBars = insets!!.getInsets(WindowInsetsCompat.Type.systemBars())
                v!!.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            })

        btnMainToSecond = findViewById<Button>(R.id.btnMainToSecond)
        btnMainToSecond!!.setOnClickListener(this)
    }

    /**
     * Al hacer click en el botón, manda al usuario a SecondActivity
     * @param v La vista sobre la que se hizo click.
     */
    override fun onClick(v: View) {
        val segundaActivity = Intent(v.getContext(), SecondActivity::class.java)
        startActivity(segundaActivity)
    }
}