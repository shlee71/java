import java.util.Scanner;
import java.io.*;
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){
            System.out.println( sc.nextInt() * 100); 
        }

        //int i = sc.nextInt();
        //System.out.println(i* 100);
        sc.close();

        try {
	        File file = new File("C:\\LANG\\JAVA_TEST\\HelloWorld\\src\\input.txt");
	        Scanner fsc = new Scanner(file);
	        while(fsc.hasNextInt()) {
	        	System.out.println(fsc.nextInt() * 100);
	        }
	        fsc.close();
        } catch(FileNotFoundException e) {
        	e.printStackTrace();
        }
        System.out.println("ScannerDemo finished !!!");

    }

}
