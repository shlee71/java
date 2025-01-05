
public class WhileDemo {

	public static void main(String[] args) {
		int i = 0;
		while( i < 10) {
			System.out.println("Coding Everybody " + i);
			i++;
		}
		
		for( int j=5; j< 15; j++) {
			if ( j < 10 ) continue;
			System.out.println("Coding Anybody " + j);
			if ( j >= 13) break;
		}
		
		for ( int k = 1 ; k < 10 ; k++) {
			for ( int l = 1 ; l < 10 ; l++) {
				System.out.println(k + " * " + l + " = " + k * l);
			}
		}
	}

}
