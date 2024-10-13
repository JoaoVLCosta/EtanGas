package br.edu.fateczl.etangas;

import android.os.Bundle;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    private EditText etGas;
    private EditText etEta;
    private TextView tvRes;

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

        etGas = findViewById(R.id.etGas);
        etGas.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        etEta = findViewById(R.id.etEta);
        etEta.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        Button btCalc = findViewById(R.id.btCalc);
        btCalc.setOnClickListener(op -> calc());
    }

    private void calc(){
        float valorG = Float.parseFloat(etGas.getText().toString());
        float valorE = Float.parseFloat(etEta.getText().toString());
        String resultado = "";
        if((valorG * 0.7) >= valorE){
            resultado = getString(R.string.resultadoE);
        } else {
            resultado = getString(R.string.resultadoG);
        }
        tvRes.setText(resultado);
    }

}