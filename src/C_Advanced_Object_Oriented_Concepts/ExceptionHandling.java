package C_Advanced_Object_Oriented_Concepts;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] args) {

        /* Todo Division Zero */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter second number: ");
        int second = scanner.nextInt();

        try {
            System.out.println(division(first, second));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* Todo Print stack trace Zero */
        try {
            f();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Todo Finally Block */
        try {
            //..
        } catch (Exception e) {
            //…
        } finally {
            System.out.println("finally Block");
        }

        /* Todo Unreachable catch block */
        /* az kochak be bozorg bayd catch beshan */

        /*try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            System.out.println(a/b);
        } catch (Exception ex) {
            //..
        } catch (ArrayIndexOutOfBoundsException e) {
            //..
        }*/

        /* Todo catch multi exception from Java 7 */

        /*try {
            f();
        } catch (IOException | SQLException ex) {
            log(ex);
        } catch (ClassCastException ex) {
            throw ex;
        }*/

        /* Todo try-with-resources from Java 7*/

        try (BufferedReader br = new BufferedReader(new FileReader("path"))) {
            br.readLine();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    private static int division(int first, int second) throws Exception {
        if (second == 0)
            throw new Exception("divide by 0 not allowed");
        else
            return first / second;
    }

    private static void f() {
        g();
    }

    private static void g() {
        throw new NullPointerException();
    }


    /* Todo Unchecked Exception */
    // ArithmeticException & ArrayIndexOutOfBoundsException
    // Error
    // RuntimeException

    void example(int x) throws IOException {
        // Unchecked Exception
        if (x == 1)
            throw new Error();
        // Unchecked Exception
        if (x == 2)
            throw new RuntimeException();
        // Checked Exception
        if (x == 3)
            throw new IOException();
    }


}

/* Todo create Custom Exception */

class BadIranianNationalID extends Exception {
    public BadIranianNationalID() {
        super();
    }

    public BadIranianNationalID(String message) {
        super(message);
    }
}

class ParentClass {
    void f() throws ArithmeticException {
    }
}

/* Todo class child nabayad exception bishtari az class parent throw partab konad*/
class ChildClass extends ParentClass {
    // void f() throws Exception {}
}

