package HashMap2;

public class ChainingHashSet<K,V> {
    private int num;
    private int capacity;
    private SeqSearchST<K,V>[] st; //链表数组对象
    public ChainingHashSet(int initialcapacity){
        capacity=initialcapacity;
        st=(SeqSearchST<K,V>[])new Object[capacity];
        for(int i =0;i<capacity;i++){
            st[i]=new SeqSearchST<>();
        }

    }
    public int hash(K key){
        return ((key.hashCode())&0x7fffffff)%capacity;
    }
    public V get(K key){
        return st[hash(key)].get(key);
    }
    public void put(K key,V value){
        st[hash(key)].put(key,value);
    }



}
//SeqSearchSt基于链表的符号表实现
class SeqSearchST<K,V>{
    private Node first;
    private class Node{
        K key;
        V value;
        Node next;
        public Node(K key,V value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;

        }
    }
    public void put(K key,V value){
        //查找是否有对应的key
        Node node;
        for(node=first;node!=null;node=node.next){
            if(key.equals(node.key)){
                node.value=value;
                return;
            }

        }
        first=new Node(key,value,first);

    }
    public V get(K key) {
        for (Node node = first; node != null;node=node.next){
            if(key.equals((node.key))){
                return node.value;
            }
        }
        return null;
    }

}