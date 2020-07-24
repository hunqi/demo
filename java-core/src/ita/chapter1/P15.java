package ita.chapter1;

//this application can calculate quantity of 1 in the bit vector of integer N
public class P15 {

    static int cnt = 0;

    // count one in binary
    static void coib(int i){
        if (i == 0) return;
        if (i == 1)  {
            ++cnt;
            return;
        }

        if (((i>>1)<<1) != i) {
            cnt++;
            coib(i>>1);
        }else
            coib(i>>1);
    }

    public static void main(String[] args) {
        int i = 999;
        coib(i);
        System.out.printf("quantity of 1 in bit vector of %d is: %d\n", i, cnt);
    }
}
