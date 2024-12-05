package ps

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val arr = Array(N) { IntArray(N) }
    val sb = StringBuilder()

    repeat(N) {
        arr[it] = readLine().map { it.digitToInt() }.toIntArray()
    }

    fun sol(sy: Int, sx: Int, size: Int) {
        if (size == 1) {
            sb.append(arr[sy][sx])
            return
        }

        val step = size / 2
        val colorsForArea = IntArray(4) { -1 }

        val dy = IntArray(4) { 0 }
        val dx = IntArray(4) { 0 }

        repeat(4) { area ->
            dy[area] = sy + step * (area / 2)
            dx[area] = sx + step * (area % 2)
            var isSameColor = true

            for (y in dy[area] until dy[area] + step) {
                for (x in dx[area] until dx[area] + step) {
                    if (arr[dy[area]][dx[area]] != arr[y][x]) {
                        isSameColor = false
                        break;
                    }
                }
            }

            if (isSameColor) colorsForArea[area] = arr[dy[area]][dx[area]]
        }

        // 지금 압축 가능하다면,
        if (colorsForArea[0] != -1 && colorsForArea.all { it == colorsForArea[0] }) {
            sb.append(colorsForArea[0])
            return
        }

        // 압축 불가능하면
        sb.append("(")
        colorsForArea.forEachIndexed { area, color ->
            if (color == -1) {
                sol(dy[area], dx[area], step)
            } else {
                sb.append(color)
            }
        }
        sb.append(")")
    }

    sol(0, 0, N)
    println(sb.toString())
}