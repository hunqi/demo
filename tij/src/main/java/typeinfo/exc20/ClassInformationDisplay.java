package typeinfo.exc20;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Exercise 20: (5) Look up the interface for java.lang.Class in the JDK documentation
 * from http://java.sun.com. Write a program that takes the name of a class as a
 * command-line argument, then uses the Class methods to dump all the information
 * available for that class. Test your program with a standard library class and a class you create.
 */
public class ClassInformationDisplay {

    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length == 0) {
            System.out.println("you must provide a fully qualified classname");
            System.exit(0);
        }

        String classname = args[0];
        Class<?> aClass = Class.forName(classname);

        System.out.println("simple classname : " + aClass.getSimpleName());
        System.out.println("qualified classname: " + aClass.getName());

        List<Class> superClassList = new ArrayList<>();
        Class<?> superclass = aClass.getSuperclass();
        superClassList.add(superclass);

        System.out.println();
        while (!(null == superclass || superclass == Object.class)) {
            superclass = superclass.getSuperclass();
            superClassList.add(superclass);
        }

        Formatter f = new Formatter(System.out);

        f.format("super classes of %s is/are %s\n", classname, superClassList);
        f.format("implemented interfaces of %s is/are : %s\n",
                classname,
                Stream.of(aClass.getInterfaces()).map(Class::getName).collect(Collectors.joining(" ,")));

        System.out.println("\nconstructors:");
        for (Constructor c : aClass.getConstructors())
            f.format("%s %s(%s)\n",
                    c.getModifiers(),
                    c.getName(),
                    Stream.of(c.getParameters())
                            .map(Parameter::getType)
                            .map(Class::getName)
                            .collect(Collectors.joining(" ,")));

        System.out.println("-------------------------------------------------\n");
        f.format("\nmethods's size: %d\n", aClass.getMethods().length);
        for (Method m : aClass.getMethods())
            printMethod(m);

        System.out.println("-------------------------------------------------");
        f.format("\ndeclared methods's size: %d\n", aClass.getMethods().length);
        for (Method m : aClass.getDeclaredMethods())
            printMethod(m);

    }

    private static void printMethod(Method m){
        Formatter f = new Formatter(System.out);
        f.format("%s %s(%s)\n",
                m.getModifiers(),
                m.getName(),
                Stream.of(m.getParameterTypes()).map(Class::getName).collect(Collectors.joining(" ,")));
    }


}
