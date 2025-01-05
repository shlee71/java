public class MethodDemo {
    public static void numbering(int limit){
        int i = 0;

        for ( i=0; i< limit; i++){
            System.out.println(i);
        }
    }

    public static String numbering(int start, int end){
        int i = 0;
        String output = "";

        for ( i=start; i<= end; i++){
            System.out.println(i);

            output += i;
        }

        return output;
    }


    public static void main(String[] args) {
        numbering(3);
        System.out.println(numbering(3,5));
    }
}
