import java.util.Scanner;
import java.io.*;
// class declaration
public class patients
{
    public static void main(String[] args) throws IOException
    {
       Scanner sc = new Scanner(System.in);
       
       // array variable
       patients[] users = new patients[5];
       
       for(int i = 0; i < 5; i++){
           System.out.println("Enter Name: ");  
           String name = sc.next();
           System.out.println("Enter Age: ");
           int age = sc.nextInt();
           System.out.println("Enter Gender: ");
           String gen = sc.next();
           users[i] = new patients(name, age, gen);
       }
       System.out.println("Name\tAcc\t\tBal");
       System.out.println("---------------------------------------");
       for(int i = 0; i < 5; i++){
        System.out.println(users[i].name + "\t" + users[i].age + "\t" + users[i].gen);     
	    System.out.println("---------------------------------------");
       } 
         PrintWriter out = new PrintWriter(new FileWriter("OutFile.csv"));
         out.println("Name,Age,Gender");
         for (int i = 0; i < 5; i++) {
             // The get(int) method throws IndexOutOfBoundsException, which must be caught.
             out.println(users[i].name + "," + users[i].age+ "," + users[i].gen);
         }
         out.close();
    }
    // initialize variables
    String name;
    int age;
    String gen;

    // constructor declaration of class
    public patients(String name, int age, String gen)
    {
        this.name = name;
        this.age = age;
        this.gen = gen;
    }
}
