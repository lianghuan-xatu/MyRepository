package Dijkatra;

import java.util.Scanner;
import java.util.Stack;

public class Evaluate {
    public static void main(String[] args){
        String s;
        Scanner scan=new Scanner(System.in);
        s=scan.nextLine();
        Stack<String> ops = new Stack<>();
        Stack<Double> val = new Stack<>();

    while(!s.isEmpty()) {
       
        if(s.equals("("))    ;
        else if(s.equals("+"))   ops.push(s);
        else if(s.equals("-"))   ops.push(s);
        else if(s.equals("*"))   ops.push(s);
        else if(s.equals("/"))   ops.push(s);
        else if(s.equals(")")){
            String op=ops.pop();
            double value=val.pop();
            if(op.equals("+")) value=value+val.pop();
            else if(op.equals("-")) value=val.pop()-value;
            else if(op.equals("*"))   value=val.pop()*value;
            else if(op.equals("/"))	  value=val.pop()/value;
            val.push(value);


        }else{
            val.push(Double.parseDouble(s));
        }
        
    }
    System.out.println(val.pop());
    }
}
