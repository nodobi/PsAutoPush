package ps

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val s = Stack<Char>()
    var cnt = 0

    repeat(n) {
        val input = readLine()
        if (input.length % 2 == 1) return@repeat

        input.forEach {
            if (s.isNotEmpty() && s.peek() == it)
                s.pop()
            else
                s.push(it)
        }

        if (s.isEmpty()) cnt++
        s.clear()
    }

    println(cnt)
}