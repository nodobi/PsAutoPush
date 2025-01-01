package ps

fun main() = with(System.`in`.bufferedReader()) {
    val (M, N) = readLine().split(" ").map(String::toInt)
    val field = Array(N) { IntArray(M) }
    val q = ArrayDeque<Pair<Int, Int>>()
    var days = 0;
    var unripe = 0

    repeat(N) { y ->
        field[y] = readLine()
            .split(" ")
            .map(String::toInt)
            .toIntArray()
            .also {
                it.forEachIndexed { x, i ->
                    if (i == 0) {
                        unripe++
                    } else if (i == 1) {
                        q.add(y to x)
                    }
                }
            }
    }

    val dy = arrayOf(-1, 0, 1, 0)
    val dx = arrayOf(0, 1, 0, -1)
    while (q.isNotEmpty() && unripe > 0) {
        repeat(q.size) {
            val (cy, cx) = q.removeFirst()

            repeat(4) {
                val ly = cy + dy[it]
                val lx = cx + dx[it]

                if (ly in 0..<N && lx in 0..<M && field[ly][lx] == 0) {
                    field[ly][lx] = 1
                    unripe--
                    q.add(ly to lx)
                }
            }
        }

        days++
    }

    println(days.let { if (unripe > 0) -1 else it })
}