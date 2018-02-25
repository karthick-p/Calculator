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
    Queue trial = new LinkedList();
   // Queue op = new LinkedList();
    Stack number = new Stack();
    String temp ="";
    String temp_calc = "0";
   // Stack<String> trial = new Stack<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        output = findViewById(R.id.result);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

    public void buttonpress(View button) {
       // System.out.println("Hi");
        output = findViewById(R.id.result);
//        if(equal_flag == 1 && (!(op.isEmpty()))){
//            num.remove();
//        }
//        if (!(number.isEmpty())){
//            temp = (String)number.peek();}
        switch (button.getId()){
            case R.id.n0:
                new_num = "0";
              //  num.add(new_num);
                break;
            case R.id.n1:
                new_num = "1";
//                num.add(new_num);
                break;
            case R.id.n2:
                new_num = "2";
//                num.add(new_num);
                break;
            case R.id.n3:
                new_num = "3";
//                num.add(new_num);
                break;
            case R.id.n4:
                new_num = "4";
//                num.add(new_num);
                break;
            case R.id.n5:
                new_num = "5";
//                num.add(new_num);
                break;
            case R.id.n6:
                new_num = "6";
//                num.add(new_num);
                break;
            case R.id.n7:
                new_num = "7";
             //   System.out.println(new_num);
             //   output.setText("7");
//                num.add(new_num);
                break;
            case R.id.n8:
                new_num = "8";
//                num.add(new_num);
                break;
            case R.id.n9:
                new_num = "9";
//                num.add(new_num);
                break;
            case R.id.dot:
                new_num =".";
//                num.add(new_num);
                break;
        }
//        number.push(new_num);
      //  System.out.println(new_num);
        trial.add(new_num);
        compute();
    }
    public void operand(View oper){
//        equal_flag = 0;
        output = findViewById(R.id.result);
//        if (temp_calc.equals("1")){
//
//        }
//        while (!(num.isEmpty())){
//            con_num += (String)num.remove();
////            op.add(con_num);
//        }
//        System.out.println(con_num);
//        System.out.println(num.isEmpty());
        switch (oper.getId()){
            case R.id.add:
                operand_sym = "+";
//                op.add(operand_sym);
                break;
            case R.id.sub:
                operand_sym = "-";
//                op.add(operand_sym);
                break;
            case R.id.mul:
                operand_sym = "*";
//                op.add(operand_sym);
                break;
            case R.id.div:
                operand_sym = "/";
//                op.add(operand_sym);
                break;
        }
//        con_num="";
        trial.add(operand_sym);
        System.out.println("added");
        compute();
    }

    public void compute(){
      //  Stack<String> b = (Stack<String>) trial.clone();
       // Queue q2 = ((Cloneable)trial).clone();
        Queue b = new LinkedList();
        Iterator<Integer> it = trial.iterator();
        while(it.hasNext())  {
            b.add(it.next());
        }

        String number_patch = "";
        String temp;
        String operand = "";
        Double total = 1.0;
        Double second_number = 1.0;
        int i =0;
        Double first = 1.0;
        String first_patch = "";
        String flag = "0";
        while (!(b.isEmpty())){
            temp = (String) b.remove();
          //  System.out.println(temp);
            if(!(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/"))){
                first_patch += temp;
                first = Double.parseDouble(first_patch);
            }
            else{
                operand = temp;
                System.out.println("break");
                number_patch = "";
                break;}
        }
        total = first;
        System.out.println(total);

        while (!(b.isEmpty())){
            temp = (String) b.remove();
            if(!(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/"))){
                number_patch += temp;
                System.out.println(temp);
                second_number = Double.parseDouble(number_patch);
                flag = "1";
                }

                //System.out.println(total);

            else {
                if (flag.equals("1")){
                switch (operand) {
                    case "+":
//                    System.out.println(firstnum_deq);
//                    System.out.println(secondnum_deq);
                        total = total + second_number;
                        break;
                    case "-":
                        total = total - second_number;
                        break;
                    case "*":
                        total = total * second_number;
                        break;
                    case "/":
                        total = total / second_number;
                        break;
                }
                flag = "0";}
                operand = temp;
                System.out.println(operand);
                number_patch = "";
            }
        }
        if(flag.equals("1")){
            switch (operand) {
                case "+":
//                    System.out.println(firstnum_deq);
//                    System.out.println(secondnum_deq);
                    total = total + second_number;
                    System.out.println(total);
                    break;
                case "-":
                    total = total - second_number;
                    break;
                case "*":
                    total = total * second_number;
                    break;
                case "/":
                    total = total / second_number;
                    break;
            }
            flag = "0";}
            System.out.println(total);
    }
//    public void equals(){
//        double firstnum_deq = 0,secondnum_deq= 0;
//        String a = "", b="";
//        String op_deq ="";
//        if (num.isEmpty()){
//            //bad expression;
//            System.out.println("bad expression");
//
//        }
//        else{
//            while (!(num.isEmpty())){
//                con_num += num.remove();
//                op.add(con_num);
//            }
//            b = (String) op.element();
//            firstnum_deq = Double.parseDouble(b);
//            while(!(op.isEmpty())){
//                op_deq = (String) op.remove();
//                b = (String) op.remove();
//                secondnum_deq = Double.parseDouble(b);
//                switch(op_deq) {
//                    case "+":
//                        System.out.println(firstnum_deq);
//                        System.out.println(secondnum_deq);
//                        firstnum_deq = firstnum_deq + secondnum_deq;
//                        break;
//                    case "-":
//                        firstnum_deq = firstnum_deq - secondnum_deq;
//                        break;
//                    case "*":
//                        firstnum_deq = firstnum_deq * secondnum_deq;
//                        break;
//                    case "/":
//                        firstnum_deq = firstnum_deq / secondnum_deq;
//                }
//            }
//            num.add(Double.toString(firstnum_deq));
//            equal_flag = 1;
//            con_num="";
//            System.out.println(firstnum_deq);
//       }
}

