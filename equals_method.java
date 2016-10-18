// Overriding equals method of object class in Integer class
import java.util.*;

final class Integer extends Object{
    private int x;
    public Integer(int x){
        this.x = x;
    }
    public boolean equals(Object o){
        if((o instanceof Integer) && ((Integer)o).x == this.x)
            return true;
        return false;   
    }
}

class equals_method
{
    public static void main(String args[]){
        Integer i1 = new Integer(5);
        Integer i2 = new Integer(5);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
    }
}
