package PolyTest;

import java.util.Scanner;

public class TestDemo{
   public static void main(String[] args){
       
       while(true){
           PolyList PL1=new PolyList();
           PolyList PL2=new PolyList();
           System.out.println("请输入你的第一个多项式的系数和指数以0，0结尾");
           Scanner scanner=new Scanner(System.in);
           int i=scanner.nextInt();
           int j=scanner.nextInt();
           while(i!=0||j!=0){
               PL1.addNode(new PolyNode(i,j));
               i=scanner.nextInt();
               j=scanner.nextInt();
           }
           System.out.println("'你输入的第一个多项式是：");
           System.out.println("多项式PL1是"+PL1.print());


           System.out.println("请输入你的第二个多项式的系数和指数以0，0结尾");
           i=scanner.nextInt();
           j=scanner.nextInt();
              while(i!=0||j!=0){
               PL2.addNode(new PolyNode(i,j));
               i=scanner.nextInt();
               j=scanner.nextInt();
           }
              scanner.close();
           System.out.println("'你输入的第二个多项式是：");
           System.out.println("多项式PL2是"+PL2.print());

           System.out.println("多项式相加结果为："+PolyList.Add(PL1,PL2).print());

           System.out.println("多项式相减结果为："+PolyList.Sub(PL1,PL2).print());

   }
   }

}

class PolyNode{
    private int i;
    private int j;

    public PolyNode next;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
    public PolyNode(int i,int j){
        this.i=i;
        this.j=j;

    }
    public PolyNode() {
        this.i = 0;
        this.j = 0;
    }
}
class PolyList {
    PolyNode head;
    PolyNode cur;

    public PolyList() {
        head=new PolyNode();
        cur=head;
        head.next=null;

    }


    public void addNode(PolyNode node) {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    public boolean isEmpty(){
        return head.next==null;
    }
    public String print(){
        if(this.isEmpty()){
        System.out.println("The PolyList is Empty!");
        return null;}
        else{
            cur=head.next;
            StringBuilder s=new StringBuilder("");
            StringBuilder i=new StringBuilder("");
            StringBuilder j=new StringBuilder("");
            StringBuilder TheOne=new StringBuilder("");
            int count1=0;
            int count2=0;
            while(cur!=null){
                if(cur.getI()==0){
                    count1++;
                }
                count2++;
                cur=cur.next;
            }
            if(count1==count2){
                s.append("0");
            }else{
              cur=head.next;
              while(cur!=null){
                  i.delete(0,i.length());
                  j.delete(0,j.length());
                  TheOne.delete(0,TheOne.length());
                  if(cur.getI()==1||cur.getI()==-1){
                      i.append("");
                     if(cur.getJ()==1){
                         j.append("");
                         TheOne.append(i.toString()).append("x").append(i.toString());
                     }else if(cur.getJ()==0){
                         j.append("");
                         TheOne.append(String.valueOf(cur.getI()));
                     }else{
                         j.append(String.valueOf(cur.getJ()));
                         TheOne.append(i.toString()).append("x").append(String.valueOf(cur.getJ()));
                         
                     }
                     s.append(String.valueOf(cur.getI())).append(TheOne.toString());
                  
                  }else if(cur.getI()==0){
                      i.append("");
                      if(cur.getJ()==1){
                          j.append("");
                          TheOne.append(i.toString()).append("x").append(i.toString());
                      }else if(cur.getJ()==0){
                          j.append("");
                          TheOne.append(String.valueOf(cur.getJ()));
                      }else{
                          j.append(String.valueOf(cur.getJ()));
                          TheOne.append(i.toString()).append("x").append(String.valueOf(cur.getJ()));

                      }
                      s.append("");
                      
                  
                      
                  }
                  else if(cur.getI()<0){
                      i.append(String.valueOf(-cur.getI()));
                      if(cur.getJ()==1){
                          j.append("");
                          TheOne.append(i.toString()).append("x").append(i.toString());
                      }else if(cur.getJ()==0){
                          j.append("");
                          TheOne.append(String.valueOf(cur.getJ()));
                      }else{
                          j.append(String.valueOf(cur.getJ()));
                          TheOne.append(i.toString()).append("x").append(String.valueOf(cur.getJ()));

                      }
                      s.append("-").append(TheOne.toString());
                  }else{
                      i.append(String.valueOf(cur.getI()));
                      if(cur.getJ()==1){
                          j.append("");
                          TheOne.append(i.toString()).append("x").append(i.toString());
                      }else if(cur.getJ()==0){
                          j.append("");
                          TheOne.append(String.valueOf(cur.getJ()));
                      }else{
                          j.append(String.valueOf(cur.getJ()));
                          TheOne.append(i.toString()).append("x").append(String.valueOf(cur.getJ()));

                      }
                      s.append("+").append(TheOne.toString());
              }
                  cur=cur.next;
            }


        }
      return s.toString();
    }
    
    }
    
    public static PolyList Add(PolyList PL1,PolyList PL2){
        PolyList result=new PolyList();
        PL1.cur=PL1.head.next;
        PL2.cur=PL2.head.next;

        while(PL1.cur!=null&&PL2.cur!=null){
            if(PL1.cur.getJ()==PL2.cur.getJ()){
                result.addNode(new PolyNode(PL1.cur.getI()+PL2.cur.getI(),PL1.cur.getJ()));
                PL1.cur=PL1.cur.next;
                PL2.cur=PL2.cur.next;
            }else if(PL1.cur.getJ()<PL2.cur.getJ()){
                result.addNode(new PolyNode(PL1.cur.getI(), PL1.cur.getJ()));
                PL1.cur=PL1.cur.next;
            }else{
                result.addNode(new PolyNode(PL2.cur.getI(),PL2.cur.getJ()));
                PL2.cur= PL2.cur.next;
            }
     }
        while(PL1.cur!=null){
            result.addNode(PL1.cur);
            PL1.cur=PL1.cur.next;
        }
        while(PL2.cur!=null){
            result.addNode(PL2.cur);
            PL2.cur=PL2.cur.next;
        }
       //
        //return result;
        result.cur=result.head.next;
        PolyNode tempPre=result.cur;
        PolyNode temp=result.cur.next;
        while(result.cur.next!=null){
                while(temp!=null){
                    if(temp.getJ()!=result.cur.getJ())
                    {
                        temp=temp.next;
                        tempPre = tempPre.next;
                    }
                    else{
                        result.cur.setI(result.cur.getI()+temp.getI());
                        tempPre=tempPre.next;
                        temp=temp.next;

                    }

                }
                result.cur=result.cur.next;
                tempPre=result.cur;
                temp=result.cur.next;

        }
        return result;
    }
    public static PolyList Sub(PolyList p1,PolyList p2){

        PolyList result=new PolyList();

        p2.cur = p2.head.next;
        while(p2.cur!=null){
            p2.cur.setI(-(p2.cur.getI()));
            p2.cur=p2.cur.next;
        }
        //System.out.println(p2.printS());
        //分别指向p1 p2的第一个元素
        p1.cur=p1.head.next;
        p2.cur=p2.head.next;
        while(p1.cur!=null && p2.cur!=null){

            if(p1.cur.getI()==p2.cur.getI()){

                result.addNode(new PolyNode(p1.cur.getI()+p2.cur.getI(),p1.cur.getJ()));
                p1.cur=p1.cur.next;
                p2.cur=p2.cur.next;
            }
            else if(p1.cur.getI()<p2.cur.getI()){

                result.addNode(p1.cur);
                p1.cur=p1.cur.next;

            }else{
                result.addNode(p2.cur);
                p2.cur=p2.cur.next;
            }
        }
        while(p1.cur!=null){

            result.addNode(p1.cur);
            p1.cur=p1.cur.next;
        }
        while(p2.cur!=null){

            result.addNode(p2.cur);
            p2.cur=p2.cur.next;
        }
        return result;

    }

}
