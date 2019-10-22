import java.util.Scanner;
import java.io.*;

public class patients
{
    // variables
    String name;
    int age;
    String gen;

    // constructor function
    public patients(String name, int age, String gen)
    {
        this.name = name;
        this.age = age;
        this.gen = gen;
    }

    // main function
    public static void main(String[] args) throws IOException
    {
       Scanner sc = new Scanner(System.in);
       
       patients[] users = new patients[5];
       
       for(int i = 0; i < 5; i++){
           System.out.println("Name Age Gender");  
           String name = sc.next();
           int age = sc.nextInt();
           String gen = sc.next();
           users[i] = new patients(name, age, gen);
       }

       System.out.println("\n");
       System.out.println("Name\t| Age\t| Gender");
       System.out.println("\n");

       for(int i = 0; i < 5; i++){
        System.out.println(users[i].name + "\t| " + users[i].age + "\t| " + users[i].gen);     
	    System.out.println("---------------------");
       } 
      
       // Printing into a csv file, appending if already exists. 
       PrintWriter out = new PrintWriter(new FileWriter("Patients_data.csv", true));
       //out.println("Name,Age,Gender");

       for (int i = 0; i < 5; i++) {
           out.println(users[i].name + "," + users[i].age+ "," + users[i].gen);
       }
       out.close();
       System.out.println("Saved in Patients_data.csv file.");
    }
}
