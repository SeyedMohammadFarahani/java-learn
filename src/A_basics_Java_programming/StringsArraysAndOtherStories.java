package A_basics_Java_programming;

import java.util.Arrays;
import java.util.Scanner;

public class StringsArraysAndOtherStories {

    public static void main(String[] args) {

        /* TODO example 1 for scanner*/
        /*Scanner scanner = new Scanner(System.in);
        int n = (int) scanner.nextInt();
        System.out.println(n);
        scanner.close();*/

        /* TODO example 2 for scanner*/
        /*Scanner scanner = new Scanner(System.in);
        int nextInt;
        do {
            nextInt = scanner.nextInt();
            for (int i = 0; i < nextInt; i++) {
                System.out.println(i);
            }
        } while (nextInt > 0);*/


        /*double number = Double.MIN_VALUE;*/

        /*System.out.format("min double = %5.10f", number);*/

        /* TODO Wrong */
        /*for (float f = 10f; f != 0; f -= 0.1) {
            System.out.println(f);
        }*/

        /* TODO Correct */
        /*for (float f = 10f; f > 0; f -= 0.1) {
            System.out.println(f);
        }*/

        /* TODO Switch case*/
        /*int number = 0;
        switch (number) {
            case 10:
                System.out.println("felan");
                break;
            case 15:
                System.out.println("bahman");
                break;
            default:
                System.out.println("default");
        }*/

        /* TODO use label for loops*/
        /*outer:for (int i = 0; i < 10; i++) {
            inner:
            for (int j = 0; j < 10; j++) {
                if (j == 2)
                    break outer;
                else {
                    System.out.println(i);
                    System.out.println(j);
                    continue inner;
                }
            }
        }*/

        /* TODO char and String*/

        /*char ch = 'a';
        char ch2 = '1';
        char ch3 = '#';
        String string = "ali";*/

        /* TODO example 3 for scanner*/
        /*Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.next();
        switch (input) {
            case "Salam":
                System.out.println("Hi!"); break;
            case "Khodahafez":
                System.out.println("Bye!"); break;
            default:
                System.out.println("Ha?!"); break;
        }*/

        /* TODO String methods*/
        /*String input = "Ahay Salam Ahay Salam!!!";
        char ch = input.charAt(0);
        System.out.println(ch);
        int i = input.indexOf("Salam");
        System.out.println(i);
        int j = input.lastIndexOf("Salam");
        System.out.println(j);
        String newS = input.replace("Salam", "chi shod");
        System.out.println(newS);
        String sth = newS + "che khabar? " + i ;
        System.out.println(sth);*/

        /* TODO Spatial chars */
        /*String s = "He said \"OK!\" and left";
        System.out.println(s);
        s = "Salam!\nI am S\tA";
        System.out.println(s);
        s = "Salam\\ Ok\' Bye\"";
        System.out.println(s);*/

        /* TODO array*/
        int[] array = new int[10];
        int array2[] = new int[10];

        char[] characters = new char[10];

        int[] numbers = {1, 2, 3, 5, 9, 123};

        int[][] matrix = new int[3][4];
        matrix[2][3] = 2;
        /*System.out.println(matrix[2][3]);*/

        /*int[][] matrix2 = new int[3][];
        matrix2[0] = new int[2];
        matrix2[1] = new int [5];
        matrix2[2] = new int [4];
        for (int i = 0; i < matrix2.length; i++) {
            System.out.println(Arrays.toString(matrix2[i]));
        }*/

        /* TODO foreach*/

        /*int[] numberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int num : numberArray) {
            System.out.println(num);
        }*/

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String[] inputs = new String[length];
        for (int i = 0; i < length; i++) {
            String s = scanner.next();
            inputs[i] = s;
        }

        System.out.println(Arrays.toString(inputs));

    }
}
