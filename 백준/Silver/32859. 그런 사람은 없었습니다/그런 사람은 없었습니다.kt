package ps

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val S = readLine().toInt()
    val deposit = IntArray(N + 1) { -1 }
    val form = IntArray(N + 1) { -1 }
    val sb = StringBuilder()
    var cnt = 0

    repeat(M) { it ->
        val (member, case) = readLine().split(" ").map { it.toInt() }

        if(case == 0) {
            cnt++
            form[member] = cnt
        } else {
            deposit[member] = cnt
        }
    }
    cnt++

    deposit.forEachIndexed { index, i ->
        if(i != -1) {
            if(form[index].let{ if(it == -1) cnt else it} - i > S) {
                sb.appendLine(index)
            }
        }
    }

    if(sb.isEmpty()) {
        println(-1)
    } else {
        print(sb.toString())
    }
}