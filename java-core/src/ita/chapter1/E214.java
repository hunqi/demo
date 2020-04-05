package ita.chapter1;

/**
 * According to pseudocode of E214.txt
 */
public class E214 {

    public static void main(String[] args) {
        int[] a = {1,0,1,0,1,0,1};
        int[] b = {1,0,1,1,1,1,1};
        int[] c = new int[a.length + 1];

        int carry = 0;
        for (int i=a.length-1; i>=0; i--){
            int sum = a[i] + b[i] + carry;
            if (sum == 3){
                carry = 1;
                c[i+1] = 1;
            } else if(sum == 2){
                carry = 1;
                c[i+1] = 0;
            } else {
                carry = 0;
                c[i+1] = sum;
            }
        }
        if (carry == 1)
            c[0] = 1;

        for (int i=0; i<c.length; i++){
            System.out.printf("%d", c[i]);
        }
    }

}
