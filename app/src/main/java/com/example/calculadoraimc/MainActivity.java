package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final float[] imc = new float[1];
        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {

            // On click calculate button
            @Override
            public void onClick(View v) {
                TextView editPeso = (TextView) findViewById(R.id.pesoEditText);
                TextView editAltura = (TextView) findViewById(R.id.alturaEditText);
                TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
                TextView tvDescricao = (TextView) findViewById(R.id.tvDescricao);

                int peso = Integer.parseInt(editPeso.getText().toString());
                float altura = Float.parseFloat(editAltura.getText().toString());

                // imc
                float imc = peso / (altura * altura);

                if (imc < 18.5) {
                    tvResultado.setText(String.format("IMC: " + imc));
                    tvDescricao.setText("Baixo peso");
                } else {
                    if (imc < 25) {
                        tvResultado.setText("IMC: " + imc);
                        tvDescricao.setText("Peso adequado");
                    } else {
                        if (imc < 30) {
                            tvResultado.setText("IMC: " + imc);
                            tvDescricao.setText("Sobrepeso");
                        } else {
                            tvResultado.setText("IMC: " + imc);
                            tvDescricao.setText("Obesidade");
                        }
                    }
                }
            }

        });
    }
}