abstract class parent {
    abstract void cal(double x);
}

class child1 extends parent {
    void cal(double x) {
     // Square
    System.out.println("Square - "+ x*x);
    }
}
class child2 extends parent{
    void cal(double x) {
     // Root
    System.out.println("Root - "+ Math.sqrt(x));
    }
}
class child3 extends parent{
    void cal(double x) {
     // Square
    System.out.println("Cube - "+ x*x*x);
    }
}

class demoAbstract {
    public static void main(String[] args) {
        child1 obj1 = new child1(); 
        child2 obj2 = new child2(); 
        child3 obj3 = new child3(); 
        obj1.cal(3);
        obj2.cal(4);
        obj3.cal(5);
    }
}
