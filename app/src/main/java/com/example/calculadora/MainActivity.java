package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int numero1;
    int numero2;
    String operacion="";
    TextView texto;
    boolean bandera = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cero = (Button)findViewById(R.id.btn0);
        Button uno = (Button)findViewById(R.id.btn1);
        Button dos = (Button)findViewById(R.id.btn2);
        Button tres = (Button)findViewById(R.id.btn3);
        Button cuatro = (Button)findViewById(R.id.btn4);
        Button cinco = (Button)findViewById(R.id.btn5);
        Button seis = (Button)findViewById(R.id.btn6);
        Button siete = (Button)findViewById(R.id.btn7);
        Button ocho = (Button)findViewById(R.id.btn8);
        Button nueve = (Button)findViewById(R.id.btn9);
        Button limpiar = (Button)findViewById(R.id.btnLimp);
        Button suma = (Button)findViewById(R.id.btnSuma);
        Button multiplicacion = (Button)findViewById(R.id.btnMult);
        Button division = (Button)findViewById(R.id.btnDiv);
        Button resta = (Button)findViewById(R.id.btnResta);
        Button resultado = (Button)findViewById(R.id.btnResultado);
        texto = (TextView) findViewById(R.id.campoResultado);

        texto.setText("0");

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText("0");
                numero1 = 0;
                numero2 = 0;
                bandera = false;
            }
        });
        cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarNumero("0");
            }
        });
        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarNumero("1");
            }
        });
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarNumero("2");
            }
        });
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarNumero("3");
            }
        });
        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarNumero("4");
            }
        });
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarNumero("5");
            }
        });
        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarNumero("6");
            }
        });
        siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarNumero("7");
            }
        });
        ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarNumero("8");
            }
        });
        nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarNumero("9");
            }
        });
        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarOperacion("+");
            }
        });
        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarOperacion("-");
            }
        });
        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarOperacion("*");
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarOperacion("/");
            }
        });
        resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (operacion){
                    case "+":
                        numero2 = Integer.parseInt(texto.getText().toString());
                        numero1 += numero2;
                        texto.setText(String.valueOf(numero1));
                        operacion = "";
                        bandera = true;
                        break;
                    case "-":
                        numero2 = Integer.parseInt(texto.getText().toString());
                        numero1 -= numero2;
                        texto.setText(String.valueOf(numero1));
                        operacion = "";
                        bandera = true;
                        break;
                    case "*":
                        numero2 = Integer.parseInt(texto.getText().toString());
                        numero1 *= numero2;
                        texto.setText(String.valueOf(numero1));
                        operacion = "";
                        bandera = true;
                        break;
                    case "/":
                        try {
                            numero2 = Integer.parseInt(texto.getText().toString());
                            numero1 /= numero2;
                            texto.setText(String.valueOf(numero1));
                            operacion = "";
                            bandera = true;
                            break;
                        }catch (ArithmeticException ex){
                            texto.setText(R.string.div_cero);
                            operacion = "";
                            bandera = false;
                            break;
                        }
                    default:
                        texto.setText(R.string.no_operacion);
                        numero1 = 0;
                        numero2 = 0;
                        bandera = false;
                        break;
                }
            }
        });
    }

    void asignarNumero(String mensajeNumero){
        if(texto.getText().charAt(0) == '0' || texto.getText().charAt(0) == 'E'){
            texto.setText(mensajeNumero);
            bandera = true;
        } else{
            texto.setText(texto.getText() + mensajeNumero);
            bandera = true;
        }
    }

    void asignarOperacion(String mensajeOperacion){
        if ( bandera == false){
            texto.setText(R.string.no_numero);
        }else {
            operacion = mensajeOperacion;
            numero1 = Integer.parseInt(texto.getText().toString());
            texto.setText("0");
            Toast.makeText(this, R.string.op_registrada, Toast.LENGTH_SHORT).show();

        }
    }
}