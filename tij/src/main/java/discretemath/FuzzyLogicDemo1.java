package discretemath;

import java.util.Scanner;

/**
 * 给定模糊逻辑中命题p和q的真值，求p和q的析取和合取的真值
 */
public class FuzzyLogicDemo1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        while (!"exit".equalsIgnoreCase(s)){
            System.out.printf("input values are : %s\n", s);
            String[] values = s.split(" ");

            if (values.length >= 2){
                try {
                    Double p = Double.parseDouble(values[0]);
                    Double q = Double.parseDouble(values[1]);

                    if(isParametersValueBetween0And1(p, q)){
                        System.out.printf("value of AND is: %6.2f\n", p <= q ? p : q);
                        System.out.printf("value of OR is: %6.2f\n", p >= q ? p : q);
                    }else
                        System.out.printf("Invalid parameters: p=%6.2f, q=%6.2f\n", p, q);
                }catch (NumberFormatException e){
                    System.out.println("Invalid parameters!");
                }
            }else
                System.out.println("Invalid parameters!");

            s = in.nextLine();
        }
    }

    private static boolean isParametersValueBetween0And1(Double p, Double q) {
        return (p >= 0 && p <= 1) && (q >= 0 && q <= 1);
    }

}
