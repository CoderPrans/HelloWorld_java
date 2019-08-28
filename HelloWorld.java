import java.util.Scanner; 

class HelloWorld {
	public static void main(String[] args) {
		/* int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		System.out.println("the sum is " + HelloWorld.add(x,y));
		*/

		Scanner sc = new Scanner(System.in);		

		String[] name = new String[5];
		int[] acc = new int[5];
		float[] bal = new float[5];

		for(int i = 0; i <= 5; i++) {
			System.out.println("Enter Username: ");
			name[i] = sc.nextLine();
			System.out.println("Enter Account Number: ");	
			acc[i] = sc.nextInt();
			System.out.println("Enter Account Balance : ");	
			bal[i] = sc.nextFloat();
			
			System.out.println("\nName: " + name[i] + "\tAccount: " + acc[i] + "\tBalance: " + bal[i] + "\n");
		}
	} 


	//static void takeInput() {}

// add Method
	/*static int add(int x, int y) {
		return(x+y);
	}*/
}
