package io.gcc.randomshit.fibonacci

import java.math.BigInteger
import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.measureTimeMillis

val list = LinkedList(listOf(BigInteger.valueOf(1), BigInteger.valueOf(1)))

fun fibonacciWithLinkedList(n: Int): BigInteger {
    if (list.size < n) list.push(fibonacciWithLinkedList(n - 2).add(fibonacciWithLinkedList(n - 1)))
    return list.peek()
}

val seq = ArrayList(listOf(BigInteger.valueOf(1), BigInteger.valueOf(1)))

fun fibonacciWithArrayList(n: Int): BigInteger {
    if (seq.size < n) seq.add(n - 1, fibonacciWithArrayList(n - 2).add(fibonacciWithArrayList(n - 1)))
    return seq[n - 1]
}

fun main() {

    val times = 13000

    val linkedListTime = measureTimeMillis {
        repeat(times * 5000) {
            fibonacciWithLinkedList(times)
        }
    }
    println("linked list: $linkedListTime")

    val arrayListTime = measureTimeMillis {
        repeat(times * 5000) {
            fibonacciWithArrayList(times)
        }
    }
    println("array list: $arrayListTime")
}