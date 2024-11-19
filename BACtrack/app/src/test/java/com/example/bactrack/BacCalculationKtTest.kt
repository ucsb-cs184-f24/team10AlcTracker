package com.example.bactrack

import org.junit.jupiter.api.Assertions.*

import org.junit.Test

class BACCalculationTest {

    // Test cases for male
    @Test
    fun testCalculateBAC_male() {
        val totalAlcoholConsumed = 10000.0
        val weight = 60.0
        val sex = "male"
        val time = 0.0

        val bac = calculateBAC(totalAlcoholConsumed, weight, sex, time)
        // Check if BAC is calculated correctly for male
        println("Calculated BAC: $bac")
        assertTrue(bac > 0.245 && bac < 0.246)
    }

    // Test cases for female
    @Test
    fun testCalculateBAC_female() {
        val totalAlcoholConsumed = 10000.0
        val weight = 60.0
        val sex = "female"
        val time = 0.0

        val bac = calculateBAC(totalAlcoholConsumed, weight, sex, time)
        // Check if BAC is calculated correctly for female
        println("Calculated BAC: $bac")

        assertTrue(bac > 0.3 && bac < 0.305)
    }

    // Test cases for zero or negative BAC
    @Test
    fun testCalculateBAC_zeroOrNegative() {
        val totalAlcoholConsumed = 0.0  // 0 grams of alcohol
        val weight = 70.0  // 70 kg
        val sex = "male"
        val time = 5.0  // 5 hours after drinking

        val bac = calculateBAC(totalAlcoholConsumed, weight, sex, time)
        // Ensure BAC does not go below 0
        assertEquals(0.0, bac, 0.0)
    }

    // Test edge case for a high BAC
    @Test
    fun testCalculateBAC_highBAC() {
        val totalAlcoholConsumed = 2000000000000.0  // 200 grams of alcohol
        val weight = 70.0  // 70 kg
        val sex = "female"
        val time = 0.0  // No time passed since drinking

        val bac = calculateBAC(totalAlcoholConsumed, weight, sex, time)

        assertTrue(bac > 0) // no overflow
    }
}
