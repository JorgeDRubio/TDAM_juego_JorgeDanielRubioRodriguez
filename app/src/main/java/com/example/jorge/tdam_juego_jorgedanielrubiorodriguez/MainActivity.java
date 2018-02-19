package com.example.jorge.tdam_juego_jorgedanielrubiorodriguez;

import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editNumero;
    Button btnPresionar;
    Boolean incrementando;
    String num1, num2;
    float num= (float) 0.0;
    double numeracion =  (1 * Math.random()) + 1;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNumero = findViewById(R.id.editText);
        btnPresionar = findViewById(R.id.button);

        incrementando = true;
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(1);
        num1=format.format(numeracion);

        btnPresionar.setText(""+num1);
        timer = new CountDownTimer(2000,    250) {
            @Override
            public void onTick(long l) {
                if(incrementando){
                    num-=0.1;
                    DecimalFormat format=new DecimalFormat();
                    format.setMaximumFractionDigits(1);
                    num2 = format.format(num);
                    if(num>numeracion && num<0){
                        incrementando=true;

                    }

                }

                editNumero.setText(num2);
            }

            @Override
            public void onFinish() {
                timer.start();
            }
        }.start();

        btnPresionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(editNumero.getText().toString().equals(btnPresionar.getText().toString())){
                        Toast.makeText(MainActivity.this, "Juego ganado", Toast.LENGTH_SHORT).show();
                        timer.cancel();
                    }else {
                        Toast.makeText(MainActivity.this, "Juego perdido", Toast.LENGTH_SHORT).show();
                        timer.cancel();
                    }
            }
        });
    }
}
