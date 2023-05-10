import javax.management.ObjectName;
import java.util.LinkedList;

public class MyHashTable<K,V> {
    private class HashNode<K,V>{
        private K key;
        private V value;

        private HashNode<K,V> next;
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        public String toString(){
            return " " + key + " " + value + " ";
        }
    }
    private HashNode<K,V>[] chainArray;
    private int M = 11; //default number of chains
    private int size;


    public MyHashTable(){
        this.M = M;
        chainArray = new HashNode[M];
        this.size = 0;
    }
    public MyHashTable(int chains){
        this.M = chains;
        chainArray = new HashNode[M];
        this.size = 0;

    }
    private int hash(K key){
        if(key == null){
            return 0;
        }
        int hash = 1;
        hash = 31*hash + (int)key; //31x + y
        return hash;
    }
    public void put(K key, V value){
        size++;
        int place = getIndex(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if(chainArray[place]==null){
            chainArray[place] = newNode;
        }
        else{
        HashNode<K, V> current = chainArray[place];
        while(current.next != null){// equals от OBJECT  поменяй
            if(current.key.equals(key)){
                current.value=value;
                return;
            }
            current=current.next;
        }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newNode;
            }
        size++;
        }
    }
    private int getIndex(K key){
        return hash(key)%M;
    }
    public V get(K key){
        int index = getIndex(key);
        HashNode<K,V> current = chainArray[index];
        while(current!=null){
            if(current.key.equals(key)){
                return current.value;
            }
            current=current.next;
        }
        return (V)"null";
    }




    }

