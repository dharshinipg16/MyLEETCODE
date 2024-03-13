class Solution {
    fun pivotInteger(n: Int): Int {
        val xx = (n * n + n) / 2
        val y = Math.sqrt(xx.toDouble())

        return if (y == Math.floor(y))
            y.toInt()
        else
            -1
    }
}