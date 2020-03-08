package dmos5_2020s1.arq.ifsp.edu.br.conversortemperatura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText valorTemperaturaFahrenheit;
    private Button converter;
    private TextView temperaturaConvertida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valorTemperaturaFahrenheit = findViewById(R.id.editText_valor_temperatura);
        converter = findViewById(R.id.button_converter);
        temperaturaConvertida = findViewById(R.id.text_view_valor_celsus);
        converter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(converter)){
            converterFahrenheitToCelsius();
        }
    }

    public void converterFahrenheitToCelsius(){
        double entrada = 0;
        try{
            entrada = Double.parseDouble(valorTemperaturaFahrenheit.getText().toString());
        }catch(NumberFormatException e){
            Toast.makeText(this, "Valor digitado é inválido", Toast.LENGTH_SHORT).show();
        }
        temperaturaConvertida.setText(String.format("%.2f ºC", (entrada - 32)/1.8));
    }

}
