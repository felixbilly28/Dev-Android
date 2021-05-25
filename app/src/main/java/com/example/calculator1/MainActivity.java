
package com.example.calculator1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import org.mariuszgromada.math.mxparser.Expression;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }
    private void updateText(String strToAdd){
        String oldstr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldstr.substring(0, cursorPos);
        String rightStr = oldstr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);


        }
        else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }
    public void zeroBTN (View view){
        updateText("0");
    }
    public void oneBTN (View view){
        updateText("1");
    }
    public void twoBTN (View view){
        updateText("2");
    }
    public void threeBTN (View view){
        updateText("3");
    }
    public void fourBTN (View view){
        updateText("4");
    }
    public void fiveBTN (View view){
        updateText("5");
    }
    public void sixBTN (View view){
        updateText("6");
    }
    public void sevenBTN (View view){
        updateText("7");
    }
    public void eightBTN (View view){
        updateText("8");
    }
    public void nineBTN (View view){
        updateText("9");
    }
    public void addBTN (View view){
        updateText("+");
    }
    public void minusBTN (View view){
        updateText("-");
    }
    public void multiplyBTN (View view){
        updateText("*");
    }
    public void devideBTN (View view){
        updateText("/");
    }
    public void pointBTN (View view){
        updateText(".");
    }
    public void cosBTN (View view){
        updateText("0");
    }
    public void sinBTN (View view){
        updateText("0");
    }
    public void cBTN (View view){
        display.setText("");
    }
    public void equalsBTN (View view){
        String userExpr = display.getText().toString();

        Expression exp = new Expression(userExpr);


        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }
    public void backspaceBTN (View view){

    }
}