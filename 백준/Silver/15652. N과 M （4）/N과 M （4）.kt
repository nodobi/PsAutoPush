package ps

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map {it.toInt()}
    val arr = IntArray(M) {0}
    val sb = StringBuilder()

    fun sol(len: Int, cur: Int) {
        if(len == M) {
            for(i in 0 until M) {
                sb.append("${arr[i]} ")
            }
            sb.append("\n")
            return
        }

        for(i in cur .. N) {
            arr[len] = i
            sol(len + 1, i)
        }
    }

    for(i in 1 .. N) {
        arr[0] = i
        sol(1, i)
    }

    print(sb.toString())
}