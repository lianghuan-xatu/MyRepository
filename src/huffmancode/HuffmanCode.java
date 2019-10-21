package huffmancode;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args){
            String content="i like like like java do you like a java";
            byte[] contentBytes=content.getBytes();
            System.out.println(contentBytes.length);
            List<Node> nodes=getNodes(contentBytes);
            System.out.println(nodes);
            //测试
        //创建Huffman树
            Node huffmanNode=createHuffman(nodes);
            //huffman 树遍历
            huffmanNode.preOrder();
    //测试2
        System.out.println("huffman code table");
//用huffTab来接收getCodes方法创建的huffman code table
                 Map<Byte,String> huffTab=getCodes(huffmanNode);
             System.out.println(huffTab);
             byte[] context=content.getBytes();
             //用于接收数据的byte[]数组
        byte[] data=zip(context,huffTab);
        for(byte b1:data)
        System.out.println("压缩数据"+b1);


    }
    //编写一个方法将字符串对应的byte数组，通过Huffman编码表压缩之后的byte数组

    /**
     *
     * @param bytes 原始数字对应的字节数组
     * @param huffTab  编码表
     * @return 压缩之后的字节数组
     *
     */
    public static byte[] zip(byte[] bytes, Map<Byte,String> huffTab){
        StringBuilder st=new StringBuilder();
        for(byte b:bytes){
            st.append(huffTab.get(b));
        }
       int len;
        if(st.length()%8==0){
            len=st.length()/8;
        }else{
            len=st.length()/8+1;
        }
        byte huffmanCodeBytes[]=new byte[len];
        int index=0;
        for(int i=0;i<st.length();i+=8){
            String strByte;
            if(i+8>st.length()){
                strByte=st.substring(i);
            }
            else{
                strByte=st.substring(i,i+8);
            }
            huffmanCodeBytes[index]=(byte)Integer.parseInt(strByte,2);
            index++;
        }
        return huffmanCodeBytes;
    }

    //为了调用方便重载方法
    private static Map<Byte,String> getCodes(Node root){
        if(root==null) return null;
        else{
            getCodes(root.left,"0",stringbuilder);
            getCodes(root.right,"1",stringbuilder);
        }
        return huffmancodes;
    }

//生成Huffman编码表   放入map中
    //生成huffman表时用stringbuilder来储存叶子结点的路径
      static StringBuilder stringbuilder=new StringBuilder();
      static HashMap<Byte, String> huffmancodes=new HashMap<>();
    private static void getCodes(Node node,String code,StringBuilder sb1){
        StringBuilder sb2=new StringBuilder();
        sb2.append(sb1);
        sb2.append(code);

        if(node!=null) {
            if (node.data == null) {
            getCodes(node.left,"0",sb2);
            getCodes(node.right,"1",sb2);

            }else{
                huffmancodes.put(node.data,sb2.toString());
            }
        }
    }


    public static Node createHuffman(List<Node> list){
        while(list.size()>1){
            Collections.sort(list);
            Node leftNode=list.get(0);
            Node rightNode=list.get(1);
            Node parent=new Node(null,leftNode.weight+rightNode.weight);
            parent.left=leftNode;
            parent.right=rightNode;
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parent);
                             }
        return list.get(0);
    }


    public static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }
        else{
            System.out.println("Empty");
        }
    }
    private static List<Node> getNodes(byte[] bytes){
        ArrayList<Node>  nodes=new ArrayList<>();
        //遍历字节数组   得到每个字符出现的次数   map
        HashMap<Byte,Integer> counts=new HashMap<>();
        for(byte b:bytes){
            Integer count=counts.get(b);
            if(count==null){
                //map还没有这个数据
                counts.put(b,1);
            }else{
                counts.put(b,count+1);
            }
        }
        //把每一个键值转换成node对象然后加入到nodes集合中
        for(HashMap.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
    return  nodes;
    }
}
class Node implements Comparable<Node>{
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data,int weight) {
        this.data=data;
        this.weight = weight;
    }


    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
    public  void  preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}

