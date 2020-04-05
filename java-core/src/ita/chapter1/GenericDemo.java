package ita.chapter1;

public class GenericDemo {

    static <T> boolean contains(T[] arr, T x) {
        for (T t : arr)
            if (x.equals(t))
                return true;
        return false;
    }

    static <T extends Comparable<? super T>> T findMax(T[] arr) {
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++)
            if (arr[i].compareTo(arr[maxIndex]) > 0)
                maxIndex = i;
        return arr[maxIndex];
    }

    public static void main(String[] args) {
//        Shape[] arr = new Shape[3];
//        arr[0] = new Shape();
//        System.out.println(contains(arr, new Apple()));


    }

    static class Shape {
    }

    static class Apple {
    }

}

class GenericMemoryCell<T> {
    private T storedVal;
    void write(T val){
        storedVal = val;
    }
    T read(){
        return storedVal;
    }

    void test(){

    }

    public static void main(String[] args) {
        GenericMemoryCell<String>[] arr1 = new GenericMemoryCell[10];
        GenericMemoryCell<Double> cell = new GenericMemoryCell<>();
        cell.write(4.5);
        Object[] arr2 = arr1;
        arr2[0] = cell;
        String s = arr1[0].read();  //ClassCastException: java.lang.Double cannot be cast to java.lang.String
    }
}
