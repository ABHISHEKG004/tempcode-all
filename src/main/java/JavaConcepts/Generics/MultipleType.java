package JavaConcepts.Generics;

/**
 * Created by abhishek.gupt on 20/03/18.
 */

public class MultipleType<T, U>
{
    T obj1;  // An object of type T
    U obj2;  // An object of type U

    // constructor
    MultipleType(T obj1, U obj2)
    {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    // To print objects of T and U
    public void print()
    {
        System.out.println(obj1);
        System.out.println(obj2);
    }
}

// Driver class to others.test above
class Driver
{
    public static void main (String[] args)
    {
        MultipleType <String, Integer> obj =
                new MultipleType<String, Integer>("GfG", 15);

        obj.print();
    }
}