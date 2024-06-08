package br.edu.utfpr.calculaimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;
    private TextView tvResultado;
    private Button btCalcula;
    private Button btLimpar;
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
        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        tvResultado = findViewById(R.id.tvResultado);
        btCalcula = findViewById(R.id.btCalcula);
        btLimpar = findViewById(R.id.btLimpar);
        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btLimparOnclick();
            }
        });

        btCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btCalcularOnClick();
            }
        });
    }

    private void btCalcularOnClick() {
        if (etPeso.getText().toString().isEmpty()){
            etPeso.setError("Campo peso deve ser preenchido");
            etPeso.requestFocus();
            return;
        }
        if (etAltura.getText().toString().isEmpty()){
            etAltura.setError("Campo altura deve ser preenchido");
            etAltura.requestFocus();
            return;
        }

        double peso = Double.parseDouble(etPeso.getText().toString());
        double altura = Double.parseDouble( etAltura.getText().toString());

        double resultado = peso / Math.pow(altura, 2);

        DecimalFormat df = new DecimalFormat("0.00");
        tvResultado.setText(df.format(resultado));
    }

    private void btLimparOnclick() {
        etPeso.setText("");
        etAltura.setText("");
    }
}