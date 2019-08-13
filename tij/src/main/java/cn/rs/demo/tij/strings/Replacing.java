package cn.rs.demo.tij.strings;

public class Replacing {

    static String s = Splitting.knights;

    public static void main(String[] args) {
        System.out.println(s.replaceFirst("f\\w+", "located"));
        System.out.println(s.replaceAll("shrubbery|tree|herring", "banana"));
        System.out.println(s.replace("n", "j"));
    }

}
