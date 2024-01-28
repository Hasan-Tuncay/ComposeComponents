package com.hasantuncay.composeComponents.components

fun main() {
    val sum = Solution().sumDigit(9999991)
    println(sum)

}

// num=17 (1+7 = 8  > return 8 )
// num=91 (9+1 = 10  > return 10 )
// num=568 (5+6+8 = 19  > return 19 )
class Solution {

    fun main(num: Int) {
        val sum = sumDigit(num)

    }


    fun sumDigit(number: Int): Int {
        var sum = number
        while (sum > 9) {
            var tempSum = 0
            var tempNumber = sum
            while (tempNumber > 0) {
                tempSum += tempNumber % 10
                tempNumber /= 10
            }
            sum = tempSum
        }
        return sum
    }

}