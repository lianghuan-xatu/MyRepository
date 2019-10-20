package AlgorithmsTest;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.omg.Messaging.SyncScopeHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public  static  void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else{
            System.out.println("EmptyTree");
        }
    }
    
    public static void main(String[] args){
        int arr[]={13,7,8,3,29,6,1};
        createHuffmanTree(arr);

    
    }
    public  static  Node createHuffmanTree(int[] arr){
        //遍历arr将每个arr元素构建成一个Node
        //将Node放入ArrayList中

        List<Node> nodes=new ArrayList<Node>();

            for (int value : arr) {
                nodes.add(new Node(value));
            }
            while(nodes.size()>1) {
            Collections.sort(nodes);
            System.out.println(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //从ArrayList 中删除leftNode和rightNode
            //将parent加入ArrayList
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
            Collections.sort(nodes);
            System.out.println("处理之后" + nodes);
        }
    return nodes.get(0);
    }


}
//为了让NODE持续排序Collections集合排序
//让Node实现comparable接口

class Node implements Comparable<Node>{
        int value;
        Node left;
        Node right;
    public void preOrder(){
        System.out.println(this);
       if(this.left!=null){
           this.left.preOrder();
       }
       if(this.right!=null){
           this.right.preOrder();
       }
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public Node(int value){
            this.value=value;
        }

    @Override
    public int compareTo(Node o) {
        //从小到大排
        return this.value-o.value;
    }
}