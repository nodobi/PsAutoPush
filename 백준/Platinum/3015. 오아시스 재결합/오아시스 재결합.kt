package ps

import java.util.*

/**
 * 8    x                       0   0
 * 8    8                       1   1
 * 7    8                       1   2
 * 7    7 8                     2   4
 * 7    7 7 8                   3   7
 * 6    7                       1   8
 * 6    6 7                     2   10
 * 7    6 6 7 7 7 8             6   16
 * 7    7 7 7 7 8               5   21
 * 7    7 7 7 7 7 8             6   27
 * 7    7 7 7 7 7 7 8           7   34
 * 9    7 7 7 7 7 7 7 8 8       9   43
 * 9    9                       1   44
 */

fun main() = with(System.`in`.bufferedReader()) {

//    while (true) {
        val n = readLine().toInt()

        // 키, 연속되는 키 수
        val s = Stack<Pair<Int, Int>>()
        var cnt_pair = 0L

        repeat(n) {
            // 현재 사람의 키
            val curr = readLine().toInt()

            // 현재 키를 가진 사람 수
            var curr_cnt = 1

            // 현재 사람이 이루는 짝의 수
            var cnt_curr_pair = 0

            // top < curr
            if (s.isNotEmpty()) {
                while(s.isNotEmpty() && s.peek().first < curr) {
                    val top = s.pop()
                    cnt_curr_pair += top.second
                }
            }

            if (s.isNotEmpty()) {
                if (s.peek().first == curr) {
                    // top == curr
                    val top = s.pop()
                    curr_cnt = top.second + 1
                    cnt_curr_pair += top.second

                    // 앞에 큰 수가 있는 경우,
                    if(s.isNotEmpty()) {
                        cnt_curr_pair++
                    }
                } else if (s.peek().first > curr) {
                    // top > curr
                    cnt_curr_pair++
                }
            }
            s.push(curr to curr_cnt)
            cnt_pair += cnt_curr_pair
        }

        println(cnt_pair)
//    }
}