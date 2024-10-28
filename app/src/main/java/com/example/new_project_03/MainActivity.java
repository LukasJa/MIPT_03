// arithmetic logic was generated by chatGPT

package com.example.new_project_03;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView calculatorScreen;
    private StringBuilder inputExpression = new StringBuilder();
    private double firstValue = 0;
    private double secondValue = 0;
    private String currentOperator = "";
    private boolean operatorPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        calculatorScreen = findViewById(R.id.calculatorScreen);

        setNumberButtonListeners();
        setOperatorButtonListeners();
        setEqualButtonListener();
        setClearButtonListeners();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void setNumberButtonListeners() {
        int[] numberButtonIds = {R.id.cal0, R.id.cal1, R.id.cal2, R.id.cal3, R.id.cal4, R.id.cal5, R.id.cal6, R.id.cal7, R.id.cal8, R.id.cal9};
        View.OnClickListener listener = v -> {
            Button button = (Button) v;
            String number = button.getText().toString();
            if (operatorPressed) {
                calculatorScreen.setText(number);
                operatorPressed = false;
            } else {
                calculatorScreen.append(number);
            }
        };

        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setOperatorButtonListeners() {
        int[] operatorButtonIds = {R.id.calPlus, R.id.calMinus, R.id.calMultiply, R.id.calDivide};
        View.OnClickListener listener = v -> {
            Button button = (Button) v;
            currentOperator = button.getText().toString();
            firstValue = Double.parseDouble(calculatorScreen.getText().toString());
            operatorPressed = true;
        };

        for (int id : operatorButtonIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setEqualButtonListener() {
        findViewById(R.id.calEqual).setOnClickListener(v -> {
            secondValue = Double.parseDouble(calculatorScreen.getText().toString());
            double result = 0;
            switch (currentOperator) {
                case "+":
                    result = firstValue + secondValue;
                    break;
                case "-":
                    result = firstValue - secondValue;
                    break;
                case "X":
                    result = firstValue * secondValue;
                    break;
                case "/":
                    if (secondValue != 0) {
                        result = firstValue / secondValue;
                    } else {
                        calculatorScreen.setText("Error");
                        return;
                    }
                    break;
            }
            calculatorScreen.setText(String.valueOf(result));
            operatorPressed = true;
        });
    }

    private void setClearButtonListeners() {
        findViewById(R.id.calC).setOnClickListener(v -> calculatorScreen.setText(""));
        findViewById(R.id.calCE).setOnClickListener(v -> {
            calculatorScreen.setText("");
            firstValue = 0;
            secondValue = 0;
            currentOperator = "";
        });
    }
}