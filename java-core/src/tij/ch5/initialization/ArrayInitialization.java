package tij.ch5.initialization;

public class ArrayInitialization {

    public static void main(String[] args) {
//        String[] favors = {"basketball", "football", "tabletennis", "badminton"};
//
//        System.out.println("I love sports: ");
//        for (String f : favors)
//            System.out.println("\t" + f);

        Student[] students = new Student[50];
        students[0] = new Student("小明");
    }

}

class Student {
    String name;
    Student(String n){
        name = n;
        System.out.println("Strudent(" + name + ")");
    }
}
