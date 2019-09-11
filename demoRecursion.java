class demoWhile
{
	int factorial(int num)
	{
	int fact = 1;
		while (num > 0)
		{
			fact = fact * num;
			num = num - 1;
		}
	return fact;
	}
}
// using java recursion
class demoRecursion
{
	int factorial(int num)
	{
	int result;
	if(num == 1) return 1;
	result = factorial(num - 1)*num;
	return result;
	}
	
	public static void main(String[] args)
	{
		demoWhile obj = new demoWhile();
		System.out.println("\nFactorial of 5 using while loop --------- " + obj.factorial(5));
		
		demoRecursion obj1 = new demoRecursion();
		System.out.println("Factorial of 5 using recursion ---------- " + obj1.factorial(5) + "\n");
	}
}
