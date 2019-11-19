import java.util.Scanner;
import java.io.*;
import javax.swing.*;

public class patients
{
    // variables
    
    String name;
    int age;
    String gen;
    float bmi;
    String address;
    long contact;

    // constructor function
    
    public patients(
            String name, 
            int age, 
            String gen, 
            float bmi, 
            String address, 
            long contact)
    {
        this.name = name;
        this.age = age;
        this.gen = gen;
        this.bmi = bmi; 
        this.address = address;
        this.contact = contact;
    }
    
    // main function
    
    public static void main(String[] args) throws IOException
    {
       JOptionPane.showMessageDialog(null,"Welcome to patient detail management system. :-) ",
            "Patient's Info",JOptionPane.INFORMATION_MESSAGE);
       
       int times = Integer.parseInt(JOptionPane
               .showInputDialog(null, "Enter the number of patients: ",
                   "patients", JOptionPane.QUESTION_MESSAGE));
       
       patients[] users = new patients[times];

       for(int i = 0; i < times; i++){
           // ask for name
           String name = JOptionPane
               .showInputDialog(null, "Enter Name: ",
                       "Name", JOptionPane.QUESTION_MESSAGE) ;

           // ask for age
           int age = Integer.parseInt(JOptionPane
                   .showInputDialog(null, "Enter Age: ",
                       "Age", JOptionPane.QUESTION_MESSAGE));

           // ask for gender
           String[] gens= {"Male", "Female", "Others"};
		   int gen_index=JOptionPane.showOptionDialog(null,"Choose Gender: ",
				"Gender",0,JOptionPane.QUESTION_MESSAGE,null,gens,0);

           // ask for bmi
           float bmi = Float.parseFloat(JOptionPane
                   .showInputDialog(null, "Enter BMI: ",
                       "BMI", JOptionPane.QUESTION_MESSAGE));

           // ask for contact
           long contact = Long.parseLong(JOptionPane
                   .showInputDialog(null, "Enter Contact Info: ",
                       "Contact", JOptionPane.QUESTION_MESSAGE));

           // ask for address
           String address = JOptionPane
               .showInputDialog(null, "Enter Address: ",
                       "Address", JOptionPane.QUESTION_MESSAGE) ;

           // fill in the users array
           users[i] = new patients(
                   name, 
                   age, 
                   gens[gen_index], 
                   bmi,
                   address,
                   contact);
       }

       // System.out.println("\n");
       // System.out.println("Name\t| Age\t| Gender");
       // System.out.println("\n");

       // for(int i = 0; i < times; i++){
       //  System.out.println(users[i].name + "\t| " + users[i].age + "\t| " + users[i].gen);     
	    // System.out.println("---------------------");
       // } 
     
        StringBuilder salt = new StringBuilder();
        for(int i = 0; i < times; i++) {
            salt.append("\n"+users[i].name+"\n");
            salt.append("----------------------");
            salt.append("\n"
                    +"Age: " +users[i].age+"\n"
                    +"Gender: " +users[i].gen+"\n"
                    +"BMI: " +users[i].bmi+"\n"
                    +"Address: " +users[i].address+"\n"
                    +"Contact: " +users[i].contact+"\n");
            salt.append("======================");
        }

        System.out.println(salt);

       JOptionPane.showMessageDialog(null,salt,
            "Patient's Info",JOptionPane.INFORMATION_MESSAGE);

       //Printing into a csv file, appending if already exists. 

       String fileName = "Patients_data.csv";
       File f = new File(fileName);
       if(f.exists() && !f.isDirectory()) {
       PrintWriter out = new PrintWriter(new FileWriter(fileName, true));
           for (int i = 0; i < times; i++) {
               out.println(users[i].name + "," 
                       + users[i].age+ "," 
                       + users[i].gen+ "," 
                       + users[i].bmi + ","
                       + users[i].address + "," 
                       + users[i].contact);
           }
           out.close();
       } else {
       PrintWriter out = new PrintWriter(new FileWriter(fileName));
           out.println("Name,Age,Gender,Bmi,Address,Contact");
           for (int i = 0; i < times; i++) {
               out.println(users[i].name + "," 
                       + users[i].age+ "," 
                       + users[i].gen+ "," 
                       + users[i].bmi + ","
                       + users[i].address + "," 
                       + users[i].contact);
           }
           out.close();
       }
       System.out.println("\nUpdated the Patients_data.csv file.");
     }
}
