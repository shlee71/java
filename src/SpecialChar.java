public class SpecialChar {
	
    public static void main(String[] args) {
        System.out.println("Good\t Morning !!");
        System.out.println("Good\n Morning !!");
        System.out.println("Good \"Morning\"!!");
        int num = 10;

        System.out.println("지금음 영상 " + num +"도 입니다.");
        System.out.printf("지금음 영상 %d 도 입니다.\n", num);

        int num1= 18;
        System.out.printf("deciaml[%d], octal[%o], Hex[%X], char[%c], String[%s], float[%f]\n\n", num1, num1, num1, 'a', "abcde", 12.34 );
        
        System.out.printf("[%5d], [%05d], [%5d] [%10.2f], [%010.4f]\\n", 123, 123, 1234, 123.456, 123.456);         
    }
}
