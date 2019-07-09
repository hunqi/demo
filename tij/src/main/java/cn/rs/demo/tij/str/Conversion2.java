package cn.rs.demo.tij.str;

import java.math.BigInteger;

/**
 * Exercise 5: (5) For each of the basic conversion types in the above table,
 * write the most complex formatting expression possible. That is, use all the
 * possible format specifiers available for that conversion type.
 *
 * @author ray.sun
 * @since Jul 9th 2019
 */
public class Conversion2 {

    public static void main(String[] args) {

        Object[] values = {'a', 121, new BigInteger("50000000000000"),
                179.543, new Conversion2(), false};

        String[] specifiers = {"d", "c", "b", "s", "f", "e", "x", "h"};

        for (Object o : values){
            StringBuilder sb = new StringBuilder("content is : ");
            StringBuilder exMsg = new StringBuilder();
            StringBuilder validSpecifiers = new StringBuilder("valid specifiers of ").append(o).append(" is : ");
            for (String s : specifiers){
                try {
                    sb.append(String.format("%" + s, o)).append(",");
                    validSpecifiers.append(s).append(",");
                }catch (Exception e){
                    exMsg.append(e.getMessage()).append(",");
                }
            }
            System.out.println("when o is " + o.getClass().getName());
            System.out.println(validSpecifiers.deleteCharAt(validSpecifiers.length() - 1));
            System.out.println(sb.deleteCharAt(sb.length() - 1));
//            System.out.println(exMsg.deleteCharAt(exMsg.length() - 1));
            System.out.println();
        }
    }

}
