package com.example.kiranp.calculator;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
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
    Queue b = new LinkedList();
    Queue c = new LinkedList();
    String temp ="";
    String temp_calc = "0";
    String root_flag = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        output = findViewById(R.id.result);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

    public void buttonpress(View button) {
        output = findViewById(R.id.result);
        switch (button.getId()){
            case R.id.n0:
                new_num = "0";
                output.append("0");
                break;
            case R.id.n1:
                new_num = "1";
                output.append("1");
                break;
            case R.id.n2:
                new_num = "2";
                output.append("2");
                break;
            case R.id.n3:
                new_num = "3";
                output.append("3");
                break;
            case R.id.n4:
                new_num = "4";
                output.append("4");
                break;
            case R.id.n5:
                new_num = "5";
                output.append("5");
                break;
            case R.id.n6:
                new_num = "6";
                output.append("6");
                break;
            case R.id.n7:
                new_num = "7";
                output.append("7");
                break;
            case R.id.n8:
                new_num = "8";
                output.append("8");
                break;
            case R.id.n9:
                new_num = "9";
                output.append("9");
                break;
            case R.id.dot:
                new_num =".";
                output.append(".");
                break;
        }
       // System.out.println(new_num);
        if (!(root_flag.equals("1"))){
            trial.add(new_num);
            compute();}
        else{
            //c.add(new_num);
            //root();
            }
    }
    public void operand(View oper){
        String x ="";
        output = findViewById(R.id.result);
        TextView result2 = findViewById(R.id.result2);
        if(root_flag.equals("1"))
            trial = b;
        root_flag = "0";
        switch (oper.getId()){
            case R.id.add:
                operand_sym = "+";
                output.append("+");
                break;
            case R.id.sub:
                operand_sym = "-";
                output.append("-");
                break;
            case R.id.mul:
                operand_sym = "*";
                x = "\u00D7";
                output.append(x);
                break;
            case R.id.div:
                operand_sym = "/";
                x = "\u00F7";
                output.append(x);
                break;
            case R.id.sqrt:
                operand_sym = "rt";
                root_flag = "1";
                x = "\u221A";
                output.append(x);
                break;
            case R.id.all:
                trial.removeAll(trial);
                result2.setText("0");
        }
       // System.out.println(operand_sym);
        if (!(root_flag.equals("1"))){
            trial.add(operand_sym);
            compute();}
        else {
          //  c.add(operand_sym);
           // root();
        }
    }
    public void compute(){
        TextView result2 = findViewById(R.id.result2);
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
        Double first = 0.0;
        String first_patch = "";
        String flag = "0";
        while (!(b.isEmpty())){
            temp = (String) b.remove();
            if(!(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/"))){
                first_patch += temp;
                first = Double.parseDouble(first_patch);
            }
            else{
                operand = temp;
                //System.out.println("break");
                number_patch = "";
                break;}
        }
        total = first;
       // System.out.println(total);

        while (!(b.isEmpty())){
            temp = (String) b.remove();
            if(!(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/"))){
                number_patch += temp;
                second_number = Double.parseDouble(number_patch);
                flag = "1";
                }
            else {
                if (flag.equals("1")){
                switch (operand) {
                    case "+":
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
              //  System.out.println(operand);
                number_patch = "";
            }
        }
        if(flag.equals("1")){
            switch (operand) {
                case "+":
                    total = total + second_number;
                  //  System.out.println(total);
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
            String out ="";
            int o;
            if (Math.round(total)==total){
                o = (int) Math.round(total);;
                out = String.valueOf(o);}
            else
                out = Double.toString(total);
        System.out.println(out);
        result2.setText(out);
    }
    public void delete(View del){
        String text = output.getText().toString();
        output.setText(text.substring(0, text.length() - 1));
        Queue queue2 = new LinkedList();
/*https://stackoverflow.com/questions/4808852/remove-the-last-element-in-a-queue - for removing last element in queue*/
        while(!trial.isEmpty()){
            Object o = trial.remove();
            if(!trial.isEmpty()){
                queue2.add(o);
            }
        }
         trial = queue2;
         compute();
    }
    public void root() {
        Queue d = new LinkedList();
        Iterator<Integer> it = c.iterator();
        while (it.hasNext()) {
            d.add(it.next());
        }
        String temp ="";
        String rt_concat = "";
        Double value = 0.0;
        Double a = 0.0;
        //System.out.println(trial.size());
        while (!(d.isEmpty())) {
            temp = (String) d.remove();
            if (!(temp.equals("rt"))) {
                rt_concat += temp;
                value = Double.parseDouble(rt_concat);
            }
            else{
                break;}

        }

        if (!(value.equals(0.0))) {
                value = Double.parseDouble(rt_concat);
                a = Math.sqrt(value);
                rt_concat = Double.toString(a);
                System.out.println(a);
               // b.add(rt_concat);
            }
          // System.out.println(c.size());
    }
}


