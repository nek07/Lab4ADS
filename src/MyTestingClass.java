public class MyTestingClass<T> {
    private T obj;
    public MyTestingClass(T obj){
        this.obj = obj;
    }
    public int HashCode(T obj){
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
    public int IntegerHashCode(Integer value){
        if(value == null){
            return 0;
        }
        int hash = 1;
        hash = 31*hash + (int)value; //31x + y
        return Math.abs(hash);
    }
}
