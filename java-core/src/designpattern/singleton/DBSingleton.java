package designpattern.singleton;

public class DBSingleton {

    private static DBSingleton db = new DBSingleton();

    private DBSingleton(){}

    public static DBSingleton getInstance(){
        return db;
    }

}
