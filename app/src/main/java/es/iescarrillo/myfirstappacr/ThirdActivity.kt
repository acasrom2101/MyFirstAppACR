package es.iescarrillo.myfirstappacr

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Clase para la second activity, extendiendo de AppCompatActivity e implementando OnClickListener
 */
class ThirdActivity : AppCompatActivity(), View.OnClickListener {
    var btnTerceroVolverAPrimero: Button? = null
    var campoResultadoString: TextView? = null
    var campoResultadoEntero: TextView? = null
    var campoResultadoDecimal: TextView? = null
    var campoEstadoInterruptor: TextView? = null

    /**
     * Cuando se crea la activity, se activa egde to edge (para que se adapte a los bordes del dispositivo y pone el contenido del main en pantalla. Ahora
     * carga las vistas de los textView y el botón de volver al main. Para terminar, añade OnClickListener al botón de volver y llama al metodo mostrar resultados.
     * @param savedInstanceState Guarda los datos mas recientes en caso de cerrar la aplicación.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_third)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById<View?>(R.id.main),
            OnApplyWindowInsetsListener { v: View?, insets: WindowInsetsCompat? ->
                val systemBars = insets!!.getInsets(WindowInsetsCompat.Type.systemBars())
                v!!.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            })

        btnTerceroVolverAPrimero = findViewById<Button>(R.id.btnThirdReturnToFirst)
        campoResultadoString = findViewById<TextView>(R.id.tvResultadoTexto)
        campoResultadoEntero = findViewById<TextView>(R.id.tvResultadoEntero)
        campoResultadoDecimal = findViewById<TextView>(R.id.tvResultadoDecimal)
        campoEstadoInterruptor = findViewById<TextView>(R.id.tvEstadoInterruptor)

        btnTerceroVolverAPrimero!!.setOnClickListener(this)

        mostrarResultados()
    }

    /**
     * Carga el contenido del intent de SecondActivity en sus respectivas variables y cambia el texto de los textView para que incluyan los valores del usuario.
     */
    fun mostrarResultados() {
        val intent = getIntent()
        val stringUsuario = intent.getStringExtra("datosCampoTexto")
        val enteroUsuario = intent.getStringExtra("datosCampoEntero")
        val decimalUsuario = intent.getStringExtra("datosCampoDecimal")
        var interruptorUsuario = false
        interruptorUsuario = intent.getBooleanExtra("posicionInterruptor", interruptorUsuario)

        campoResultadoString!!.setText("Campo de texto: " + stringUsuario)
        campoResultadoEntero!!.setText("Campo de número entero: " + enteroUsuario)
        campoResultadoDecimal!!.setText("Campo de número decimal: " + decimalUsuario)
        if (interruptorUsuario) {
            campoEstadoInterruptor!!.setText("Estado del interruptor: ACTIVADO")
        } else {
            campoEstadoInterruptor!!.setText("Estado del interruptor: DESACTIVADO")
        }
    }

    /**
     * Al hacer click en el botón, manda al usuario de vuelta a MainActivity
     * @param v La vista sobre la que se hizo click.
     */
    override fun onClick(v: View) {
        val primeraActivity = Intent(v.getContext(), MainActivity::class.java)
        startActivity(primeraActivity)
    }
}