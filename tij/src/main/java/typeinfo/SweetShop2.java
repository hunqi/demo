package typeinfo;

/**
 * Exercise 7: (3) Modify SweetShop.java so that each type of object creation is
 * controlled by a command-line argument. That is, if your command line is
 * "Java Sweetshop Candy," then only the Candy object is created. Notice how you
 * can control which Class objects are loaded via the commandline argument.
 */
public class SweetShop2 {

    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("input the candy name you want");
            System.exit(0);
        }

        System.out.println("inside main");
        System.out.printf("Begin creating : %s\n", args[0]);
        try {
            Class.forName("typeinfo." + args[0]);
        } catch (ClassNotFoundException e) {
            System.out.printf("Couldn’t find %s\n", args[0]);
        }
        System.out.printf("After Class.forName(\"%s\")\n", args[0]);
    }

}
