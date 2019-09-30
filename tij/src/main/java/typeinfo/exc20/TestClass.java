package typeinfo.exc20;

public class TestClass {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class<?> aClass = Class.forName("java.lang.Thread");
        System.out.println(aClass.getName());
        System.out.println(aClass.isArray());
        System.out.println("aClass.isLocalClass(): " + aClass.isLocalClass());
        System.out.println("aClass.isMemberClass(): " + aClass.isMemberClass());

        int i=1;
        System.out.println(aClass.isInstance(i));
        System.out.println(int.class.isInstance(i));
        Integer integer=1;
        System.out.println(Integer.class.isInstance(integer));
    }

}
