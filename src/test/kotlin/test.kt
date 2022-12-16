package main

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertThrows
//import kotlin.math.abs

class Test {
    /*private fun approxEquals(expected: Double, actual: Double, delta: Double): Boolean =
        abs(expected - actual) <= delta

    private fun assertApproxEquals(expected: Double, actual: Double, delta: Double = Math.ulp(10.0)) {
        assertTrue(approxEquals(expected, actual, delta))
    }*/

    /*assertThrows(IllegalArgumentException::class.java) {
        myFun()
    }*/
    @Test
    fun theater() {

        val places1 =
            mutableListOf(
                mutableListOf(true, false, false, false, true, false),
                mutableListOf(true, false, true, false)
            )
        val requests1 = mapOf("Вася" to Pair(0, 2), "Петя" to Pair(1, 1))
        assertEquals(mapOf("Вася" to listOf(1, 2), "Петя" to listOf(1)), theater(places1, requests1))

        val places2 =
            mutableListOf(
                mutableListOf(true, true, true, true, false, false),
                mutableListOf(true, true, true, false)
            )
        val requests2 = mapOf("Вася" to Pair(0, 2), "Петя" to Pair(1, 1))
        assertEquals(mapOf("Вася" to listOf(4, 5), "Петя" to listOf(3)), theater(places2, requests2))

        val places3 =
            mutableListOf(
                mutableListOf(true, false, true, false, false, false),
                mutableListOf(true, true, true, false),
                mutableListOf(false, false, false, false)
            )
        val requests3 = mapOf("Вася" to Pair(0, 2), "Петя" to Pair(1, 1), "Банда Мышей" to Pair(2, 10))
        //assertEquals(mapOf("Вася" to listOf(4, 5), "Петя" to listOf(3)), theater(places3, requests3))
        assertThrows(IllegalStateException::class.java) {
            theater(places3, requests3)
        }
        val places4 =
            mutableListOf(
                mutableListOf(false, false, false, false, false, false, false),
                mutableListOf(false, false, false, false, false, false, false),
                mutableListOf(false, false, false, false, false, false, false)
            )
        val requests4 = mapOf("Вася" to Pair(0, 6), "Петя" to Pair(0, 1), "Банда Мышей" to Pair(2, 7))
        assertEquals(
            mapOf(
                "Вася" to listOf(0, 1, 2, 3, 4, 5),
                "Петя" to listOf(6),
                "Банда Мышей" to listOf(0, 1, 2, 3, 4, 5, 6)
            ),
            theater(places4, requests4)
        )


    }
}