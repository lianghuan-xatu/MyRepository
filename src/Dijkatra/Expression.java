package Dijkatra;

import java.util.Scanner;
import java.util.Stack;

public class Expression {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    while (true){
            try {
                System.out.println("请输入要计算的表达式");
                String exp = input.next();
                System.out.println(calc(exp + "#"));
            } catch (ArithmeticException e1) {
                e1.printStackTrace();
            }
        }}



    private static int calc(String exp) {
        Stack<Integer> num=new Stack<>();
        Stack<Character> ops=new Stack<>();
        ops.push('#');
        int i=0;
        char ch=exp.charAt(i);
        boolean flag=false;////判断连续的几个字符是否是数字，若是，就处理成一个数字。这样就能处理多位数的运算了。
        while(ch!='#'|| ops.peek()!='#'){
            if(ch>='0'&&ch<='9'){
                if(flag){
                    int temp=num.pop();
                    num.push(temp*10+Integer.parseInt(ch+""));
                }else{
                    num.push(Integer.parseInt(ch+""));
                }
                flag=true;
                i++;
            }else{
                flag=false;
                if(precede(ops.peek(),ch)=='<'){
                    ops.push(ch);
                    i++;
                }else if(precede(ops.peek(),ch)=='='){
                    ops.pop();
                    i++;
                }else if(precede(ops.peek(),ch)=='>'){
                    int  num1=num.pop();
                    int num2=num.pop();
                    int result=operate(num1,ops.pop(),num2);
                    num.push(result);
                }else {
                    System.out.println("表达式错误");
                    return -1;
                }

            }
        }
        return num.peek();
    }
    private static char precede(char peek,char ch){
        return relation[getIndex(peek)][getIndex(ch)];


    }
    private static int getIndex(char ch){
        int index=-1;
        if(ch=='+') index=0;
        else if(ch=='-') index=1;
        else if(index=='*') index=2;
        else if(index=='/') index=3;
        else if(index=='(') index=4;
        else if(index==')') index=5;
        else index=index;
        return index;
     }
     private  static int operate(int num1,char operate,int num2){
        int result=0;
        switch (operate){
            case '+':
                result=num1+num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
         return result;

     }


    public static final char[][] relation={
            {'>','>','<','<','<','>','>'},
            {'>','>','<','<','<','>','>'},
            {'>','>','>','>','<','>','>'},
            {'>','>','>','>','<','>','>'},
            {'<','<','<','<','<','=','!'},
            {'>','>','>','>','!','>','>'},
            {'<','<','<','<','<','!','='}

    };
    

}
