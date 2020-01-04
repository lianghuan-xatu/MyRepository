package  AVL;

public class AVLTreeDemo{
    public static void main(String[] args){
    int[] arr={4,3,6,5,7,8};
    AVLTree avlTree=new AVLTree();
    for(int i=0;i<arr.length;i++){
        avlTree.add(new Node(arr[i]));
    }
    avlTree.infixOder();
    System.out.println(avlTree.search(3).height());
    System.out.println(avlTree.search(4).height());

    }
}
class  AVLTree{
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

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //返回以该结点为根结点的树的高度
    public int height(){
        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;

    }
    public  int leftHeight(){
        if(left==null){
            return 0;
        }
        return left.height();
    }
    public int rightHeight(){
        if(right==null){
            return 0;
        }
        return right.height();
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        if(rightHeight()-leftHeight()>1){
            if(right!=null&&right.leftHeight()>right.rightHeight()){
                right.rightRotate();
                leftRotate();
            }else{
                leftRotate();
            }
            return;
        }
        if(leftHeight()-rightHeight()>1){
            if(left!=null&&left.rightHeight()>left.leftHeight()){
                left.rightRotate();
                rightRotate();
            }else{
                rightRotate();
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * @param value 希望删除结点的值
     * @return 找到该值的结点然后返回
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) return null;
            return this.right.search(value);
        }
    }

    //查找要删除结点的父结点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }
    private void leftRotate(){
        Node newNode=new Node(value);
        newNode.left=left;
        newNode.right=right.left;
        value=right.value;
        right=right.right;
        left=newNode;
    }
    private void rightRotate(){
        Node newNode=new Node(value);
        newNode.right=right;
        newNode.left=right.left;
        value=left.value;
        left=left.left;
        right=newNode;
    }
}