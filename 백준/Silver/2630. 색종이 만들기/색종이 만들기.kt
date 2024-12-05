package ps

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val arr = Array(N) { IntArray(N) }
    val cnt = IntArray(2) { 0 }

    repeat(N) {
        arr[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    fun sol(sy: Int, sx: Int, size: Int) {
        if (size == 1) {
            cnt[arr[sy][sx]]++
        }

        val step = size / 2
        val colorsForArea = IntArray(4) { -1 }

        val dy = IntArray(4) { 0 }
        val dx = IntArray(4) { 0 }

        repeat(4) { area ->
            dy[area] = sy + step * (area / 2)
            dx[area] = sx + step * (area % 2)
            var isPaper = true

            for (y in dy[area] until dy[area] + step) {
                for (x in dx[area] until dx[area] + step) {
                    if (arr[dy[area]][dx[area]] != arr[y][x]) {
                        isPaper = false
                        break;
                    }
                }
            }

            if (isPaper) colorsForArea[area] = arr[dy[area]][dx[area]]
        }

        // 각 조각들이 모두 동일한 색의 종이인 경우
        if(colorsForArea[0] != -1 && colorsForArea.all { it == colorsForArea[0] }) {
            cnt[arr[sy][sx]]++
            return
        }

        colorsForArea.forEachIndexed { area, color ->
            if (color == -1) {
                sol(dy[area], dx[area], step)
            } else {
                cnt[color]++
            }
        }
    }

    sol(0, 0, N)
    cnt.forEach {
        println(it)
    }
}