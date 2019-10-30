package BinarySortTree;

public class BinarySortTreeDemo {
    public static void main(String[] args){
    int arr[]={7,3,10,12,5,1,9,2};
    BinarySortTree binarySortTree=new BinarySortTree();
    for(int i=0;i<arr.length;i++){
        binarySortTree.add(new Node(arr[i]));
    }
    System.out.println("中序遍历二叉树");
    binarySortTree.infixOder();
    binarySortTree.delNode(2);
    binarySortTree.infixOder();
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
    public void infixOder(){
        if(root!=null){
        root.infixOrder();
    }else{
        System.out.println("空树");}

    }
    public Node search(int value){
        if(root==null){
            return null;
        }else{
            return root.search(value);
        }
    }
    public Node searchParent(int value){
        if(root==null){
            return null;
        }else{
            return root.searchParent(value);
        }
    }
    public int  delRightTreeMin(Node node){
        Node target=node;
        while(target.left!=null){
            target=target.left;
        }
        delNode(target.value);
        return target.value;
    }
    public void delNode(int value){
        if(root==null){
            return;
        }else{
            Node targetNode=search(value);
            if(targetNode==null){
                return;
            }
            //如果我们发现当前二叉排序树只有一个结点   直接删除
            if(root.left==null&&root.right==null){
                root=null;
                return;
            }
            Node parent=searchParent(value);
            //如果要删除的结点是叶子结点
            if(targetNode.left==null&&targetNode.right==null){
                if (parent.left!=null&&parent.left.value==targetNode.value){
                    parent.left=null;
                }else if(parent.right!=null&&parent.right.value==targetNode.value){
                    parent.right=null;
                }
            }else if(targetNode.left!=null&&targetNode.right!=null){
            int Minvalue=delRightTreeMin(targetNode.right);
            targetNode.value=Minvalue;
            }else{
                if(targetNode.left!=null){
                    if(parent!=null){
                    if(parent.left.value==value){
                        parent.left=targetNode.left;
                    }else{
                        parent.right=targetNode.left;
                    }}else{
                        root=targetNode.left;
                    }
                }else{
                    if(parent!=null){
                    if(parent.left.value==value){
                        parent.left=targetNode.right;
                    }else{
                        parent.right=targetNode.right;
                    }}else{
                        root=targetNode.right;
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


}