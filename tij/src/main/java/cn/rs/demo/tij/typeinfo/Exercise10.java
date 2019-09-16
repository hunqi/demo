package cn.rs.demo.tij.typeinfo;

public class Exercise10 {

    public static void main(String[] args) {

        char[] chars = {'1', '2', 'a', 'c', 'e', 'f'};
        Class<? extends char[]> aClass = chars.getClass();
        if (aClass.isPrimitive())
            System.out.println("chars is primitive");
        else
            System.out.println("chars is Object");

    }

}
