class sample
{
    void add(int a, int b, int c)
    {
        System.out.println("Sum is " + (a + b + c)); 
    }
    void add(int a, int b)
    {
        System.out.println("Sum is " + (a + b)); 
    }
}
class demoPolyMorphism
{
    public static void main(String[] args)
    {
        sample s = new sample(); 
        s.add(5, 10);
        s.add(5, 10, 15);
    }
}
