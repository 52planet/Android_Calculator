package com.example.map_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Calculator calculator;
    Calculator calculator = new Calculator();
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    Button btnplus, btnminus, btnmultiply, btndivide, btnclear, btnequals, btnScientific;
    Button modbtn, powbtn, maxbtn, minbtn;
    EditText display_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display_text = findViewById(R.id.display_text);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);

        btnplus = findViewById(R.id.btnplus);
        btnminus = findViewById(R.id.btnminus);
        btnmultiply = findViewById(R.id.btnmultiply);
        btndivide = findViewById(R.id.btndivide);
        btnclear = findViewById(R.id.btnclear);
        btnequals = findViewById(R.id.btnequals);
        btnScientific = findViewById(R.id.btnScientific);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);

        btnplus.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        btnmultiply.setOnClickListener(this);
        btndivide.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        btnequals.setOnClickListener(this);
        btnScientific.setOnClickListener(this);

        //SCIENTIFIC MODE


        modbtn = findViewById(R.id.modbtn);
        powbtn = findViewById(R.id.powbtn);
        maxbtn = findViewById(R.id.maxbtn);
        minbtn = findViewById(R.id.minbtn);

        modbtn.setOnClickListener(this);
        powbtn.setOnClickListener(this);
        maxbtn.setOnClickListener(this);
        minbtn.setOnClickListener(this);

        LinearLayout Science_tools = findViewById(R.id.sci_ops);
        Science_tools.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View view)
    {
        Button b = (Button)view;
        String buttonText = b.getText().toString();

        if(buttonText.equals("SCIENTIFIC")) //switch modes
        {
            LinearLayout Science_tools = findViewById(R.id.sci_ops);
            Science_tools.setVisibility(View.VISIBLE);
            //Set the mode selector to standard
            Button temp_btn = (Button)findViewById(R.id.btnScientific);
            temp_btn.setText("STANDARD");
            //reset
            calculator.operation_string.clear();

        }
        else if(buttonText.equals("STANDARD"))
        {
            LinearLayout Science_tools = findViewById(R.id.sci_ops);
            Science_tools.setVisibility(View.GONE);
            //Set the mode selector to standard
            Button temp_btn = (Button)findViewById(R.id.btnScientific);
            temp_btn.setText("SCIENTIFIC");
            //reset
            calculator.operation_string.clear();
        }
        else
        {
            calculator.push(buttonText);
            display_text.setText(calculator.display());
        }

    }

}

