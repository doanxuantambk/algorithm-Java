/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversions;

import java.util.Stack;

/**
 *
 * @author tamdx
 */
public class DecimalToBinary {

    public static void main(String[] args) {
        convert(20,3);
    }

    public static void convert(Integer num, Integer type) {
        int k;
        int d = num / type;
        Stack s = new Stack();
        while (d > 0) {
            k = num % type;
            d = num / type;
            num = d;
            System.out.print(" " + k);
            s.push(k);
        }
        System.out.println("\nKet qua:");
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
    }

}
