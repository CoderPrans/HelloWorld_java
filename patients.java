import java.util.Scanner;
import java.io.*;
import javax.swing.*;

public class patients
{
    // variables
    String name;
    int age;
    String gen;
    // float bmi;
    String address;
    // long contact;

    // constructor function
    public patients(String name, int age, String gen, String address)
    {
        this.name = name;
        this.age = age;
        this.gen = gen;
        // this.bmi = bmi; 
        this.address = address;
        // this.contact = contact;
    }
    
    // main function
    public static void main(String[] args) throws IOException
    {
       Scanner sc = new Scanner(System.in);
       
       patients[] users = new patients[5];

       JOptionPane.showMessageDialog(null,"Pateints Info",
            "Patient's Info",JOptionPane.INFORMATION_MESSAGE);
       
       for(int i = 0; i < 5; i++){
           String name = JOptionPane.showInputDialog(null, "Enter the name: ", "Name", JOptionPane.QUESTION_MESSAGE) ;
           int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the age: ", "Age", JOptionPane.QUESTION_MESSAGE));
           String[] gens= {"Male", "Female", "Others"};
           // long contact = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the age: ", "Age", JOptionPane.QUESTION_MESSAGE));
		   int gen_index=JOptionPane.showOptionDialog(null,"Choose your gender: ",
				"Gender",0,JOptionPane.QUESTION_MESSAGE,null,gens,0);
           String address = JOptionPane.showInputDialog(null, "Enter the address: ", "Address", JOptionPane.QUESTION_MESSAGE) ;
           users[i] = new patients(name, age, gens[gen_index], address);
       }

       System.out.println("\n");
       System.out.println("Name\t| Age\t| Gender");
       System.out.println("\n");

       for(int i = 0; i < 5; i++){
        System.out.println(users[i].name + "\t| " + users[i].age + "\t| " + users[i].gen);     
	    System.out.println("---------------------");
       } 
      
       // Printing into a csv file, appending if already exists. 
       String fileName = "Patients_data.csv";
       File f = new File(fileName);
       if(f.exists() && !f.isDirectory()) {
       PrintWriter out = new PrintWriter(new FileWriter(fileName, true));
           for (int i = 0; i < 5; i++) {
               out.println(users[i].name + "," + users[i].age+ "," + users[i].gen);
           }
           out.close();
       } else {
       PrintWriter out = new PrintWriter(new FileWriter(fileName));
           out.println("Name,Age,Gender");
           for (int i = 0; i < 5; i++) {
               out.println(users[i].name + "," + users[i].age+ "," + users[i].gen);
           }
           out.close();
       }
       System.out.println("Updated the Patients_data.csv file.");
    }
}
