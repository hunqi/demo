package discrete_math;

public class SortDemo {


    void insertionSort(int[] arr) {
        int m = 0;
        for (int j = 1; j < arr.length; j++) {
            int i = 0;
            while (arr[j] > arr[i])
                i++;
            m = arr[j];
            for (int k = 0; k < j - i; k++)
                arr[j - k] = arr[j - k - 1];
            arr[i] = m;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 9, 3, 6, 1, 10};
        print(arr);
        SortDemo demo = new SortDemo();
        demo.insertionSort(arr);
        print(arr);
    }

    static void print(int[] arr){
        for (int i : arr)
            System.out.printf("%d ", i);
        System.out.println();
    }


}
