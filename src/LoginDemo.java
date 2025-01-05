// run : C:\LANG\JAVA_TEST\HelloWorld\bin> java LoginDemo shlee
public class LoginDemo {
    public static void main(String[] args) {
        String id = args[0];

        if(id.equals("shlee")){
            System.out.println("right");
        } else {
            System.out.println("wrong");
        }
    }
    
}
