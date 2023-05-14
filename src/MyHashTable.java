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
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
        public String toString(){
            return " " + key + " " + value + " ";
        }
    }
    private LinkedList<HashNode<K, V>>[] chainArray;
    private int M = 11; //default number of chains
    private int size;


    public MyHashTable(){
        this.M = M;
        chainArray = new LinkedList[M];
        this.size = 0;
    }
    public MyHashTable(int chains){
        this.M = chains;
        chainArray = new LinkedList[M];
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
        int index = hash(key);
        if (chainArray[index] == null){
            chainArray[index] = new LinkedList<>();
        }
        for (HashNode<K, V> current: chainArray[index]){
            if(current.key.equals(key)){
                current.value = value;
                return;
            }
        }
        chainArray[index].add(new HashNode<K, V>(key, value));

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
        return null;
    }
    public V remove(K key){
        int index = getIndex(key);
        V element = null;
        if(chainArray[index].getKey()==key){
            element = chainArray[index].getValue();
            chainArray[index]=chainArray[index].next;
        }
        else {
            while (chainArray[index].next.getKey()!=key) {
                chainArray[index] = chainArray[index].next;
            }
            element = (V) chainArray[index].next.getValue();
            chainArray[index].next = chainArray[index].next.next;
        }
        size--;
        return element;
    }
    public boolean contains(V value){
        for(int i = 0;i < M;i++){
            while(chainArray[i]!=null){
                if(chainArray[i].getValue().equals(value)){
                    return true;
                }
                chainArray[i] = chainArray[i].next;
            }
        }
        return false;
    }
    public K getKey(V value){
        for(int i = 0;i < M;i++){
            while(chainArray[i]!=null){
                if(chainArray[i].getValue().equals(value)){
                    return chainArray[i].getKey();
                }
                chainArray[i] = chainArray[i].next;
            }
        }
        return null;
    }
    public void getAll(){
        for(int i = 0;i < M;i++){
            while(chainArray[i]!=null){
                System.out.print(chainArray[i].getValue()+" ");
                chainArray[i] = chainArray[i].next;
            }
            System.out.println("\n\n");
        }
    }




    }

