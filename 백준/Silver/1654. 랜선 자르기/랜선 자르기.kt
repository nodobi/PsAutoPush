package ps

fun main() = with(System.`in`.bufferedReader()) {
    val (K, N) = readLine().split(" ").map { it.toInt() }
    val cables = IntArray(K).map {
        readLine().toInt()
    }.sorted()
    var ret = 0

    var sv = 1L
    var ev = cables.max().toLong()

    while (sv <= ev) {
        val mid = (sv + ev) / 2
        var cnt = 0

        cables.forEach {
            cnt += (it / mid).toInt()
        }

        if (cnt < N) {
            // 잘라도 개수가 안되는 경우, 자르는 길이를 줄여서 탐색
            ev = mid - 1
        } else {
            // 잘랐을 때 개수가 되는 경우 자르는 길이를 늘려서 탐색
            sv = mid + 1
            ret = (mid).toInt()
        }
    }

    println(ret)
}