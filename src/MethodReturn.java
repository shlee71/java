public class MethodReturn {
    public static String[] getMembers(){
        String[] members = {"Kim","Lee","Park"};

        return members;
    }

    public static void main(String[] args) {
        String[] members = getMembers();

        for (String e: members){
            System.out.println(e);
        }
    }
    
}
