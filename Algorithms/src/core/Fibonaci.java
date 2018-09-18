package core;

import java.math.BigDecimal;

/**
 * Created by tamdx on 9/18/18.
 */
public class Fibonaci {
    public static void main(String[] args) {
        Fibonaci app = new Fibonaci();
        app.fibonaci(100);

        System.out.println("----------");
        app.fibonaci_Big(100);
    }
    public void fibonaci(int n){
        Long s1 = 0L, s2 = 1L;
        int index = 1;
        Long  s = 0L;
        while (index <= n){
            s = s1+s2;
            s1 = s2;
            s2 = s;
            System.out.println(s);
            index++;
        }
    }

    public void fibonaci_Big(int n){
        BigDecimal s1 = new BigDecimal(0);
        BigDecimal s2 = new BigDecimal(1);
        int index = 1;
        BigDecimal s = new BigDecimal(0);
        while (index <= n){
            s = s1.add(s2);
            s1 = s2;
            s2 = s;
            System.out.println(s);
            index++;
        }
    }
}
