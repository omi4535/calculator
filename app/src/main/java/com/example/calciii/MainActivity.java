package com.example.calciii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    EditText edt2;
    String op="+";
    Boolean mins=false;
    Boolean pt=false;
    String oldnum="";
    String newnum="";
    Boolean isnewop = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=findViewById(R.id.editTextText);
        edt2=findViewById(R.id.editTextText1);
    }

    public void number_event(View view) {
        if(isnewop)
            edt1.setText("");
        isnewop=false;
        String number=edt1.getText().toString();
        switch (view.getId())
        {
            case R.id.bu_0:
                number+=0;
                break;
            case R.id.bu_1:
                number +=1;
                break;
            case R.id.bu_2:
                number+=2;
                break;
            case R.id.bu_3:
                number+=3;
                break;
            case R.id.bu_4:
                number+=4;
                break;
            case R.id.bu_5:
                number+=5;
                break;
            case R.id.bu_6:
                number+=6;
                break;
            case R.id.bu_7:
                number+=7;
                break;
            case R.id.bu_8:
                 number+=8;
                 break;
            case R.id.bu_9:
                number+=9;
                break;

            case R.id.bu_pnt:
                if(!pt) {
                    pt=true;
                    number += ".";
                }
                break;

            case R.id.bu_plus_mins:
                if(!mins)
                {
                    mins=true;
                    number="-"+number;
                }
                break;


        }
        edt1.setText(number);
    }

    public void oprartor_event(View view) {
        isnewop=true;

        oldnum=edt1.getText().toString();
        switch (view.getId())
        {
            case R.id.bu_addition:
                op="+";
                break;
            case R.id.bu_divide:
                op="/";
                break;
            case R.id.bu_minus:
                op="-";
                break;
            case R.id.bu_multiply:
                op="*";
                break;


        }

    }

    public void equal_event(View view) {
        if(oldnum=="")
        {
            edt1.setText("0");
            return;
        }
        newnum=edt1.getText().toString();
        double result=0.0;
        switch (op)
        {
            case "+":
                edt2.setText(oldnum+op+newnum);
                result=Double.parseDouble(oldnum)+Double.parseDouble(newnum);
                break;
            case "-":
                edt2.setText(oldnum+op+newnum);
                result=Double.parseDouble(oldnum)-Double.parseDouble(newnum);
                break;
            case "*":
                edt2.setText(oldnum+op+newnum);
                result=Double.parseDouble(oldnum)*Double.parseDouble(newnum);
                break;
            case "/":
                edt2.setText(oldnum+op+newnum);
                result=Double.parseDouble(oldnum)/Double.parseDouble(newnum);
                break;

        }
        edt1.setText(result+"");
    }

    public void ac_button(View view) {
        edt2.setText("");
        edt1.setText("0");
        oldnum="";
        newnum="";
        isnewop=true;

    }

    public void persent_event(View view) {
        Double number=Double.parseDouble(edt1.getText().toString())/100;
        edt2.setText("");
        edt1.setText(number+"");
        isnewop=true;
    }
}