import java.util.Scanner;
import java.io.*;
// class declaration
public class BankUsers
{
    public static void main(String[] args) throws IOException
    {
       Scanner sc = new Scanner(System.in);
       
       // array variable
       BankUsers[] users = new BankUsers[5];
       
       for(int i = 0; i < 5; i++){
           System.out.println("Enter Name: ");  
           String name = sc.next();
           System.out.println("Enter Account Number: ");
           long acc = sc.nextLong();
           System.out.println("Enter Balance: ");
           float bal = sc.nextFloat();
           users[i] = new BankUsers(name, acc, bal);
       }
       System.out.println("Name\tAcc\t\tBal");
       System.out.println("---------------------------------------");
       for(int i = 0; i < 5; i++){
        System.out.println(users[i].name + "\t" + users[i].acc + "\t" + users[i].bal);     
	    System.out.println("---------------------------------------");
       } 
         PrintWriter out = new PrintWriter(new FileWriter("OutFile.csv"));

         for (int i = 0; i < 5; i++) {
             // The get(int) method throws IndexOutOfBoundsException, which must be caught.
             out.println(users[i].name + "," + users[i].acc+ "," + users[i].bal);
         }
         out.close();
    }
    // initialize variables
    String name;
    long acc;
    float bal;

    // constructor declaration of class
    public BankUsers(String name, long acc, float bal)
    {
        this.name = name;
        this.acc = acc;
        this.bal = bal; 
    }
}
