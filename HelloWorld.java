class HelloWorld {
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		System.out.println("the sum is " + HelloWorld.add(x,y));
	} 
	// add Method
	static int add(int x, int y) {
		return(x+y);
	}
}
