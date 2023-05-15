import java.sql.SQLOutput;
import java.util.Random;

public class Main {
    static MyHashTable<Integer, String> mht1 = new MyHashTable<>();
    static MyHashTable<String, Integer> mht2 = new MyHashTable<>();
    public static void printStr(){
        for(int i = 0;i<11;i++){
            mht2.getAll(i);
            System.out.println("\n");
        }
    }
    public static void printInt(){
        for(int i = 0;i<11;i++){
            mht1.getAll(i);
            System.out.println("\n");
        }
    }
    public static void main(String[] args) {
        Random rand = new Random();

        for(int i = 0;i<10000;i++){ //integer
            mht1.put(rand.nextInt(10000),"Student"+ rand.nextInt(1000));
        }
        mht2.put("Joe",12);
        mht2.put("Kira",13);
        mht2.put("Michael",90);
        mht2.put("Askhat",17);
        mht2.put("Kimine",4);
        mht2.put("Kanat",8);
        mht2.put("Karasai",18);
        mht2.put("Kairat",54);
        mht2.put("Damir",47);
        mht2.put("Joe",100);
        System.out.println("\n STRING TYPE HASHTABLE ");
        System.out.println("Size of string hashtable - " + mht2.size());
        System.out.println("\nHashTable contains Joe's value - "+ mht2.contains(100));
        System.out.println("HashTable contains Mia's value - "+ mht2.contains(1));
        System.out.println("\nKey of the value 54 - " +mht2.getKey(54));
        System.out.println("Key of the value 2 - " + mht2.getKey(1000));
        System.out.println("\nRemoved value - " + mht2.remove("Damir"));
        System.out.println("Place of value which was removed - " + mht2.get("Damir"));
        System.out.println("\nJoe's value before - "+ mht2.get("Joe"));
        mht2.put("Joe",100);
        System.out.println("\nJoe's value after - "+ mht2.get("Joe"));

        System.out.println("\nINTEGER TYPE HASHTABLE" + "\nrepresentation of buckets\n");

        printInt();





    }
}