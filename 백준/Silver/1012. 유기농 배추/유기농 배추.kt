package ps

fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    val sb = StringBuilder()
    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    repeat(T) {
        val (M, N, K) = readLine().split(" ").map(String::toInt)
        val field = Array(N) { IntArray(M) }
        val q = ArrayDeque<Pair<Int, Int>>()
        var ret = 0

        repeat(K) {
            val (X, Y) = readLine().split(" ").map(String::toInt)
            field[Y][X] = 1
        }

        for (y in 0 until N) {
            for (x in 0 until M) {
                if (field[y][x] == 0) continue
                q.add(y to x)
                field[y][x] = 0
                ret++

                while (q.isNotEmpty()) {
                    val (cy, cx) = q.removeFirst()

                    repeat(4) {
                        val lx = cx + dx[it]
                        val ly = cy + dy[it]
                        if (ly >= 0 && ly < N && lx >= 0 && lx < M
                            && field[ly][lx] == 1
                        ) {
                            q.add(ly to lx)
                            field[ly][lx] = 0
                        }
                    }
                }

            }
        }

        sb.appendLine(ret)
    }

    print(sb.toString())
}
