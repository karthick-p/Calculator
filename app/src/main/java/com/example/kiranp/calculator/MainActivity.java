package com.example.kiranp.calculator;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity{
    String new_num = "0";
    String con_num = "0";
    String operand_sym = "";
    int equal_flag = 0;
    public TextView output;
    Queue num = new LinkedList();
    Queue op = new LinkedList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        output = findViewById(R.id.result);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

    public void buttonpress(View button) {
        output = findViewById(R.id.result);
        if(equal_flag == 1 && (!(op.isEmpty()))){
            System.out.println("Veri");
            num.remove();
        }
        switch (button.getId()){
            case R.id.n0:
                new_num = "0";
                num.add(new_num);
                break;
            case R.id.n1:
                new_num = "1";
                num.add(new_num);
                break;
            case R.id.n2:
                new_num = "2";
                num.add(new_num);
                break;
            case R.id.n3:
                new_num = "3";
                num.add(new_num);
                break;
            case R.id.n4:
                new_num = "4";
                num.add(new_num);
                break;
            case R.id.n5:
                new_num = "5";
                num.add(new_num);
                break;
            case R.id.n6:
                new_num = "6";
                num.add(new_num);
                break;
            case R.id.n7:
                new_num = "7";
                System.out.println(new_num);
                output.setText("7");
                num.add(new_num);
                break;
            case R.id.n8:
                new_num = "8";
                num.add(new_num);
                break;
            case R.id.n9:
                new_num = "9";
                num.add(new_num);
                break;
            case R.id.dot:
                new_num =".";
                num.add(new_num);
                break;
        }
    }
    public void operand(View operand){
        equal_flag = 0;
        output = findViewById(R.id.result);
        while (!(num.isEmpty())){
            con_num += (String)num.remove();
            op.add(con_num);
        }
        System.out.println(con_num);
        System.out.println(num.isEmpty());
        switch (operand.getId()){
            case R.id.add:
                operand_sym = "+";
                op.add(operand_sym);
                break;
            case R.id.sub:
                operand_sym = "-";
                op.add(operand_sym);
                break;
            case R.id.mul:
                operand_sym = "*";
                op.add(operand_sym);
                break;
            case R.id.div:
                operand_sym = "/";
                op.add(operand_sym);
                break;
        }
        con_num="";
    }
    public void equals(View equalbutton){
        double firstnum_deq = 0,secondnum_deq= 0;
        String a = "", b="";
        String op_deq ="";
        if (num.isEmpty()){
            //bad expression;
            System.out.println("bad expression");

        }
        else{
            while (!(num.isEmpty())){
                con_num += num.remove();
                op.add(con_num);
            }
            b = (String) op.remove();
            firstnum_deq = Double.parseDouble(b);
            while(!(op.isEmpty())){
                op_deq = (String) op.remove();
                b = (String) op.remove();
                secondnum_deq = Double.parseDouble(b);
                switch(op_deq) {
                    case "+":
                        System.out.println(firstnum_deq);
                        System.out.println(secondnum_deq);
                        firstnum_deq = firstnum_deq + secondnum_deq;
                        break;
                    case "-":
                        firstnum_deq = firstnum_deq - secondnum_deq;
                        break;
                    case "*":
                        firstnum_deq = firstnum_deq * secondnum_deq;
                        break;
                    case "/":
                        firstnum_deq = firstnum_deq / secondnum_deq;
                }
            }
            num.add(Double.toString(firstnum_deq));
            equal_flag = 1;
            con_num="";
            System.out.println(firstnum_deq);
        }
    }
}
