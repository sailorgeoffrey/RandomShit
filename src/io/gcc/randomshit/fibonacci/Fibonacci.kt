package io.gcc.randomshit.fibonacci

fun main(args: Array<String>) {
    var a = 1L
    println(a)
    var b = 1L
    println(b)
    var c: Long
    repeat((args.elementAtOrElse(0) { "10" }).toInt() - 2) {
        c = a + b
        println(c)
        a = b
        b = c
    }
}
