
public class CalculatorDemo {
	public static void sum( int left , int right) {
		System.out.println(left+right);
	}
	public static void avg( int left , int right) {
		System.out.println((left+right)/2);
	}
	public static void main(String[] args) {
		// 1. normal 
		System.out.println(10+20);
		System.out.println(30+40);
		// 2. method use
		int left = 10, right =20;
		sum(left,right);
		avg(left, right);
	}

}
