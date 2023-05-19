
import java.util.LinkedList;

public class MyHashTable<K,V> {

    private class HashNode<K, V> {
        private K key;
        private V value;

        private HashNode<K, V> next;
        /*
         Constructs a new HashNode with the given key and value.
         @param key - the key of the entry
         @param value the value of the entry
         */
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        /*
         Retrieves the key of the HashNode.
         @return the key of the entry
         */
        public K getKey() {
            return key;
        }
        /*
         Retrieves the value of the HashNode.
         @return the value of the entry
         */
        public V getValue() {
            return value;
        }
        /*
         Sets the value of the HashNode.
         @param value the new value of the entry
         */
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

    /*
       Constructor of MyHashTable class
       @no parameters
     */
    public MyHashTable() {
        this.M = M;
        chainArray = new LinkedList[M];
        this.size = 0;
    }
    /*
       Constructor of MyHashTable class
       @int M - sets the number of buckets in MyHashTable
     */
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new LinkedList[M];
        this.size = 0;

    }
    /*
      Calculates the hash code for the given key.
      @param key - the key for which to calculate the hash code
      @return the hash code of the key
     */
    public int hash(K key) {
        MyTestingClass mt = new MyTestingClass((key));
        return mt.HashCode(key) % M;
    }
    /*
     Adds a key-value pair in the hash table.
     @param key - the key of the entry
     @param value - the value of the entry
     */
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

    /*
     Retrieves the value associated with the given key.
     @param key the key to search for
     @return the value associated with the key, or null if the key is not found
     */
    public V get(K key) {
        int index = hash(key);
        for (HashNode<K, V> current : chainArray[index]) {
            if (current.key.equals(key)) {
                return current.value;
            }
        }
        return null;
    }
    /*
     Removes the entry with the specified key from the hash table.
     @param key the key to remove
     @return the value associated with the removed key, or null if the key is not found
     */
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
    /*
     Checks if the hash table contains an entry with the specified value.
     @param value the value to search for
     @return true if the value is found, false otherwise
     */
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


    /*
     Retrieves the key associated with the specified value.
     @param value the value to search for
     @return the key associated with the value, or null if the value is not found
     */
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
    /*
     Prints all the values in a specific chain of the hash table.
     @param chain the index of the chain to print
     */
    public void getAll(int chain) {
        for (HashNode<K, V> current : chainArray[chain]) {
            if(current.equals(null)){
                continue;
            }
            System.out.print(current.getValue() + " ");

        }
    }
    /*
     Returns the number of entries in the hash table.
     @return the size of the hash table
     */
    public int size() {
        return size;
    }

    /*
       Finds the value which pair with key and replace it by newValue
       @K key - key
       @V oldValue - current value
       @V newValue - new value
       @return boolean - if value will be replaced true, otherwise false
     */
    public boolean replace(K key, V oldValue, V newValue){
        int index = hash(key);
        for (HashNode<K, V> current : chainArray[index]) {
            if (current.getKey().equals(key) && current.getValue().equals(oldValue)) {
                current.value = newValue;
                return true; //key was founded and value replaced
            }
        }
        return false; //there is no such index

    }
}





