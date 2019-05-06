package tij.ch5.exercise;

public class VarargsTest1 {

    static void print(String ... args){
        for (String s: args)
            System.out.print(s + ", ");
        System.out.println();
    }

    public static void main(String[] args) {
        print(new String[]{"One", "Two", "Three"});
        print("Mouse", "Bulk", "Tiger");
    }


}
