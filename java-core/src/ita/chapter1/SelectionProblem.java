package ita.chapter1;

import java.util.Random;

/**
 * find the max number in an array having N numbers
 */
public class SelectionProblem {

    public static void main(String[] args) {

        int[] arr = getArr(100000000);
        Random random = new Random();
        random.setSeed(50);


//        int k = arr.length/2;
        long start = System.currentTimeMillis();
        int maxIndex = 0;

//        for (int i=1; i<k; i++)
//            if (arr[i] > arr[maxIndex])
//                maxIndex = i;

        for (int i=0; i<arr.length; i++)
            if (arr[i] > arr[maxIndex])
                maxIndex = i;
        long end = System.currentTimeMillis();
        System.out.printf("k=%d, val=%d, cost time=%d", maxIndex, arr[maxIndex], end -start);
    }

    static int[] getArr(int n){
        int[] arr = new int[n];
        Random random = new Random();
        random.setSeed(50);

        for (int i=0; i<n; i++){
            arr[i] = random.nextInt(n);
        }
        return arr;
    }

}
