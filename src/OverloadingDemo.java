
public class OverloadingDemo {
	void A() {
		System.out.println("void A()");
	}
	void A(int arg) {
		System.out.println("void A( int arg)");
	}
	void A(String arg) {
		System.out.println("void A(String arg)");
	}
	//int A() { System.out.println("int A()");  }

	public static void main(String[] args) {
		OverloadingDemo ov = new OverloadingDemo();
		ov.A();
		ov.A(1);
		ov.A("Hello Everybody !!!");
	}

}
