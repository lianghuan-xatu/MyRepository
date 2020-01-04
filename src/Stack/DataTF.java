package Stack;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.Math.pow;

public class DataTF
{
    public static void main(String[] args){
       // System.out.println("请输入一个数");
       // Scanner scan=new Scanner(System.in);
     //   int data=scan.nextInt();
     //   conversion8(data);
     //   conversion2(data);
        String DT="1001";
       System.out.println( conversion2_8(DT));


    
    }
    public static void conversion8(int data){
                Stack<Integer> stack=new Stack<>();
                while(data!=0){
                    stack.push(data%8);
                    data=data/8;
                }
                while(!stack.empty()){
                    System.out.println(stack.pop());
        }
    }
    public static void conversion2(int data){
        Stack<Integer> stack=new Stack<>();
        while(data!=0){
            stack.push(data%2);
            data=data/2;
        }
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
    }
    public static String conversion2_8(String data){
        Stack<Character> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        char[] data2=data.toCharArray();
        for(char ch:data2){
            if(ch=='1'||ch=='0'){
                stack1.push(ch);
            }
        }
        int sum=0;
        for(int i=3;i<data2.length;i+=3){
            for(int j=0;j<i;j++){
                if(!stack1.isEmpty()){
                 char c=stack1.pop();//Integer.parseInt(String.valueOf(stack1.pop()),10);
                 sum+=(c-48)*pow(2,j);}
            }
            stack2.push(sum);
            sum=0;


        }
        sum=0;
       int count=0;
        while(!stack1.isEmpty()){

            char c=stack1.pop();//Integer.parseInt(String.valueOf(stack1.pop()),10);
            sum+=(c-48)*pow(2,count); count++;
        }
        stack2.push(sum);
        sum=0;

        StringBuilder sb=new StringBuilder();
        while(!stack2.isEmpty()){
            sb.append(stack2.pop());
        }
        String result=sb.toString();
        return result;

    }
}
