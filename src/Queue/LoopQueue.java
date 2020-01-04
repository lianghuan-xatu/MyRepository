package Queue;

import java.util.Arrays;

public class LoopQueue {

    //front=rear即头指针和尾指针相等，但是对应两种情况：一种是队列为空一种是队列为满
    //所以我们定义空出一个位置为满队列状态
    //front指向头元素   rear指向尾元素的下一个位置
    //  ifFull::(rear+1)%maxSize==front;

    public static void main(String[] args) {

    }
    }
class CQueue{
    private int front;
    private int rear;
    private int[] elem;
    private int maxSize;
    public CQueue(int maxSize){
        this.front=0;
        this.rear=0;
        this.elem=new int[maxSize];
        this.maxSize=maxSize;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    public void insert(int val){
        if(isFull()) return;
        elem[rear++]=val;
        rear=rear%maxSize;
    }
    public void poll(){
        if(isEmpty()) return;;
        front=++front%maxSize;

    }
    public  int peek(){
        if(isEmpty()) return -1;
        return elem[front];
    }
    public String toString(){
        String str="";
        for(int i:elem){
            str=str+i;
        }
        return str;
    }

}