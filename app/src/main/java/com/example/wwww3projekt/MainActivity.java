package com.example.wwww3projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Double firstValues;
    Double secondValues;
    Double result;
    String operation;
    String saveString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        Button buttons = findViewById(R.id.save);
        buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                String someText = String.valueOf(result.doubleValue());
                intent.putExtra("text_key", someText);
                startActivityForResult(intent, 42);
            }
        });


        if (savedInstanceState != null) {
            saveString = savedInstanceState.getString("result_fild");
            textView.setText(saveString);
            firstValues = savedInstanceState.getDouble("first_value");
            secondValues = savedInstanceState.getDouble("second_value");
            operation = savedInstanceState.getString("operation");

        }
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.zero:
                textView.append("0");
                break;
            case R.id.one:
                textView.append("1");
                break;
            case R.id.two:
                textView.append("2");
                break;
            case R.id.three:
                textView.append("3");
                break;
            case R.id.four:
                textView.append("4");
                break;
            case R.id.five:
                textView.append("5");
                break;
            case R.id.six:
                textView.append("6");
                break;
            case R.id.seven:
                textView.append("7");
                break;
            case R.id.eight:
                textView.append("8");
                break;
            case R.id.nine:
                textView.append("9");
                break;
            case R.id.comma:
                textView.append(".");
                break;
            case R.id.delete:
                textView.setText("");
                break;

        }

    }

    public void OnOperatoinClick(View view) {

        switch (view.getId()) {
            case R.id.plus:
                operation = "+";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "+");
                break;
            case R.id.minus:
                operation = "-";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "-");
                break;
            case R.id.division:
                operation = "/";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "/");
                break;
            case R.id.multiplication:
                operation = "X";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "X");
                break;
            case R.id.equally:
                if (textView != null) {
                    String second = textView.getText().toString().replace(firstValues + operation + "", "");
                    secondValues = Double.valueOf(second);
                    switch (operation) {
                        case "+":
                            result = firstValues + secondValues;
                            textView.setText(firstValues + "+" + secondValues + "=" + result);
                            break;
                        case "-":
                            result = firstValues - secondValues;
                            textView.setText(firstValues + "-" + secondValues + "=" + result);
                            break;
                        case "/":
                            result = firstValues / secondValues;
                            textView.setText(firstValues + "/" + secondValues + "=" + result);
                            break;
                        case "X":
                            result = firstValues * secondValues;
                            textView.setText(firstValues + "X" + secondValues + "=" + result);
                            break;
                    }
                }

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("result_fild", textView.getText().toString());
        if (textView != null && firstValues != null && secondValues != null && operation != null) {
            outState.putDouble("second_value", secondValues);
            outState.putDouble("first_value", firstValues);
            outState.putString("operation", operation);
        }
    }
}

