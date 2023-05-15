public class MyTestingClass<T> {
    private T obj;
    /*
      Constructor of the class
      @obj - generic type any element
     */
    public MyTestingClass(T obj){
        this.obj = obj;
    }
    /*
      @HashCode() Calculates the hash code for the given object.
      @param obj the object for which to calculate the hash code
      @return the hash code of the object
     */
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
    /*
      Calculates the hash code for a string value.
      @param value the string value for which to calculate the hash code
      @return the hash code of the string value
     */
    public static int StringHashCode(String value){
        if(value == null){
            return 0;
        }
        int hash = 0;
        int p = 31;
        for (int i = 0; i < value.length(); i++) {
            hash = hash * p + value.charAt(i); //x = x * pivot + asciiCode of elem
        }

        return Math.abs(hash);
    }
    /*
      Calculates the hash code for an integer value.
      @param value the integer value for which to calculate the hash code
      @return the hash code of the integer value
     */
    public int IntegerHashCode(Integer value){
        if(value == null){
            return 0;
        }
        int hash = 1;
        hash = 31*hash + (int)value; //31x + y
        return Math.abs(hash);
    }
}
