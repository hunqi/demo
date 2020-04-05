package ita.chapter1;

/**
 * Using Figure 2.2 as a model, illustrate the operation of INSERTION-SORT on the
 * array A D h31; 41; 59; 26; 41; 58i.
 */
public class E211 {

    public static void main(String[] args) {

        int[] arr = {31, 41, 49, 26, 41, 58};
        print(arr);
        for (int j=1; j<arr.length; j++){
            int k = arr[j];
            int i = j - 1;

            while (i >= 0 && arr[i] > k){
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = k;
        }

        print(arr);
    }

    static void print(int[] arr){
        for (int n : arr)
            System.out.printf(n + ", ");
        System.out.println();
    }

}
