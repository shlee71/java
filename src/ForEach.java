class Box {
    private int num;
    private String conts;

    Box(String cont) {
        this.conts = cont;
    }
    public Box(int i, String string) {
        this.num = i;
        this.conts = string;
    }
    public String toString(){
        return conts;
    }
    public int getBoxNum() {
        return this.num;
    }
}
public class ForEach {
    public static void main(String[] args) {

        String[] members = {"Lee", "Choi","Pak"};
        for(String e : members){
            System.out.println(e + " is called");
        }

        int[] ar ={ 1,2,3,4,5};
        int sum = 0;
        for( int e: ar) {
            System.out.print(e + " ");
            sum += e;
        }
        System.out.println();

        Box[] arr = new Box[5];
        arr[0] = new Box(101, "Coffee");
        arr[1] = new Box(202, "Computer");
        arr[2] = new Box(303, "Apple");
        arr[3] = new Box(404, "Dress");
        arr[4] = new Box(505, "e-Book");

        for(Box e: arr) {
            if ( e.getBoxNum() == 505)
                System.out.println(e);
        }
        //System.out.println(members[3]);
    }
}
