package es.iescarrillo.myfirstappacr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSegundoEnviarATercero;
    EditText campoTexto;
    EditText campoEntero;
    EditText campoDecimal;
    Switch interruptorBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSegundoEnviarATercero = findViewById(R.id.btnSecondSendFormToThird);
        campoTexto = findViewById(R.id.campoTexto);
        campoEntero = findViewById(R.id.campoEntero);
        campoDecimal = findViewById(R.id.campoDecimal);
        interruptorBoolean = findViewById(R.id.interruptorBoolean);

        btnSegundoEnviarATercero.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent terceraActivity = new Intent(v.getContext(), ThirdActivity.class);
        terceraActivity.putExtra("datosCampoTexto", campoTexto.getText().toString());
        terceraActivity.putExtra("datosCampoEntero", campoEntero.getText().toString());
        terceraActivity.putExtra("datosCampoDecimal", campoDecimal.getText().toString());
        terceraActivity.putExtra("posicionInterruptor", interruptorBoolean.isChecked());
        startActivity(terceraActivity);
    }
}