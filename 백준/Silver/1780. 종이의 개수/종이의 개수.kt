package ps

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val arr = Array(N) { intArrayOf() }
    val cnt = IntArray(3) { 0 }

    for (i in 0 until N) {
        arr[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    fun sol(sx: Int, sy: Int, size: Int) {
        // base condition
        if (size == 1) {
            cnt[arr[sy][sx] + 1]++
            return
        }

        var isPaper = true
        val step = size / 3

        // 검사
        root@ for(y in sy until sy + size) {
            for(x in sx until sx + size) {
                if(arr[sy][sx] != arr[y][x]) {
                    isPaper = false
                    break@root
                }
            }
        }

        if (isPaper) {
            cnt[arr[sy][sx] + 1]++
        } else {
            repeat(9) { section ->
                val dx = sx + step * (section % 3)
                val dy = sy + step * (section / 3)

                sol(dx, dy, step)
            }
        }
    }

    sol(0, 0, N)
    cnt.forEach {
        println(it)
    }
}

