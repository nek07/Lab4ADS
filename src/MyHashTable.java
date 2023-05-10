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
    private HashNode<K,V> chainArray[];
    private int M = 11; //default number of chains
    private int size;

    public MyHashTable(){
        this.M = M;
        this.chainArray = (HashNode<K, V>[]) new Object[M];
        this.size = 0;
    }
    public MyHashTable(int chains){
        this.M = chains;
        this.chainArray = (HashNode<K, V>[]) new Object[chains];
        this.size = 0;
    }
    private int hash(int a[]){
        if(a == null){
            return 0;
        }
        int hash = 1;
        for(int i = 0; i< a.length;i++){
            hash = 31*hash + a[i]; //31x + y
        }
        return hash;
    }
    }

