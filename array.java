import java.util.Scanner;

public  class  array {
    public  static  void  main(String[]  args) {
        Scanner  SC  =  new  Scanner(System.in);
        int[]  marks  =new  int[5]; String[]  name  =  new  String[5]; int  avg  =  0;
        System.out.println("enter  the  mark  of  5  student");
        for(int  i=0;  i<5;  i++){
        marks[i]  =  SC.nextInt();
        avg  =  avg  +  marks[i];
      }
    avg  =avg/5;
    System.out.println("Average  of  the  marks  is  "  +avg);
  }
} 
