public class Person
{
	String name;
	int age;
	String likes;

	void eat()
	{
		System.out.println("I like " + likes);
	}

	void talk()
	{
		System.out.println("my name is " + name);
		System.out.println("my age is " + age);
	}

	// Constructor
	public Person(String name, int age, String likes)
	{
		this.name = name;
		this.age = age;
		this.likes = likes;
	}

	public static void main(String[] args)
	{
		Person Raju = new Person("Raju", 30, "Mangoes");
		Raju.talk();
		Raju.eat();
		System.out.println("-----------------------");
		Person Ajay = new Person("Ajay", 22, "Grapes");
		Ajay.talk();
		Ajay.eat();
	}
}
