/* C:\LANG\JAVA_TEST\HelloWorld> java -cp bin InputDemo 1 2 3 4 5678 nine ten*/

public class InputDemo {
    public static void main(String[] args) {
        System.out.println(args.length);

        System.out.println("=============");

        for(String e: args)
        {
            System.out.println(e);
        }
    }    
}
