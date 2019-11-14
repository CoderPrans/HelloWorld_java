package pack;
public class add {
    double d1, d2;
    public add(double a, double b) {
        d1 = a;
        d2 = b;
    }
    public void sum(){
        System.out.println("The sum is " + (d1 + d2));
    }
}

/*
 * `javac -d . add.java`
 * // will create a pack dir in (.) current dir
 * // with add.class inside it
 */
