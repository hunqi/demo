package designpattern.singleton;

import org.junit.Assert;

public class DBSingletonDemo {

    public static void main(String[] args) {
        DBSingleton db = DBSingleton.getInstance();
        System.out.println(db);

        DBSingleton anotherDb = DBSingleton.getInstance();
        System.out.println(anotherDb);

        Assert.assertTrue(db == anotherDb);
    }

}
