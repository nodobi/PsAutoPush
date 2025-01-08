import kotlin.math.*

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val S = IntArray(N+1)
    val P = Array(N+1) { IntArray(3) }
    
    repeat(N) {
        S[it+1] = readLine().toInt()
    }
    
    if(N == 1) {
        println(S[1])
        return
    }
    
    P[1][1] = S[1]
    P[2][1] = S[2]
    P[2][2] = S[1]+S[2]
    
    for(i in 3 .. N) {
        P[i][1] = max(P[i-2][1], P[i-2][2]) + S[i]
        P[i][2] = P[i-1][1] + S[i]
    }
    
    println(max(P[N][1], P[N][2]))
}