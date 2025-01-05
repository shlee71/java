class Calculator{
	int left, right;
	static double PI = 3.14;
	
	public Calculator() {
		System.out.println("Calculator() is called !!");
	}
	
	public Calculator(int left, int right)
	{
		this.left = left;
		this.right = right;
		System.out.println("Calculator(int, int) is called !!");
	}
	
	// class variable
	static int base = 0;
	
	public void setOperand(int left, int right)
	{
		this.left = left;
		this.right = right;
	}
	public void sum()
	{
		System.out.println(this.left + this.right + this.base);
	}
	public void avg()
	{
		System.out.println((this.left+this.right)/2);
	}
}
class Calculator1{

	// class method
	public static void sum(int left, int right)
	{
		System.out.println(left + right);
	}
	public static void avg(int left, int right)
	{
		System.out.println((left+right)/2);
	}
}
class Calculator2 {
	static int static_variable = 1;
	int instance_variable = 2;
	
	static void static_static (){
		System.out.println(static_variable);
	}
	
	// static method cannot access instance variable
	static void static_instance (){
	//	System.out.println(instance_variable);
	}
	
	void instance_static (){
		System.out.println(static_variable);
	}
	
	void instance_instance (){
		System.out.println(instance_variable);
	}
}
public class CalculatorDemo1 {

	public static void main(String[] args) {

		Calculator c1 = new Calculator();
		
		c1.setOperand(10,20);
		c1.avg();
		c1.sum();		
		Calculator c2 = new Calculator();
		c2.setOperand(10,20);
		c2.avg();
		c2.sum();

		System.out.println("=============");
		c2.base = 10;
		c2.sum();
		System.out.println("=============");
		
		Calculator c3 = new Calculator();
		System.out.println(c3.PI);
		System.out.println(Calculator.PI);
		
		Calculator1.sum(100,200);
		Calculator1.avg(100,200);		
		
		System.out.println("=============");
		Calculator c4 = new Calculator(10,20);
		
	}
}
