interface father {
    double height = 6.2;
    void genHeight();
}
interface mother {
    double height = 5.6;
    void genHeight();
}
class child implements father, mother {
    double height = (father.height + mother.height) / 2;
    public void genHeight() {
        System.out.println("Child's height is " + height);
    }
}

class demoInterface {
    public static void main(String[] args) {
        child obj = new child();
        obj.genHeight();
    }
}
