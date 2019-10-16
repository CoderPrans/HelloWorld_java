class teacher {
    int id;
    String name;
    String address;
    float sal;

    void setId(int id) {
        this.id = id; 
    }
    int getId() {
        return id; 
    }
    void setName(String name) {
        this.name = name; 
    }
    String getName() {
        return name; 
    }
    // teacher() {
    //     System.out.println("I'm the teacher");
    // }
    protected void printa(String source) {
        System.out.println("I was called, coming " + source); 
    }
}

class student extends teacher {
    int id;
    String name;
    String address;
    int marks;
    void setMarks(int marks) {
        this.marks = marks; 
    }
    int getMarks() {
        return marks; 
    }
    void setAddress(String address) {
        this.address = address; 
    }
    String getAddress() {
        return address; 
    }
    // student() {
    //     System.out.println("I'm the student");
    // }
    void printb() {
        System.out.println("I'm the child"); 
    }
}

class demoInheritance {
    public static void main(String[] args) {
        student obj = new student(); 
        teacher obj2 = new teacher();

        // -> won't work if printa() has private access [use PROTECTED access]
        obj.printa("from child");          
        obj2.printa("from parent"); 

        // obj.setId(102);
        // obj.setName("Vijay");
        // obj.setAddress("Alandi, Pune 412105");
        // obj.setMarks(250);

        // System.out.println("Id is " + obj.getId());
        // System.out.println("Name is " + obj.getName());
        // System.out.println("Address is " + obj.getAddress());
        // System.out.println("Marks is " + obj.getMarks());
    }
}
