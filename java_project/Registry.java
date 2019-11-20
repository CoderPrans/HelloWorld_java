import java.io.*;
import javax.swing.*;

class Patient
{
    // variables
    protected String name;
    protected int age;
    protected String gen;
    protected float bmi;
    protected float sugarL;
    protected String address;
    protected long contact;

    // constructor function
    public Patient(
            String name, 
            int age, 
            String gen, 
            float bmi, 
            float sugarL,
            String address, 
            long contact)
    {
        this.name = name;
        this.age = age;
        this.gen = gen;
        this.bmi = bmi; 
        this.sugarL = sugarL;
        this.address = address;
        this.contact = contact;
    }
}

class Registry
{
  // main function
  public static void main(String[] args) throws IOException
  {
     JOptionPane.showMessageDialog(null,"Welcome to Patient detail management system. :-) ",
          "Patient's Info",JOptionPane.INFORMATION_MESSAGE);
     
     int times = Integer.parseInt(JOptionPane
             .showInputDialog(null, "Enter the number of Patients: ",
                 "Patients", JOptionPane.QUESTION_MESSAGE));
     
      Patient[] users = interact(times);

      result(users, times);
   }

  // interact and collect data
  static Patient[] interact(int times) {

     Patient[] users = new Patient[times];

     outerloop:
     for(int i = 0; i < times; i++){
       // handle exceptions
      try {
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

         // ask for sugar level
        float sugarL = Float.parseFloat(JOptionPane
                 .showInputDialog(null, "Enter Sugar Level: ",
                     "Sugar Level", JOptionPane.QUESTION_MESSAGE));

         // ask for contact
        long contact = Long.parseLong(JOptionPane
                 .showInputDialog(null, "Enter Contact Info: ",
                     "Contact", JOptionPane.QUESTION_MESSAGE));

         // ask for address
        String address = JOptionPane
             .showInputDialog(null, "Enter Address: ",
                     "Address", JOptionPane.QUESTION_MESSAGE) ;

         // fill in the users array
        users[i] = new Patient(name, age, gens[gen_index], bmi, sugarL, address, contact);
        }

      catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, 
                "Please don't enter invalid charecters.",
                "alert", JOptionPane.ERROR_MESSAGE);

        break outerloop;
     }
   }
     return users; 
  }

  // results and outputs
  static void result(Patient[] users, int times) throws IOException {

      StringBuilder salt = new StringBuilder();
      for(int i = 0; i < times; i++) {
          salt.append("================================");
          salt.append("\n"+users[i].name+"\n");
          salt.append("--------------------------------");
          salt.append("\n"
                  +"Age: " +users[i].age+"\n"
                  +"Gender: " +users[i].gen+"\n"
                  +"BMI: " +users[i].bmi+"\n"
                  +"Sugar Level: " +users[i].sugarL+"\n"
                  +"Address: " +users[i].address+"\n"
                  +"Contact: " +users[i].contact+"\n");
          salt.append("================================");
      }

      System.out.println(salt);
     
      JOptionPane.showMessageDialog(null,salt.toString(),
          "Patient's Info",JOptionPane.INFORMATION_MESSAGE);

     print(users, times);
     System.out.println("Updated the Patients_data.csv file.");
  
  }

  // check if file exists or create one
  static void print(Patient[] users, int times) throws IOException
  {
     String fileName = "Patients_data.csv";
     File f = new File(fileName);
     if(f.exists() && !f.isDirectory()) {
        write(users, times, fileName);
     } else {
        PrintWriter out = new PrintWriter(new FileWriter(fileName));
        out.println("Name,Age,Gender,Bmi,Address,SugarLevel,Contact");
        out.close();
        write(users, times, fileName);
     }
  
  }

  // write into file
  static void write(Patient[] users, int times, String fileName) throws IOException
   {
     PrintWriter out = new PrintWriter(new FileWriter(fileName, true));
     for (int i = 0; i < times; i++) {
         out.println(users[i].name + "," 
                 + users[i].age+ "," 
                 + users[i].gen+ "," 
                 + users[i].bmi + ","
                 + users[i].sugarL + ","
                 + users[i].address + "," 
                 + users[i].contact);
     }
     out.close();
  }
}
