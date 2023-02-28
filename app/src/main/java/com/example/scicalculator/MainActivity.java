package com.example.scicalculator;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.apache.commons.math3.util.Precision;

import java.text.BreakIterator;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView input, signBox;
    private String sign, value1, value2;
    private boolean hasDot;
    private double num1, num2, result;
    private Throwable e;
    private double degrees , radians, cube ;
    private static final String TAG = "Logging Example";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (TextView) findViewById(R.id.input);
        signBox = (TextView) findViewById(R.id.sign);

        hasDot = false;
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_00(View view) {
        input.setText(input.getText() + "00");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_0(View view) {
        input.setText(input.getText() + "0");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_1(View view) {
        input.setText(input.getText() + "1");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_2(View view) {
        input.setText(input.getText() + "2");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_3(View view) {
        input.setText(input.getText() + "3");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_4(View view) {
        input.setText(input.getText() + "4");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_5(View view) {
        input.setText(input.getText() + "5");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_6(View view) {
        input.setText(input.getText() + "6");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_7(View view) {
        input.setText(input.getText() + "7");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_8(View view) {
        input.setText(input.getText() + "8");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_9(View view) {
        input.setText(input.getText() + "9");
    }


    @SuppressLint("SetTextI18n")
    public void btnClick_dot(View view) {
        if (!hasDot) {
            if (input.getText().equals("")) {
                input.setText("0.");
            } else {
                input.setText(input.getText() + ".");
            }
            hasDot = true;
        }
    }

    public void btnClick_divide(View view) {
        sign = "/";
        value1 = input.getText().toString();
        input.setText(null);
        signBox.setText("÷");
        hasDot = false;
    }

    public void btnClick_multiply(View view) {
        sign = "*";
        value1 = input.getText().toString();
        input.setText(null);
        signBox.setText("×");
        hasDot = false;
    }

    public void btnClick_subtract(View view) {
        sign = "-";
        value1 = input.getText().toString();
        input.setText(null);
        signBox.setText("-");
        hasDot = false;
    }

    public void btnClick_add(View view) {
        sign = "+";
        value1 = input.getText().toString();
        input.setText(null);
        signBox.setText("+");
        hasDot = false;
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_log(View view) {
        sign = "log";
        input.setText(null);
        signBox.setText("log");
        hasDot = false;
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_ln(View view) {
        sign = "ln";
        input.setText(null);
        signBox.setText("ln");
        hasDot = false;
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_factorial(View view) {
        sign = "factorial";
        input.setText(null);
        signBox.setText("x!");
        hasDot = false;
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_cuberoot(View view) {
        sign = "cuberoot";
        input.setText(null);
        signBox.setText("∛");
        hasDot = false;
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_sin(View view) {
        sign = "sin";
        input.setText(null);
        signBox.setText("sin");
        hasDot = false;
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_cos(View view) {
        sign = "cos";
        input.setText(null);
        signBox.setText("cos");
        hasDot = false;
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_tan(View view) {
        sign = "tan";
        input.setText(null);
        signBox.setText("tan");
        hasDot = false;
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_root(View view) {
        sign = "root";
        input.setText(null);
        signBox.setText("√");
        hasDot = false;
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_power(View view) {
        sign = "power";
        value1 = input.getText().toString();
        input.setText(null);
        signBox.setText("xⁿ");
        hasDot = false;
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_equal(View view) {
//        Log.d("test2", ""+ Math.tan(Math.toRadians(90)));
//        System.exit(0);
        if (sign == null) {
            signBox.setText("");
        } else if (input.getText().equals(" ")) {
            signBox.setText("");
        } else if ((sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/")) && value1.equals("")) {
            signBox.setText("");
        } else {
            switch (sign) {
                default:
                    break;
                case "log":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    input.setText(Math.log10(num1) + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "ln":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    input.setText(Math.log(num1) + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "power":
                    num1 = Double.parseDouble((value1));
                    value2 = input.getText().toString();
                    num2 = Double.parseDouble(value2);
                    input.setText(Math.pow(num1, num2) + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "cuberoot":
                    value1 = input.getText().toString();
//                    Log.d("test2", ""+value1);
//                    System.exit(0);
                    num1 = Double.parseDouble(value1);
                    input.setText(Math.cbrt(num1) + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "root":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
                    input.setText(Math.sqrt(num1) + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "factorial":
                    value1 = input.getText().toString();
//                    Log.d(TAG, ""+input.getText());
                    num1 = Double.parseDouble((value1));
//                    Log.d(TAG, ""+num1);
                    int i = Integer.parseInt(value1)-1;
                    while (i > 0) {
                        num1 = num1 * i;
                        i--;
                    }
                    input.setText(num1 + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "sin":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
                    input.setText(Math.sin(Math.toRadians(num1)) + "");
                    if (num1 == 180 || num1  == 360) {
                        input.setText("0");
                    } else {
                        input.setText(Math.sin(Math.toRadians(num1)) + "");
                    }
                    sign = null;
                    signBox.setText(null);
                    break;
                case "cos":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
                    if (num1 == 90 || num1  == 270) {
                        input.setText("0");
                    } else {
                        input.setText(Math.cos(Math.toRadians(num1)) + "");
                    }
                    sign = null;
                    signBox.setText(null);
                    break;

                case "tan":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
//                    Log.d("test2", "45: " + Math.tan(Math.toRadians(45)));
//                    Log.d("test2", "30: " + Math.tan(Math.toRadians(30)));
//                    Log.d("test2", "180: " + Math.tan(Math.toRadians(180)));
//                    Log.d("test2", "360: " + Math.tan(Math.toRadians(360)));
//                    Log.d("test2", "45: " + Precision.round(Math.tan(Math.toRadians(45)), 13));
//                    Log.d("test2", "30: " + Precision.round(Math.tan(Math.toRadians(30)), 13));
//                    Log.d("test2", "str: " + value1);
//                    Log.d("test2", "boolstr: " + (value1 == "90"));
//                    Log.d("test2", "boolint: " + (num1 == 90));
//                    Log.d("test2", "obj: " + Objects.equals(value1,"90"));
//                    System.exit(1);
                    if (num1 == 90 || num1  == 270) {
                        input.setText("infinity");
                    } else {
                        double specialValue = precision(Math.tan(Math.toRadians(num1)), 13);
                        if (specialValue == -0.0) {
                            specialValue = Math.abs(specialValue);
                        }
                        input.setText(specialValue+"");
                    }
                    sign = null;
                    signBox.setText(null);
                    break;

                case "+":
                    value2 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 + num2;
                    input.setText(result + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "-":
                    value2 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 - num2;
                    input.setText(result + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "*":
                    value2 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 * num2;
                    input.setText(result + "");
                    sign = null;
                    signBox.setText(null);
                    break;
                case "/":
                    value2 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 / num2;
                    input.setText(result + "");
                    sign = null;
                    signBox.setText(null);
                    break;
            }
        }
    }

    public void btnClick_delete(View view) {
        if (input.getText().equals("")) {
            input.setText(null);
        } else {
            int len = input.getText().length();
            String s = input.getText().toString();
            if (s.charAt(len - 1) == '.') {
                hasDot = false;
                input.setText(input.getText().subSequence(0,input.getText().length()-1));

            } else {
                input.setText(input.getText().subSequence(0, input.getText().length() - 1));
            }
        }
    }

        public void btnClick_clear(View view) {
        input.setText(null);
        signBox.setText(null);
        value1 = null;
        value2 = null;
        sign = null;
        hasDot = false;
    }

    private double precision(double value, int scale)
    {
        return Precision.round(value, scale);
    }
}

