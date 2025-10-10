package es.iescarrillo.myfirstappacr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Clase para la main activity, extendiendo de AppCompatActivity e implementando OnClickListener
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMainToSecond;

    /**
     * Cuando se crea la activity, se activa egde to edge (para que se adapte a los bordes del dispositivo y pone el contenido del main en pantalla. Además
     * añade el onClickListener al botón.
     * @param savedInstanceState Guarda los datos mas recientes en caso de cerrar la aplicación.
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnMainToSecond = findViewById(R.id.btnMainToSecond);
        btnMainToSecond.setOnClickListener(this);
    }

    /**
     * Al hacer click en el botón, manda al usuario a SecondActivity
     * @param v La vista sobre la que se hizo click.
     */
    @Override
    public void onClick(View v) {
        Intent segundaActivity = new Intent(v.getContext(), SecondActivity.class);
        startActivity(segundaActivity);
    }
}