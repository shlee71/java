import java.util.Scanner;
public class MyScanner {

    public static void main(String[] args) {
        String source = "1 3 5";
        Scanner sc = new Scanner(source);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        int sum = num1 + num2 + num3;
        System.out.printf("%d + %d + %d = %d \n", num1, num2, num3, sum);

        System.out.println("<< Input number from Keyboard Process start 1 >>");

        Scanner sin = new Scanner(System.in);
        int in1 = sin.nextInt();
        int in2 = sin.nextInt();
        int in3 = sin.nextInt();

        int tot = in1 + in2 + in3;
        System.out.printf("%d + %d + %d = %d \n", in1, in2, in3, tot);

        System.out.println("<< Input all types from Keyboard Process start 2 >>");
        Scanner scan = new Scanner(System.in);
        System.out.print("Input String => ");
        String str1 = scan.nextLine();
        System.out.print("Input String => ");
        String str2 = scan.nextLine();
        System.out.printf(" Q : %s \n A: %s \n", str1, str2);
    }
}
