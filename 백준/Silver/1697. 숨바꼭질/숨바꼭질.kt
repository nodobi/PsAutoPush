package ps

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (N, K) = readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(max(N, K) * 2 + 1)
    val deque = ArrayDeque<Pair<Int, Int>>()
    deque.add(N to 0)
    visited[N] = true

    while (deque.isNotEmpty()) {
        val (x, cnt) = deque.removeFirst()

        if (x == K) {
            println(cnt)
            return@with
        }

        if (x < K) {
            if(!visited[x + 1]){
                deque.add(x + 1 to cnt + 1)
                visited[x+1] = true
            }

            if(!visited[x * 2]) {
                deque.add(x * 2 to cnt + 1)
                visited[x*2] = true
            }
        }
        if (x > 0 && !visited[x - 1]) {
            deque.add(x - 1 to cnt + 1)
            visited[x-1] = true
        }

    }
}