package es.iescarrillo.myfirstappacr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTerceroVolverAPrimero;
    TextView campoResultadoString;
    TextView campoResultadoEntero;
    TextView campoResultadoDecimal;
    TextView campoEstadoInterruptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnTerceroVolverAPrimero = findViewById(R.id.btnThirdReturnToFirst);
        campoResultadoString = findViewById(R.id.tvResultadoTexto);
        campoResultadoEntero = findViewById(R.id.tvResultadoEntero);
        campoResultadoDecimal = findViewById(R.id.tvResultadoDecimal);
        campoEstadoInterruptor = findViewById(R.id.tvEstadoInterruptor);

        btnTerceroVolverAPrimero.setOnClickListener(this);

        mostrarResultados();
    }

    public void mostrarResultados(){
        Intent intent = getIntent();
        String stringUsuario = intent.getStringExtra("datosCampoTexto");
        String enteroUsuario = intent.getStringExtra("datosCampoEntero");
        String decimalUsuario = intent.getStringExtra("datosCampoDecimal");
        boolean interruptorUsuario = false;
        interruptorUsuario = intent.getBooleanExtra("posicionInterruptor", interruptorUsuario);

        campoResultadoString.setText("Campo de texto: "+stringUsuario);
        campoResultadoEntero.setText("Campo de número entero: "+enteroUsuario);
        campoResultadoDecimal.setText("Campo de número decimal: "+decimalUsuario);
        if(interruptorUsuario){
            campoEstadoInterruptor.setText("Estado del interruptor: ACTIVADO");
        }else{
            campoEstadoInterruptor.setText("Estado del interruptor: DESACTIVADO");
        }
    }

    @Override
    public void onClick(View v) {
        Intent primeraActivity = new Intent(v.getContext(), MainActivity.class);
        startActivity(primeraActivity);
    }
}