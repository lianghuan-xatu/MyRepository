import java.util.Iterator;

public class Test{
    public static void main(String[] args){


    }
    class Node{
        String Key;
        int Value;
        Node next;
        public Node(String key,int value){
            this.Key=key;
            this.Value=value;
        }
    }
    class LinkedList{
        Node head=null;
        public void addByOrder(Node node){
            Node temp=head.next;
            boolean flag=false;
            while(true){
                if(temp.next.Value==node.Value){
                    flag=true;
                    break;

                }
                else if(temp.next.Value>node.Value){
                    break;
                }
                temp=temp.next;
            }
            if(flag==true){
                    System.out.println("已存在！");

            }else{
                node.next=temp.next;
                temp.next=node;
            }

        }
        public void delete(Node node){
            Node temp=head;
            boolean flag=false;
            while(true){
                if(temp.next==null)
                    break;
                else if(temp.next.Value==node.Value){
                    flag=true;
                    break;

                }

                temp=temp.next;
            }
            if(flag){
                temp.next=temp.next.next;

            }else{
                System.out.println("未找到");
            }

        }
        public void update(Node node) {
            Node temp = head;
            boolean flag = false;
            while (true) {
                if (temp.next == null) {
                    break;
                } else if (temp.Key == node.Key){
                    flag=true;
                    break;
                }
            }
            if(flag==true){
                temp.Value=node.Value;

            }else{
                System.out.println("未找到");
            }
        }
        //链表反转
        public void reverseList(Node head){
            Node next=null;
            Node pre=null;
            Node temp=head.next;
            while(temp!=null){
                next=temp.next;
                temp.next=pre;
                pre=temp;
                temp=next;
            }
            head.next=pre.next;

        }
        //链表倒数第几个元素
        public Node FindLastIndexNode(int index){
            Node temp=head.next;
            if(head.next==null)
                return null;
            int size=getLength();
            if(size<=0||size<index){
                return null;
            }
            for(int i=0;i<size-index;i++){
                temp=temp.next;
            }
            return temp;
        }
        //求链表的节点数目
        public int getLength(){
            if(head.next==null){
                return 0;
            }
            Node temp=head;
            int size=0;
            while(temp.next!=null){
                size++;
            }
            return size;
        }





    }


}
//环形链表  约瑟夫问题
class Boy{
    private int no;
    private Boy next;
    public Boy(int no){
        this.no=no;
    }
    public int getNo(){
        return no;
    }
    public void setNo(){
        this.no=no;
    }
    public void setNext(Boy boy){
        this.next=boy;
    }
    public Boy getNext(){
        return next;
    }
}
class CircleSingleLinkedList{
    Boy first=new Boy(-1);
     public void addBoy(int nums){
         if(nums<1)
         return;
        Boy curBoy=null;
        for(int i=1;i<=nums;i++){
            Boy boy=new Boy(i);
            if( i==1){
                first=boy;
                boy.setNext(first);
                curBoy=first;

            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }

     }

     public void showBoy(){
         if(first==null){
             System.out.println("链表空");
             return;
         }
         Boy cur=first;
         while(true){
             if(cur.getNext()==first){
                 break;
             }
             System.out.println(cur);
         }
         cur=cur.getNext();


    }
    class Josepfu{

        public void countBoy(int startno,int counNum,int nums){
            if(first==null||startno<1||startno>nums){
                return;
            }
            Boy helper=first;
            while(true){
                if(helper.getNext()==null)
                    break;
                helper=helper.getNext();
            }
            for (int i=0;i<startno-1;i++){
                first=first.getNext();
                helper=helper.getNext();
            }
            first=first.getNext();
            helper.setNext(first);
        }
    }

}

class test{
    public static void main(String[] args){


    }
    class FixedCapacityStack<Item>{
        private Item[] a;
        private int N;//size
        public FixedCapacityStack(int cap){
            a=(Item[])new Object[cap];
        }
        public boolean isEmpty(){ return N==0;}
        public int size(){
            return N;
        }
        public void push(Item item){
            if(N==a.length)
                resize(2*a.length);
            a[N++]=item;
        }
        public Item pop(){
            Item item= a[--N];
            a[N]=null;//避免对象游离
            if(N>0&&N==a.length/4)
                resize(a.length/2);
            return item;
        }
        public void resize(int max){
            Item[] temp=(Item[])new Object[max];
            for(int i=0;i<N;i++){
                temp[i]=a[i];

            }
            a=temp;
        }


    }
}

//下压堆栈   链表实现
class Stack<Item> implements Iterable<Item>{
    class Node{
      Item item;
      Node next;
      public Node(Item item){
          this.item=item;
      }

    }
    private Node first;
    private int N;
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        Node oldfirst=first;
        first=new Node(item);
        first=oldfirst;
        N++;

    }
    public Item pop() {
        Item item=first.item;
        first=first.next;
        N--;
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return null;
    }

}
//KMP算法
class KMP{
    public static void main(String[] args){
        char[] pattern={'d','e','r','y'};
        char[] text={'g','j','d','e','r','y'};
        int prefix[]=new int[pattern.length];
        int n=pattern.length;
        int m=text.length;
        int i=0,j=0;
        while(i<text.length){
            if(j==pattern.length-1&&text[i]==pattern[j]){
                System.out.println("find  position at "+(i-j));

            }
            if(text[i]==pattern[j]){
                i++;
                j++;
            }else{
                j=prefix[j];
                if(j==-1){
                    i++;
                    j++;
                }
            }

        }


    }
    public static void prefixtable(char[] pattern,int[] prefix,int n){
        prefix[0]=0;
        int i=1;
        int len=0;
        while(i<n){
            if(pattern[i]==pattern[len]){
                len++;
                prefix[i]=len;
                i++;
            }else{
                if(len>0){
                    len=prefix[len-1];
                }else{
                    prefix[i]=len;
                    i++;
                }
            }
        }
 }
 public void movePrefixtable(int[] prefix){
        for(int i=prefix.length-1;i>0;i--){
            prefix[i]=prefix[i-1];
         }
        prefix[0]=-1;

 }





}
class BinarySortTree{
    private Node root;
    public void add(Node node){
        if(root==null){
            root=node;
        }else{
            root.add(node);
        }
    }
    public void infixOrder(){
        if(root==null){
            return ;
        }
        else{
            root.infixOrder();
        }
    }
    public Node search(Node node){
        if(root==null){
            return null;
    }else{
        return root.search(node);
        }
    }

    public Node searchParent(Node node){
        if(root==null)
            return null;
        else{
           return  root.searchParent(node);
        }
    }
    public int deleteRightTreeMin(Node node){
        Node target=node;
        while(target.left!=null){
            target=target.left;
        }
        delNode(target);
        return target.value;
    }
    public void delNode(Node node){
        if(root==null){
            return;
        }else{
            Node target=search(node);
            if(target==null)
                return;
            if(root.left==null&&root.right==null){
                root=null;
                return;
            }
            Node parent=searchParent(target);
            if(target.left==null&&target.right==null){
                if(parent.left!=null&&parent.left==target)
                    parent.left=null;
                if(parent.right!=null&&parent.right==target)
                    parent.right=null;

            }else if(target.left!=null&&target.right!=null){
                int MinValue=deleteRightTreeMin(target.right);
                target.value=MinValue;
            }else{
               if(target.left!=null){
                   if(parent!=null){
                      if( parent.left!=null){
                          parent.left=target.left;
                      }else{
                          parent.right=target.left;
                      }
                   }else{
                       root=target.left;
                   }
               }else{
                   if(parent!=null) {
                       if (parent.left != null) {
                           parent.left = target.right;
                       } else {
                           parent.right = target.right;
                       }
                   }else{
                           root=target.right;
                       }
                   }
               }




            }


        }











    }




class Node{
    int value;
    Node left,right;
    public Node(int value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
    public void add(Node node){
        if(node==null){
            return;
        }
        if(node.value<this.value){
            if(this.left==null){
                this.left=node;
            }else{
                this.left.add(node);
            }

        }else{
            if(this.right==null){
                this.right=node;
            }else{
                this.right.add(node);
            }

        }
    }
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }

    }
    public Node search(Node node){
        if(this.value==node.value){
            return this;
        }else if(this.value>node.value){
            if(this.left!=null){
            this.left.search(node);}
            return null;
        }else {
            if(this.right!=null){
                this.right.search(node);}
                return null;
            }

        }


    public Node searchParent(Node node){
        if((this.left!=null&&this.left.value==node.value)||(this.right!=null&&this.right.value==node.value)){
            return this;
        }else{
            if(this.value<node.value&&this.right!=null){
                return this.right.searchParent(node);
            }else if(this.value>node.value&&this.left!=null){
                return this.left.searchParent(node);
            }else{
                return null;
            }
        }
    }



    }

//堆排序

class HeapSort{
    public static void sort(int arr[]){
        for(int i=arr.length/2-1;i>0;i--){
            adjustHeap(arr,i,arr.length);
        }
        for(int j=arr.length-1;j>0;j--){
                swap(arr,0,j);
                adjustHeap(arr,0,j);
        }
    }
    public static void adjustHeap(int[] arr,int i,int length){
        int temp=arr[i];
        for(int k=2*i+1;k<length;k=k*2+1){
            if(k+1<length&&arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k]>temp){
                arr[i]=arr[k];//从上到下依次调整   i记住上一个元素的位置如果子元素小于上一个元素则发生交换
                     i=k;}
            else{
                break;
            }

        }
        arr[i]=temp;
    }
    public static void swap(int arr[],int a,int b ){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

}



