package ps

fun main() = with(System.`in`.bufferedReader()) {
    val (year, order) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    sb.append("SN ${year}")

    if(order <= 26) {
        sb.append('A' + (order - 1))
    } else {
        sb.append('a' + ((order - 1) / 26) - 1)
        sb.append('a' + ((order - 1) % 26))
    }

    println(sb.toString())
}