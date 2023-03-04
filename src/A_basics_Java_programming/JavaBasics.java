package A_basics_Java_programming;

public class JavaBasics {


    public static void main(String[] args) {

        /* Variables */
        boolean variable1;

        byte variable2 = 127;
        short variable3;
        char variable4;
        int variable5;
        long variable6 = 12214124L;

        float variable7 = 1234.12F;
        double variable8 = 12214214.1213D;

        /* Operators */
        // + - * / %

        /* Operators Precedence */
        // * /  % + - =

        /* Associativity */
        // x = y = z = 17 => x = (y = (z = 17))
        // 72 / 2 / 3     => ( 72 / 2) / 3

        /* unary Operators*/
        // a++; ++a;

        /* Logical Operators */
        // &&  ||  !

        /* Compound operators */
        // a = a/10;  a/=10;
        // b = b*10;  b*=10;
        // a = a + 1; a+=1 ; or a++;

        /* Conditional threeFunctional operator */
        // TYPE value = CONDITION ? Val_True : Val_False;

        /* Print */
        // System.out.println(a);
        // System.out.print(x);


        /* Loop */

        long counter = 1;
        while (counter < 10) {
            /*System.out.println(counter);*/
            counter++;
        }

        long count = 0;
        do {
            count++;
            /*System.out.println(count);*/
        } while (count < 10);

        for (int i = 1; i <= 10; i++) {
            /*System.out.println(i);*/
        }

        //double result = add(10, 15);

        /*for (int i = 0; i < 10; i++) {
            System.out.println(fib(i) + " ");
        }*/

        //System.out.println(isPowerTwo(63));;

        System.out.println(palindrome(123321));

    }

    /* Method*/
    static double add(double a, double b) {
        return a + b;
    }

    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static boolean isPowerTwo(int number) {
        return (number % 2) == 0;
    }

    static boolean palindrome(int number) {
        int firstValue = number;
        int length = String.valueOf(number).length();
        int pal = 0;
        for (int i = 1, power = length - 1; i <= length; i++, power--) {
            int mod = (int) (number % Math.pow(10, 1));
            pal = pal + (int) (mod * (Math.pow(10, power)));
            number = number / 10;

        }
        return pal == firstValue;

    }

}
