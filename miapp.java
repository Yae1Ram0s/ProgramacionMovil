package com.example.miapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Calculadora extends Activity implements View.OnClickListener {

    Button[] btnDigitos = new Button[10];

    Button btnSuma;
    Button btnResta;
    Button btnMultiplicacion;
    Button btnDivision;
    Button btnPunto;
    Button btnIgual;

    EditText pantalla;

    double op1, op2, res;

    String operacion = "";

    boolean pintarPunto = true;

    @Override
    protected void onCreate(Bundle b) {

        super.onCreate(b);

        // PANEL PRINCIPAL
        LinearLayout panelPrincipal = new LinearLayout(this);
        panelPrincipal.setOrientation(LinearLayout.VERTICAL);
        panelPrincipal.setBackgroundColor(Color.BLACK);

        // PANEL PANTALLA
        LinearLayout panelPantalla = new LinearLayout(this);
        panelPantalla.setOrientation(LinearLayout.VERTICAL);
        panelPantalla.setBackgroundColor(Color.GRAY);
        panelPantalla.setMinimumHeight(200);

        TextView cuadro = new TextView(this);
        cuadro.setBackgroundColor(Color.BLUE);
        cuadro.setText("CALCULADORA");
        cuadro.setTextColor(Color.WHITE);
        cuadro.setTextSize(20);
        cuadro.setMinimumHeight(50);

        pantalla = new EditText(this);
        pantalla.setTextColor(Color.WHITE);
        pantalla.setTextSize(40);
        pantalla.setMaxLines(1);
        pantalla.setTextAlignment(EditText.TEXT_ALIGNMENT_TEXT_END);

        panelPantalla.addView(cuadro);
        panelPantalla.addView(pantalla);

        // PANEL CONTROLES
        LinearLayout panelControles = new LinearLayout(this);
        panelControles.setBackgroundColor(Color.RED);

        // PANEL BOTONES NUMEROS
        LinearLayout panelBotones1 = new LinearLayout(this);
        panelBotones1.setOrientation(LinearLayout.VERTICAL);
        panelBotones1.setBackgroundColor(Color.WHITE);

        // PANEL OPERACIONES
        LinearLayout panelBotones2 = new LinearLayout(this);
        panelBotones2.setOrientation(LinearLayout.VERTICAL);
        panelBotones2.setBackgroundColor(Color.GREEN);

        // FILAS
        LinearLayout li1 = new LinearLayout(this);
        LinearLayout li2 = new LinearLayout(this);
        LinearLayout li3 = new LinearLayout(this);
        LinearLayout li4 = new LinearLayout(this);

        // CREAR BOTONES NUMERICOS
        for (int i = 0; i <= 9; i++) {

            btnDigitos[i] = new Button(this);

            btnDigitos[i].setText(i + "");

            btnDigitos[i].setOnClickListener(this);

            switch (i) {

                case 0:
                    li4.addView(btnDigitos[i]);
                    break;

                case 1:
                case 2:
                case 3:
                    li3.addView(btnDigitos[i]);
                    break;

                case 4:
                case 5:
                case 6:
                    li2.addView(btnDigitos[i]);
                    break;

                case 7:
                case 8:
                case 9:
                    li1.addView(btnDigitos[i]);
                    break;
            }
        }

        // BOTON PUNTO
        btnPunto = new Button(this);
        btnPunto.setText(".");
        btnPunto.setOnClickListener(this);

        // BOTON IGUAL
        btnIgual = new Button(this);
        btnIgual.setText("=");
        btnIgual.setOnClickListener(this);

        // AGREGAR A FILA 4
        li4.addView(btnPunto);
        li4.addView(btnIgual);

        // BOTONES OPERACIONES
        btnSuma = new Button(this);
        btnSuma.setText("+");
        btnSuma.setOnClickListener(this);

        btnResta = new Button(this);
        btnResta.setText("-");
        btnResta.setOnClickListener(this);

        btnMultiplicacion = new Button(this);
        btnMultiplicacion.setText("*");
        btnMultiplicacion.setOnClickListener(this);

        btnDivision = new Button(this);
        btnDivision.setText("/");
        btnDivision.setOnClickListener(this);

        // AGREGAR BOTONES OPERACIONES
        panelBotones2.addView(btnSuma);
        panelBotones2.addView(btnResta);
        panelBotones2.addView(btnMultiplicacion);
        panelBotones2.addView(btnDivision);

        // AGREGAR FILAS
        panelBotones1.addView(li1);
        panelBotones1.addView(li2);
        panelBotones1.addView(li3);
        panelBotones1.addView(li4);

        // ARMAR INTERFAZ
        panelControles.addView(panelBotones1);
        panelControles.addView(panelBotones2);

        panelPrincipal.addView(panelPantalla);
        panelPrincipal.addView(panelControles);

        setContentView(panelPrincipal);
    }

    @Override
    public void onClick(View v) {

        // BOTONES NUMERICOS
        for (int i = 0; i <= 9; i++) {

            if (v.equals(btnDigitos[i])) {

                pantalla.setText(pantalla.getText() + "" + i);
            }
        }

        // BOTON PUNTO
        if (v.equals(btnPunto)) {

            if (pintarPunto) {

                pantalla.setText(pantalla.getText() + ".");
                pintarPunto = false;
            }
        }

        // SUMA
        if (v.equals(btnSuma)) {

            operacion = "suma";

            op1 = Double.parseDouble(pantalla.getText() + "");

            pantalla.setText("");

            pintarPunto = true;
        }

        // RESTA
        if (v.equals(btnResta)) {

            operacion = "resta";

            op1 = Double.parseDouble(pantalla.getText() + "");

            pantalla.setText("");

            pintarPunto = true;
        }

        // MULTIPLICACION
        if (v.equals(btnMultiplicacion)) {

            operacion = "multiplicacion";

            op1 = Double.parseDouble(pantalla.getText() + "");

            pantalla.setText("");

            pintarPunto = true;
        }

        // DIVISION
        if (v.equals(btnDivision)) {

            operacion = "division";

            op1 = Double.parseDouble(pantalla.getText() + "");

            pantalla.setText("");

            pintarPunto = true;
        }

        // IGUAL
        if (v.equals(btnIgual)) {

            op2 = Double.parseDouble(pantalla.getText() + "");

            switch (operacion) {

                case "suma":
                    res = op1 + op2;
                    break;

                case "resta":
                    res = op1 - op2;
                    break;

                case "multiplicacion":
                    res = op1 * op2;
                    break;

                case "division":

                    if (op2 != 0) {

                        res = op1 / op2;

                    } else {

                        pantalla.setText("Error");
                        return;
                    }

                    break;
            }

            pantalla.setText(String.valueOf(res));

            pintarPunto = true;
        }
    }
}
