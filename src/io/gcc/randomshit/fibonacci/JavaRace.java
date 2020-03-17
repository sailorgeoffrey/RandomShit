package io.gcc.randomshit.fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;



public class JavaRace {

    private static int fibonacci(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        return fibonacci(n - 2 + n - 1);
    }

    static final int times = 10000;
    static final LinkedList<BigInteger> list = new LinkedList<>(Arrays.asList(BigInteger.valueOf(1), BigInteger.valueOf(1)));


    private static BigInteger fibonacciWithLinkedList(int n) {
        if (list.size() < n) list.push(fibonacciWithLinkedList(n - 2).add(fibonacciWithLinkedList(n - 1)));
        return list.peek();
    }

    static ArrayList<BigInteger> seq = new ArrayList<>(Arrays.asList(BigInteger.valueOf(1), BigInteger.valueOf(1)));

    private static BigInteger fibonacciWithArrayList(int n) {
        if (seq.size() < n) seq.add(n - 1, fibonacciWithArrayList(n - 2).add(fibonacciWithArrayList(n - 1)));
        return seq.get(n - 1);
    }

    public static void main(String[] args) {
        for (int count = 0; count < 100; count++) {

            seq = new ArrayList<>(times);
            seq.add(BigInteger.valueOf(1));
            seq.add(BigInteger.valueOf(1));

            long timer = System.currentTimeMillis();
            for (int i = 1; i < 10000000; i++) {
                fibonacciWithLinkedList(times);
            }
            long stoptime = System.currentTimeMillis();

            System.out.println("linked list: " + (stoptime - timer));

            timer = System.currentTimeMillis();
            for (int i = 1; i < 10000000; i++) {
                fibonacciWithArrayList(times);
            }
            stoptime = System.currentTimeMillis();
            System.out.println("array list: " + (stoptime - timer));
        }
    }
}
