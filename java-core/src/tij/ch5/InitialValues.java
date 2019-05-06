package tij.ch5;

public class InitialValues {
//    int j = i;  //illegal forward reference
//    int j = f(i);   //illegal forward reference
    int j = f(2);
    int i = 1;
    int f(int val){
        return val*2;
    }

}
