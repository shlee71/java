class Box {
    private String conts;

    Box(String cont) {
        this.conts = cont;
    }
    public Box(int i, String string) {
        //TODO Auto-generated constructor stub
    }
    public String toString(){
        return conts;
    }
    public int getBoxNum() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoxNum'");
    }
}

public class MyPrint {
    public static void main(String[] args) {
        StringBuilder stb = new StringBuilder("12");
        stb.append(34);

        System.out.println(stb.toString());
        System.out.println(stb);

        Box box = new Box("Camera");
        System.out.println(box.toString());
        System.out.println(box);

        int age =55;
        double height = 170.3;
        String name = "LEE Ho";
        double rate = 1.2345678;

        System.out.printf("\nname : [%s], age : [%d], height : [%f], rate: [%e] \n\n", name, age, height, rate);
    }
}
