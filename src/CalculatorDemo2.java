
class Calculator3{
	int left, right;
	int mid   = 0;
	static double PI = 3.14;
	
	// class variable
	static int base = 0;
	
	public Calculator3() {};	
	public Calculator3( int left, int right)
	{
		this.left  = left;
		this.right = right;
	}
	
	public Calculator3( int left, int mid, int right)
	{
		this.left = left;
		this.mid  = mid;
		this.right = right;
	}
	
	public void setOperand(int left, int right)
	{
		this.left = left;
		this.right = right;
	}
	public void setOperand(int left, int mid, int right)
	{
		this.setOperand(left,right);
		this.mid   = mid;
	}
	public void sum()
	{
		System.out.println(this.left + this.right + this.mid + this.base);
	}
	public void avg()
	{
		System.out.println((this.left+this.right)/2);
	}
}
class SubstractionableCalculator extends Calculator3{
	public SubstractionableCalculator(int left, int right)
	{
		super(left, right);
	}
	// method overriding
	public void sum() {
		System.out.println("The execution result is " + ( left + right ) + " .");
	}
	public void substract() {
		System.out.println(this.left - this.right);
	}
}

class MultiplicationableCalculator extends Calculator3{
	public MultiplicationableCalculator(int left, int right)
	{
		super(left, right);
	}
	public void multiplication() {
		System.out.println(this.left * this.right);
	}
}

class DivisionableCalculator extends MultiplicationableCalculator{
	DivisionableCalculator(int left, int right){
		super(left,right);
	}
	public void division() {
		System.out.println(this.left / this.right);
	}
}
public class CalculatorDemo2 {

	public static void main(String[] args) {
		SubstractionableCalculator c1 = new SubstractionableCalculator(20,10);
		c1.setOperand(10, 20);
		c1.sum();
		c1.avg();
		c1.substract();
		
		MultiplicationableCalculator c2 = new MultiplicationableCalculator(10,20);
		c2.setOperand(10, 20);
		c2.multiplication();
		
		SubstractionableCalculator c3 = new SubstractionableCalculator(20,10);
		c3.setOperand(10, 20, 30);
		c3.sum();
		c3.avg();
		
		DivisionableCalculator d1 = new DivisionableCalculator(200,10);
		d1.setOperand(20, 10);
		d1.division();
	}
}
