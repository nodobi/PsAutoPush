package ps

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val s = Stack<Char>()
    var isBalanced = true
    var input = ""

    while (
        readLine().also {
            input = it
        } != "."
    ) {
        for (i in 0 until input.length - 1) {
            if (input[i] == '(' || input[i] == '[') {
                s.push(input[i])
            } else if (input[i] == ')') {
                if (s.isEmpty() || s.peek() != '(') {
                    isBalanced = false
                    break
                } else {
                    s.pop()
                }
            } else if (input[i] == ']') {
                if (s.isEmpty() || s.peek() != '[') {
                    isBalanced = false
                    break
                } else {
                    s.pop()
                }
            }
        }

        sb.append(if(s.isEmpty() && isBalanced) "yes\n" else "no\n")
        s.clear()
        isBalanced = true
    }

    print(sb.toString())
}