package HashMap;

import java.io.ObjectOutputStream;

public class LinearProbingHashMap<K,V> {
    private int num;    //散列表中键值对数目
    private int capacity;   //散列表大小
    private K[] keys;   //散列表中的键
    private V[] values; //散列表中的值
    public LinearProbingHashMap(int capacity){
        keys=(K[])new Object[capacity];
        values=(V[])new Object[capacity];
        this.capacity=capacity;

    }
    //散列函数
    public int hash(K key){
        return (key.hashCode()&0x7fffffff)%capacity;
    }
    public V get(K key){
        int index=hash(key);
        while(keys[index]!=null&&!keys.equals(keys[index]));
        {
            index=(index+1)%capacity;

        }
        return values[index];
    }
    public void put(K key,V value){
        if(num>=capacity/2){
            resize(2*capacity);}
            int index=hash(key);
            while(keys[index]!=null&&!keys.equals(keys[index])){
                index=(index+1)%capacity;
            }
            if(keys[index]==null){
                keys[index]=key;
                values[index]=value;
                return;
            }
            values[index]=value;
            num++;
}
//删除操作
    public void delete(K key){
        if((keys.toString()).contains(((CharSequence)key))){return;}
        int index=hash(key);
        while(!key.equals(keys[index])){
            index=(index+1)%capacity;
        }
        keys[index]=null;
        values[index]=null;
        index=(index+1)%capacity;
        while ((keys[index]!=null)){
            K keyToRedo=keys[index];
            V valueToRedo=values[index];
            keys[index]=null;
            values[index]=null;
            num--;
            put(keyToRedo,valueToRedo);
            index=(index+1)%capacity;
        }
        /*
        当搜索到对应的键之后，将对应的键值删除
        然后后面的开放寻址会发生改变
        然后将后面的键值对删除之后重新加入




        */

        num--;
        if(num>0&&num==capacity/8){
            resize(capacity/8);
        }
    }

//动态扩容
    public void resize(int newCapacity){
        LinearProbingHashMap<K,V> hashmap=new LinearProbingHashMap<>(newCapacity);
        for(int i=0;i<capacity;i++){
            if(keys[i]!=null){
                hashmap.put(keys[i],values[i]);
            }
        }
        keys=hashmap.keys;
        values=hashmap.values;
        capacity=hashmap.capacity;

    }

}
