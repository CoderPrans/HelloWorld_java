import java.util.Scanner; 
// Class Declaration 
  
public class Dog 
{ 
  
    public static void main(String[] args) 
    { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name: ");
        String name = sc.next();
        System.out.println("Enter Breed : ");
        String breed = sc.next();
        System.out.println("Enter Age: ");
        int age = sc.nextInt();
        System.out.println("Enter Color : ");
        String color = sc.next();
        Dog tuffy = new Dog(name, breed, age, color); 
        System.out.println(tuffy.toString()); 
    } 

    // Instance Variables 
    String name; 
    String breed; 
    int age; 
    String color; 
  
    // Constructor Declaration of Class 
    public Dog(String name, String breed, 
                   int age, String color) 
    { 
        this.name = name; 
        this.breed = breed; 
        this.age = age; 
        this.color = color; 
    } 
  
    // method 1 
    public String getName() 
    { 
        return name; 
    } 
  
    // method 2 
    public String getBreed() 
    { 
        return breed; 
    } 
  
    // method 3 
    public int getAge() 
    { 
        return age; 
    } 
  
    // method 4 
    public String getColor() 
    { 
        return color; 
    } 
  
    //@Override
    public String toString() 
    { 
        return("Hi my name is "+ this.getName()+ 
               ".\nMy breed,age and color are " + 
               this.getBreed()+", " + this.getAge()+ 
               " and "+ this.getColor()); 
    }
} 
