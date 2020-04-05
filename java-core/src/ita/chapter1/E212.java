package ita.chapter1;

/**
 * Rewrite the INSERTION-SORT procedure to sort into nonincreasing instead of nondecreasing
 * order.
 */
public class E212 {

    public static void main(String[] args) {

        int[] arr = {31, 41, 49, 26, 41, 58};
        print(arr, "before sorting");

        for (int j=1; j<arr.length; j++){
            int k = arr[j];
            int i = j - 1;

            while (i >= 0 && arr[i] < k){
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = k;
        }

        print(arr, "after sorting");
    }

    static void print(int[] arr, String message){
        System.out.printf("%-15s : ", message);
        for (int n : arr)
            System.out.printf(n + ", ");
        System.out.println();
    }

}
