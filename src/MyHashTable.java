
import java.util.LinkedList;

public class MyHashTable<K,V> {

    private class HashNode<K, V> {
        private K key;
        private V value;

        private HashNode<K, V> next;

        public HashNode(K key, V value) {
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

        public String toString() {
            return " " + key + " " + value + " ";
        }
    }

    private LinkedList<HashNode<K, V>>[] chainArray;
    private int M = 11; //default number of chains
    private int size;


    public MyHashTable() {
        this.M = M;
        chainArray = new LinkedList[M];
        this.size = 0;
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new LinkedList[M];
        this.size = 0;

    }

    public int hash(K key) {
        MyTestingClass mt = new MyTestingClass((key));
        return mt.HashCode(key) % M;
    }

    public void put(K key, V value) {
        size++;
        int index = hash(key);
        if (chainArray[index] == null) {
            chainArray[index] = new LinkedList<>();
        }

        for (HashNode<K, V> current : chainArray[index]) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
        }
        chainArray[index].add(new HashNode<K, V>(key, value));

    }


    public V get(K key) {
        int index = hash(key);
        for (HashNode<K, V> current : chainArray[index]) {
            if (current.key.equals(key)) {
                return current.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        if (chainArray[index] == null) {
            return null;
        } else {
            for (HashNode<K, V> current : chainArray[index]) {
                if (current.getKey().equals(key)) {
                    chainArray[index].remove(current);
                    size--;
                    return current.getValue();
                }
            }
            return null;
        }
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            if (chainArray[i] != null) {
                for (HashNode<K, V> current : chainArray[i]) {
                    if (current.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }



    public K getKey(V value) {

        for (int i = 0; i < M; i++) {
            if(chainArray[i]!=null){
            for (HashNode<K, V> current : chainArray[i]) {
                if (current.getValue().equals(value)) {
                    return current.getKey();
                }
            }}
        }
        return null; //readme
    }

    public void getAll(int chain) {
        for (HashNode<K, V> current : chainArray[chain]) {
            if(current.equals(null)){
                continue;
            }
            System.out.print(current.getValue() + " ");

        }
    }

    public int size() {
        return size;
    }
}





