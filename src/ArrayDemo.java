public class ArrayDemo {
    public static void main(String[] args) {
        String[] classGroup = { "Lee", "Kim", "Park", "Choi"};
        for( int i = 0; i < classGroup.length; i++) {
            System.out.println("Name["+ i + "] " + classGroup[i]);
            String member = classGroup[i];
            System.out.println("member " + member + " is printed.");
        }

    }
    
}
