package com.example.consultants.week2_weekend;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    TextView DisplayHeader;
    TextView DisplayAnswer;
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    Button btn_clear, btn_add, btn_sub, btn_div, btn_mult, btn_equal, btn_frac, btn_pie;

    double num1, num2;
    boolean op_add, op_sub, op_div, op_mult, op_frac, op_rec, op_pie;       //decide if input number is new value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        //display
        DisplayHeader = findViewById(R.id.DisplayHeader);
        DisplayAnswer = findViewById(R.id.DisplayAnswer);

        //buttons
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_clear = findViewById(R.id.btn_clear);
        btn_add = findViewById(R.id.btn_Addition);
        btn_sub = findViewById(R.id.btn_Subtract);
        btn_div = findViewById(R.id.btn_Division);
        btn_mult = findViewById(R.id.btn_Multiply);
        btn_equal = findViewById(R.id.btn_Equals);
        btn_frac = findViewById(R.id.btn_Fraction);
        btn_pie = findViewById(R.id.btn_Pie);

        //bind buttons to track press
        btn_0.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);

        btn_clear.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_mult.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_frac.setOnClickListener(this);
        btn_pie.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String inputDisplay = (String) DisplayHeader.getText();

        switch (v.getId()) {
            case R.id.btn_0:
                DisplayHeader.setText(inputDisplay + btn_0.getText());
                //binding.DisplayHeader.setText(inputDisplay + btn_0.getText());
                break;
            case R.id.btn_1:
                DisplayHeader.setText(inputDisplay + btn_1.getText());
                //binding.DisplayHeader.setText(inputDisplay + btn_1.getText());
                break;
            case R.id.btn_2:
                DisplayHeader.setText(inputDisplay + btn_2.getText());
                //binding.DisplayHeader.setText(inputDisplay + btn_2.getText());

                break;
            case R.id.btn_3:
                DisplayHeader.setText(inputDisplay + btn_3.getText());
                //binding.DisplayHeader.setText(inputDisplay + btn_3.getText());

                break;
            case R.id.btn_4:
                DisplayHeader.setText(inputDisplay + btn_4.getText());
                //binding.DisplayHeader.setText(inputDisplay + btn_4.getText());

                break;
            case R.id.btn_5:
                DisplayHeader.setText(inputDisplay + btn_5.getText());
                //binding.DisplayHeader.setText(inputDisplay + btn_5.getText());

                break;
            case R.id.btn_6:
                DisplayHeader.setText(inputDisplay + btn_6.getText());
                //binding.DisplayHeader.setText(inputDisplay + btn_6.getText());

                break;
            case R.id.btn_7:
                DisplayHeader.setText(inputDisplay + btn_7.getText());
                //binding.DisplayHeader.setText(inputDisplay + btn_7.getText());

                break;
            case R.id.btn_8:
                DisplayHeader.setText(inputDisplay + btn_8.getText());
                //binding.DisplayHeader.setText(inputDisplay + btn_8.getText());

                break;
            case R.id.btn_9:
                DisplayHeader.setText(inputDisplay + btn_9.getText());
                //binding.DisplayHeader.setText(inputDisplay + btn_9.getText());

                break;

            //operations
            case R.id.btn_clear:
                DisplayHeader.setText("");
                DisplayAnswer.setText("");

                break;
            case R.id.btn_Addition:
                DisplayHeader.setText(inputDisplay + btn_add.getText());
                op_add = true;
                break;

            case R.id.btn_Subtract:
//                DisplayHeader.setText((String)DisplayHeader.getText()+btn_sub.getText());
                DisplayHeader.setText(inputDisplay + btn_sub.getText());
                op_sub = true;
                break;
            case R.id.btn_Division:
//                DisplayHeader.setText((String)DisplayHeader.getText()+btn_sub.getText());
                DisplayHeader.setText(inputDisplay + btn_div.getText());
                op_div = true;
                break;
            case R.id.btn_Multiply:
//                DisplayHeader.setText((String)DisplayHeader.getText()+btn_sub.getText());
                DisplayHeader.setText(inputDisplay + btn_mult.getText());
                op_mult = true;
                break;

            //Special Characters
            //Issues
            case R.id.btn_Fraction:
                DisplayHeader.setText(inputDisplay + btn_frac.getText());
                op_frac = true;
                break;

            case R.id.btn_Pie:
                DisplayHeader.setText(inputDisplay + btn_pie.getText());
                op_pie = true;


            case R.id.btn_Equals:
                clickCalculation((String) DisplayHeader.getText());
                break;
        }
    }

    @SuppressLint("NewApi")
    private void clickCalculation(String text) {
        double result = 0.0;
        double pie = 3.141592659;
        String headDisplay = (String) DisplayHeader.getText();
        String SplitParts[] = headDisplay.split("(\\+|-|/|\\*)");

        num1 = Double.parseDouble(SplitParts[0]);
        num2 = Double.parseDouble(SplitParts[1]);


        if (op_add) {
            result = num1 + num2;
            DisplayHeader.setText(text);
            DisplayAnswer.setText(Double.toString(result));
            op_add = false;
        } else if (op_sub) {
            result = num1 - num2;
            DisplayHeader.setText(text);
            DisplayAnswer.setText(Double.toString(result));
            op_sub = false;
        } else if (op_div) {
            result = num1 / num2;
            DisplayHeader.setText(text);
            DisplayAnswer.setText(Double.toString(result));
            op_div = false;
        } else if (op_mult) {
            result = num1 * num2;
            DisplayHeader.setText(text);
            DisplayAnswer.setText(Double.toString(result));
            op_mult = false;
        } else if (op_frac) {
            String output;
            output = " 1 / " + Double.toString(num1);
            //DisplayHeader.setText(text);
            DisplayAnswer.setText(output);
            op_frac = false;
        } else if (op_pie) {
            num2 = pie;
            result = num1 * pie;
            DisplayHeader.setText(text);
            DisplayAnswer.setText(Double.toString(result));
            op_pie = false;

        }
    }
}
