package cn.rs.demo.tij.typeinfo;

import java.util.ArrayList;
import java.util.List;

public class FilledList<T> {

    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> create(int nElements) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < nElements; i++) {
            try {
                result.add(type.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {

        FilledList<CountedInteger> list = new FilledList<>(CountedInteger.class);
        System.out.println(list.create(16));

    }
}

class CountedInteger {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return Long.toString(id);
    }
}
