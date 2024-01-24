package com.hasantuncay.composeComponents

import androidx.compose.foundation.text.selection.SelectionContainer

fun main() {
//    print("Lütfen bir sayı girin: ")
//    val input = readLine()
//    if (input != null) {
//        val number = input.toIntOrNull()
//
//        if (number != null) {
//            println("Girdiğiniz sayı: $number")
//        } else {
//            println("Geçersiz bir sayı girdiniz.")
//        }
//    } else {
//        println("Girdi alınamadı.")
//    }
    val shuffledList = SearchAlgorithm().shuffleList(1, 100)
    println("Shuffled List: $shuffledList")
    val sortedList = SearchAlgorithm().sortCustom(shuffledList)
    val sortedList2 = SearchAlgorithm().sortCustom2(shuffledList)
    println("Sorted List: $sortedList")
//    println("Sorted List 2 : $sortedList2")
    val searchresult = SearchAlgorithm().binarySearch(sortedList, 60)
    println("searchresult: $searchresult")
}

class SearchAlgorithm {
    fun binarySearch(list: List<Int>, searchNumber: Int): Int {
        var left = 0
        var right = list.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            println("mid: $mid $right $left")
            when {
                list[mid] == searchNumber -> return mid
                list[mid] < searchNumber -> left = mid
                else -> right = mid
            }
        }

        return -1 // Aranan sayı bulunamadı
    }

    fun sortCustom(list: List<Int>): List<Int> {
        val sortedList = mutableListOf<Int>()
        val tempList = list.toMutableList()

        while (tempList.isNotEmpty()) {
            var minValue = tempList[0]
            for (value in tempList) {
                if (value < minValue) {
                    minValue = value
                }
            }
            sortedList.add(minValue)
            tempList.remove(minValue)
        }

        return sortedList
    }

    fun sortCustom2(list: List<Int>): List<Int> {
        val sortedList = mutableListOf<Int>()
        val tempList = list.toMutableList()

        for (i in list) {
            var minvalue = i
            //   println("Sorted value out  : $i")
            for (value in tempList) {
                if (value < minvalue) {
                    minvalue = value

                    //println("Sorted value   : $minvalue")
                }
            }
            sortedList.add(minvalue)
            tempList.remove(minvalue)
//            println(
//                "Sorted tempList   : ${
//                    tempList.remove(minvalue)
//                } "
//            )
//            println(
//                "Sorted tempList   : ${
//                    tempList
//                } "
//            )

//            val minValue = tempList[minValueIndex]
//            tempList[minValueIndex] = tempList[i]
//            tempList[i] = minValue
        }


        return sortedList
    }

    fun shuffleList(start: Int, end: Int): List<Int> {
        val list = (start..end).toList()
        return list.shuffled()
    }


    fun bubbleSort(arr: IntArray) {
        val n = arr.size
        var swapped: Boolean
        do {
            swapped = false
            for (i in 0 until n - 1) {
                if (arr[i] > arr[i + 1]) {
                    // Önceki öğe daha büyükse, yerlerini değiştir
                    val temp = arr[i]
                    arr[i] = arr[i + 1]
                    arr[i + 1] = temp
                    swapped = true
                }
            }
        } while (swapped)
    }

    fun quickSort(arr: IntArray, low: Int, high: Int) {
        if (low < high) {
            val pivotIndex = partition(arr, low, high)
            quickSort(arr, low, pivotIndex - 1)
            quickSort(arr, pivotIndex + 1, high)
        }
    }

    fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high]
        var i = low - 1
        for (j in low until high) {
            if (arr[j] <= pivot) {
                i++
                // Önceki öğe daha küçükse, yerlerini değiştir
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
        val temp = arr[i + 1]
        arr[i + 1] = arr[high]
        arr[high] = temp
        return i + 1
    }

    fun mergeSort(arr: IntArray) {
        if (arr.size > 1) {
            val middle = arr.size / 2
            val left = arr.copyOfRange(0, middle)
            val right = arr.copyOfRange(middle, arr.size)
            mergeSort(left)
            mergeSort(right)
            merge(arr, left, right)
        }
    }

    fun merge(arr: IntArray, left: IntArray, right: IntArray) {
        var i = 0
        var j = 0
        var k = 0
        while (i < left.size && j < right.size) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++]
            } else {
                arr[k++] = right[j++]
            }
        }
        while (i < left.size) {
            arr[k++] = left[i++]
        }
        while (j < right.size) {
            arr[k++] = right[j++]
        }
    }

    fun shufleList(minVal: Int, maxVal: Int): List<Int> {
        val list = (minVal..maxVal).toList()
        return list.shuffled()
    }

    fun main() {
        val list = listOf(1, 2, 3) // Değiştirilemez List
        val mutableList = mutableListOf(1, 2, 3) // Değiştirilebilir MutableList
        val array = arrayOf(1, 2, 3) // Değiştirilebilir Array

        // List'e bir öğe eklemeye çalışalım (hata verecektir)
        // list.add(4) // Hata: "Unresolved reference: add"

        // MutableList'e bir öğe ekleyebiliriz
        mutableList.add(4)
        println("MutableList: $mutableList")

        // Array'e bir öğe ekleyebiliriz
        array[1] = 5
        println("Array: ${array.joinToString()}") // [1, 5, 3]
    }


}