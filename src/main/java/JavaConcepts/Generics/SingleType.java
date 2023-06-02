package JavaConcepts.Generics;

/**
 * Created by abhishek.gupt on 20/03/18.
 */
public class SingleType<T>
{
    // An object of type T is declared
    T obj;
    SingleType(T obj) {  this.obj = obj;  }  // constructor
    public T getObject()  { return this.obj; }
}

// Driver class to others.test above
class Maino
{
    public static void main (String[] args)
    {
        // instance of Integer type
        SingleType <Integer> iObj = new SingleType<Integer>(15);
        System.out.println(iObj.getObject());

        // instance of String type
        SingleType <String> sObj =
                new SingleType<String>("GeeksForGeeks");
        System.out.println(sObj.getObject());
    }
}