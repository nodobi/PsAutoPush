package ps

import kotlin.collections.ArrayDeque

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val field = Array(N) { IntArray(M) }
    val q = ArrayDeque<Pair<Int, Int>>()
    var cnt = 0;
    var max = 0

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    repeat(N) {
        val input = readLine().split(" ").map { it.toInt() }
        field[it] = input.toIntArray()
    }

    for (y in 0 until N) {
        for (x in 0 until M) {
            if (field[y][x] == 0) continue
            var size = 0
            field[y][x] = 0
            q.add(x to y)
            cnt++

            while (!q.isEmpty()) {
                val (cx, cy) = q.removeFirst()
                size++
                for (i in 0..3) {
                    val lx = cx + dx[i]
                    val ly = cy + dy[i]

                    if (
                        lx >= 0 && lx < M && ly >= 0 && ly < N
                        && field[ly][lx] == 1
                    ) {
                        field[ly][lx] = 0
                        q.add(lx to ly)
                    }
                }
            }

            if(max < size) max = size
        }
    }


    println(cnt)
    println(max)
}