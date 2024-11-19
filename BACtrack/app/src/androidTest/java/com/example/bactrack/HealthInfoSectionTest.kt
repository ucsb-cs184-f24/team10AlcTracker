package com.example.bactrack

import org.junit.Test
import org.junit.Rule


import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performClick

//import person mannager
//import landing.kt


class HealthInfoSectionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun validWeightIsSavedToPersonManager() {
        // Check initial weight in PersonManager
        assert(PersonManager.mainUser.weight == 70.0) // Assume default weight is 0.0

        composeTestRule.setContent {
            HealthInfoSection()
        }

        // Enter valid weight
        composeTestRule.onNodeWithText("Enter your weight (kg)")
            .performTextInput("100")

        // Click Save
        composeTestRule.onNodeWithText("Save")
            .performClick()

        // Assert the weight is updated in PersonManager
        assert(PersonManager.mainUser.weight == 100.0)
    }

    @Test
    fun invalidWeightIsNotSaved() {
        // Check initial weight in PersonManager
        assert(PersonManager.mainUser.weight == 70.0) // Assume default weight is 0.0

        composeTestRule.setContent {
            HealthInfoSection()
        }

        // Enter invalid weight (e.g., 600)
        composeTestRule.onNodeWithText("Enter your weight (kg)")
            .performTextInput("600")

        // Click Save
        composeTestRule.onNodeWithText("Save")
            .performClick()

        // Assert the weight in PersonManager has not changed
        assert(PersonManager.mainUser.weight == 70.0) // Weight remains the default
    }

    @Test
    fun weightCanBeDeletedAndRetyped() {
        composeTestRule.setContent {
            HealthInfoSection()
        }

        // Assert weight in PersonManager
        assert(PersonManager.mainUser.weight == 70.0)

        // Delete the weight
        composeTestRule.onNodeWithText("Enter your weight (kg)")
            .performTextInput("")

        composeTestRule.onNodeWithText("Save")
            .performClick()

        // Assert weight is  not cleared in PersonManager
        assert(PersonManager.mainUser.weight == 10.0)

        // Retype weight
        composeTestRule.onNodeWithText("Enter your weight (kg)")
            .performTextInput("85")

        composeTestRule.onNodeWithText("Save")
            .performClick()

        // Assert updated weight in PersonManager
        assert(PersonManager.mainUser.weight == 85.0)
    }
}
