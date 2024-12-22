package ps

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val input = IntArray(N) { 0 }
    val ans = IntArray(M) { 0 }
    val isUsed = BooleanArray(N) { false }
    val sb = StringBuilder()

    readLine().split(" ").map { it.toInt() }.sorted().forEachIndexed { index, i ->
        input[index] = i
    }

    fun sol(len: Int) {
        if(len == M) {
            for(i in 0 until M) {
                sb.append("${ans[i]} ")
            }
            sb.append("\n")
            return
        }

        for(i in 0 until N) {
            if(!isUsed[i]) {
                isUsed[i] = true
                ans[len] = input[i]
                sol(len + 1)
                isUsed[i] = false
            }
        }
    }

    for(i in 0 until N) {
        isUsed[i] = true
        ans[0] = input[i]
        sol(1)
        isUsed[i] = false
    }

    print(sb.toString())
}