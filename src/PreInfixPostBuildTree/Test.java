package PreInfixPostBuildTree;

public class Test
{



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
    //中序遍历
    public void  infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    /**
     *
     * @param value 希望删除结点的值
     * @return  找到该值的结点然后返回
     */
    public Node search(int value){
        if(this.value==value){
            return this;
        }else if(value<this.value){
            if(this.left==null) {
                return null;
            }
            return this.left.search(value);
        }else{
            if(this.right==null) return null;
            return this.right.search(value);
        }
    }
    //查找要删除结点的父结点
    public Node searchParent(int value){
        if((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)){
            return this;
        }else{
            if(value<this.value&&this.left!=null){
                return this.left.searchParent(value);
            }else if(value>=this.value&&this.right!=null){
                return this.right.searchParent(value);
            }else{
                return null;
            }
        }
    }
public  Node buildTree(int[] preOrder,int[] inOrder){
        return buildTree(preOrder,inOrder,0,0,inOrder.length);
}


public Node  buildTree(int[] pre,int[] in,int preStart,int inStart,int length) {
    if (length == 0) return null;
    int j = 0;
    while (j < length && in[j + inStart] != pre[preStart]) {
        j++;
    }
    if (j >= length) {
        throw new RuntimeException("不匹配");

    }
    Node root = new Node(pre[preStart]);
    root.left = buildTree(pre, in, preStart + 1, inStart, j);
    root.right = buildTree(pre, in, preStart + 1 + j, inStart + 1 + j, length - j - 1);
    return root;
}
public Node buildTreeByInAndPost(int[] in,int[] post){
        if(in==null||post==null||in.length!=post.length){
            throw new RuntimeException("不匹配");
        }
        return buildTreeByInAndPost(in,post,0,post.length-1,post.length);
            
    }


    private Node buildTreeByInAndPost(int[] in, int[] post, int inStart, int postEnd, int length) {
            if(length==0) return null;
        int j=0;
        while(j<length&&in[j+inStart]!=post[postEnd]){
        j++;
        }
        if(j>=length){
            throw new RuntimeException("不匹配");
        }
        int rightSize=length-j-1;
        Node root=new Node(post[postEnd]);
        root.left=buildTreeByInAndPost(in,post,inStart,postEnd-rightSize-1,j);
        root.right=buildTreeByInAndPost(in,post,inStart+j+1,postEnd-1,rightSize);
        return  root;

    }
}