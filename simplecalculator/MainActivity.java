package com.example.simplecalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText display;

    String value1 = "", operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        int[] numberIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        };

        for (int id : numberIds) {
            Button btn = findViewById(id);
            btn.setOnClickListener(v ->
                    display.append(btn.getText().toString()));
        }

        findViewById(R.id.btnAdd).setOnClickListener(v -> setOperator("+"));
        findViewById(R.id.btnSub).setOnClickListener(v -> setOperator("-"));
        findViewById(R.id.btnMul).setOnClickListener(v -> setOperator("*"));
        findViewById(R.id.btnDiv).setOnClickListener(v -> setOperator("/"));

        findViewById(R.id.btnClear).setOnClickListener(v -> {
            display.setText("");
            value1 = "";
            operator = "";
        });

        findViewById(R.id.btnEqual).setOnClickListener(v -> calculate());
    }

    private void setOperator(String op) {
        value1 = display.getText().toString();
        operator = op;
        display.setText("");
    }

    private void calculate() {

        String value2 = display.getText().toString();

        if (value1.isEmpty() || value2.isEmpty())
            return;

        double num1 = Double.parseDouble(value1);
        double num2 = Double.parseDouble(value2);
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            case "*":
                result = num1 * num2;
                break;

            case "/":
                if (num2 == 0) {
                    display.setText("Error");
                    return;
                }
                result = num1 / num2;
                break;
        }

        display.setText(String.valueOf(result));
    }
}
