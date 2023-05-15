# MyArrayListStack
### ➕ MyHashTable()
**Description**: Constructs a hash table with the default number of chains (11).
```java
public MyHashTable(){
        this.M = M;
        chainArray = new LinkedList[M];
        this.size = 0;
    }
```
### ➕ MyHashTable(int M)
**Description**: Constructs a hash table with a specified number of chains.
```java
public MyHashTable(int chains){
        this.M = M;
        chainArray = new LinkedList[M];
        this.size = 0;

    }
```
### ➕ hash()
**Description**: Calculates the hash code for the given key and find a place for pair.
```java
 public int hash(K key) {
        MyTestingClass mt = new MyTestingClass((key));
        return mt.HashCode(key) % M;
        }
```
### ➕ size()
**Description**: Return the size of the hashtable.
```java
public int size(){
        return size;
    }
```
### ➕ put(K key, V value)
**Description**: Inserts a key-value pair into the hash table. If the key already exists, the value is updated.
```java
public void put(K key, V value){
        size++;
        int index = getIndex(key);
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
```
### ➕ get(K key)
**Description**: Retrieves the value associated with the specified key from the hash table
```java
public V get(K key){
        int index=getIndex(key);
        for(HashNode<K, V> current:chainArray[index]){
            if(current.key.equals(key)){
                return current.value;
        }}
        return null;
}
```
### ➕ remove(K key)
**Description**: Removes the key-value pair associated with the specified key from the hash table and returns its value.
```java
public V remove(K key){
        int index = getIndex(key);
        if(chainArray[index] == null){
            return null;
        }
        else{
            for (HashNode<K, V> current: chainArray[index]){
                if(current.getKey().equals(key)) {
                    chainArray[index].remove(current);
                    size--;
                    return current.getValue();
                }
        }
            return null;
    }}
```
### ➕ contains(V value)
**Description**: Checks if the hash table contains the specified value.
```java
public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            if (chainArray[i] != null) {
                for (HashNode<K, V> current : chainArray[i]) {
                    if (current.getValue().equals(value)){
                        return true;
        }}}}
        return false;
        }
```
### ➕ getKey(V value)
**Description**: Retrieves the key associated with the specified value from the hash table.
```java
public K getKey(V value) {

        for (int i = 0; i < M; i++) {
            if(chainArray[i]!=null){
                for (HashNode<K, V> current : chainArray[i]) {
                    if (current.getValue().equals(value)) {
                        return current.getKey();
            }
                }       }
        }
        return null; 
}
```
### ➕ getAll()
**Description**:  Prints all the values stored in the hash table.
```java
public void getAll(){
        for(int i = 0;i < M;i++){
            for(HashNode<K, V> current: chainArray[i]){
                System.out.print(current.getValue()+" ");
            }
            System.out.println("\n\n");
        }
    }
```
#HashNode
### ➕ HashNode(K key, V value)
**Description**: Constructor of the class.
```java
public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
```
### ➕ getKey(()
**Description**:  Returns the key of the node.
```java
public K getKey() {
            return key;
        }
```
### ➕ getValue()
**Description**:  Returns the value of the node.
```java
public V getValue() {
            return value;
        }
```
### ➕ setValue()
**Description**: Sets the value of the node.
```java
public void setValue(V value) {
            this.value = value;
        }
```
#MyTestingClass
### ➕ MyTestingClass(T obj)
**Description**: Constructor of the class
```java
public MyTestingClass(T obj){
        this.obj = obj;
        }
```
### ➕
**Description**:
```java
ublic int HashCode(T obj){
        if (obj == null) {
            return 0;
        }
        int hashCode = 1;
        if (obj instanceof String) {
            hashCode = StringHashCode((String) obj);
        } else if (obj instanceof Integer) {
            hashCode = IntegerHashCode((Integer) obj);
        }
        return hashCode;}
```
### ➕
**Description**:
```java
public static int StringHashCode(String value){
        if(value == null){
            return 0;
        }
        int hash = 0;
        int p = 31;

        for (int i = 0; i < value.length(); i++) {
            hash = hash * p + value.charAt(i);
        }

        return Math.abs(hash);
    }
```
### ➕
**Description**:
```java
public int IntegerHashCode(Integer value){
        if(value == null){
            return 0;
        }
        int hash = 1;
        hash = 31*hash + (int)value; //31x + y
        return Math.abs(hash);
    }
```