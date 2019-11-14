import java.util.Scanner;
class exceptions {
    public static void main(String[] args) {
        int a,b;
        double c;
        a = 5;
        System.out.println("Enter the value of b = ");
        Scanner sc = new Scanner(System.in);
        b = sc.nextInt();
        try {
            c = a/b;
            System.out.println("This code will not execute");
        }
        catch(ArithmeticException e) {
            System.out.println("Please don't take b as 0");
        }
        System.out.println("MITAOE");
    }
}


