class GetSet
{
	private String name;
	private int age;

	public void setname(String name)
	{
		this.name = name;
	}
	public void setage(int age)
	{
		this.age = age;
	}
	public int getage()
	{	
		return age;
	}
	public String getname()
	{	
		return name;
	}
/*
	public static void main(String[] args)
	{
		GetSet p1 = new GetSet();
		p1.setname("Raju");
		p1.setage(30);
		String name = p1.getname();
		int age = p1.getage(); 
		System.out.println("name " + name);
		System.out.println("age " + age);
	}
*/
}

class demoGetterSetter
{
	public static void main(String[] args)
	{
		GetSet p1 = new GetSet();
		p1.setname("Raju");
		p1.setage(30);
		System.out.println("name " + p1.getname());
		System.out.println("age " + p1.getage());
	}
}
