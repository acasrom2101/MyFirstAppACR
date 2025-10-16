package es.iescarrillo.myfirstappacr

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Clase para la second activity, extendiendo de AppCompatActivity e implementando OnClickListener
 */
class SecondActivity : AppCompatActivity(), View.OnClickListener {
    var btnSegundoEnviarATercero: Button? = null
    var campoTexto: EditText? = null
    var campoEntero: EditText? = null
    var campoDecimal: EditText? = null
    var interruptorBoolean: Switch? = null
    var campoTextoEscrito: Boolean = false
    var campoEnteroEscrito: Boolean = false
    var campoDecimalEscrito: Boolean = false

    /**
     * Cuando se crea la activity, se activa egde to edge (para que se adapte a los bordes del dispositivo y pone el contenido del main en pantalla. A continuación
     * carga las vistas de los EditText, el botón de continuar y el switch. Finalmente, añade OnClickListener al botón que va a la tercera página.
     * @param savedInstanceState Guarda los datos mas recientes en caso de cerrar la aplicación.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById<View?>(R.id.main),
            OnApplyWindowInsetsListener { v: View?, insets: WindowInsetsCompat? ->
                val systemBars = insets!!.getInsets(WindowInsetsCompat.Type.systemBars())
                v!!.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            })

        btnSegundoEnviarATercero = findViewById<Button>(R.id.btnSecondSendFormToThird)
        campoTexto = findViewById<EditText>(R.id.campoTexto)
        campoEntero = findViewById<EditText>(R.id.campoEntero)
        campoDecimal = findViewById<EditText>(R.id.campoDecimal)
        interruptorBoolean = findViewById<Switch>(R.id.interruptorBoolean)

        btnSegundoEnviarATercero!!.setOnClickListener(this)
    }

    /**
     * Al hacer click en el botón, analiza el contenido de los campos de texto. Si falta algo, avisa al usuario con un toast. Si no falta nada, lo carga en el
     * intent y lo manda a ThidActivity.
     * @param v La vista sobre la que se hizo click.
     */
    override fun onClick(v: View) {
        campoTextoEscrito = campoTexto!!.getText().toString().isEmpty()
        campoEnteroEscrito = campoEntero!!.getText().toString().isEmpty()
        campoDecimalEscrito = campoDecimal!!.getText().toString().isEmpty()
        if (campoTextoEscrito) {
            Toast.makeText(this, "Debe escribir algo en el campo de texto", Toast.LENGTH_LONG)
                .show()
        }
        if (campoEnteroEscrito) {
            Toast.makeText(
                this,
                "Debe escribir un número en el campo de enteros",
                Toast.LENGTH_LONG
            ).show()
        }
        if (campoDecimalEscrito) {
            Toast.makeText(
                this,
                "Debe escribir un número en el campo de decimales",
                Toast.LENGTH_LONG
            ).show()
        }
        if (!campoTextoEscrito && !campoEnteroEscrito && !campoDecimalEscrito) {
            val terceraActivity = Intent(v.getContext(), ThirdActivity::class.java)
            terceraActivity.putExtra("datosCampoTexto", campoTexto!!.getText().toString())
            terceraActivity.putExtra("datosCampoEntero", campoEntero!!.getText().toString())
            terceraActivity.putExtra("datosCampoDecimal", campoDecimal!!.getText().toString())
            terceraActivity.putExtra("posicionInterruptor", interruptorBoolean!!.isChecked())
            startActivity(terceraActivity)
        }
    }
}