package dmos5_2020s1.arq.ifsp.edu.br.conversortemperatura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText valorTemperatura;
    private Button converterCelsius;
    private Button converterFahrenheit
    private TextView temperaturaConvertida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valorTemperatura = findViewById(R.id.editText_valor_temperatura);
        converterCelsius = findViewById(R.id.button_converter_celsius);
        converterFahrenheit = findViewById(R.id.button_converter_fahrenheit);
        temperaturaConvertida = findViewById(R.id.text_view_valor_convertido);
        converterCelsius.setOnClickListener(this);
        converterFahrenheit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(converterCelsius)){
            converterFahrenheitToCelsius();
        }else{
            converterCelsiusToFahrenheit();
        }
    }

    private double getEntrada() throws NumberFormatException{
        double entrada;

        try{
            entrada = Double.valueOf(valorRealEditText.getText().toString());
        }catch(NumberFormatException e){
            entrada = 0;
            throw e;
        }
        return entrada;
    }

    public void converterFahrenheitToCelsius(){
        double valor = 0;
        try{
            valor = getEntrada();
        }catch(NumberFormatException e){
            Toast.makeText(this, "Valor digitado é inválido", Toast.LENGTH_SHORT).show();
        }
        temperaturaConvertida.setText(String.format("%.2f ºC", (entrada - 32)/1.8));
    }

    public void converterCelsiusToFahrenheit(){
        double valor = 0;
        try{
            valor = getEntrada();
        }catch(NumberFormatException e){
            Toast.makeText(this, "Valor digitado é inválido", Toast.LENGTH_SHORT).show();
        }
        temperaturaConvertida.setText(String.format("%.2f ºF", (entrada * 1.8)+32));
    }
}
