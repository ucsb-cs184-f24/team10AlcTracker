package com.example.bactrack

import org.junit.Test
import org.junit.Rule
import org.junit.Before
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performClick
import org.junit.After
import java.util.concurrent.TimeUnit

class HealthInfoSectionTest {
    private val originalMainUser = PersonManager.mainUser

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        // Reset PersonManager state before each test
        PersonManager.mainUser.name = "John Doe" // Default name
        PersonManager.mainUser.weight = 70.0 // Default weight
    }

    @After
    fun tearDown() {
        PersonManager.mainUser.name = "John Doe" // Default name
        PersonManager.mainUser.weight = 70.0 // Default weight
    } // Teardown code that runs after each test


        @Test
        fun validWeightIsSavedToPersonManager() {
            // Check initial weight in PersonManager
            TimeUnit.SECONDS.sleep(15)
            composeTestRule.setContent {
                HealthInfoSection()
            }
            assert(PersonManager.mainUser.weight == 70.0) // Assume default weight is 0.0

            // Enter valid weight
            composeTestRule.onNodeWithText("Enter your weight (kg)")
                .performTextInput("100")

            // Click Save
            composeTestRule.onNodeWithText("Save")
                .performClick()

            // Assert the weight is updated in PersonManager
            assert(PersonManager.mainUser.weight == 85.0) {
                "Expected weight to be 85.0, but got ${PersonManager.mainUser.weight}"
            }
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
        fun zzzweightCanBeDeletedAndRetyped() {
            composeTestRule.setContent {
                HealthInfoSection()
            }

            // Assert weight in PersonManager
            assert(PersonManager.mainUser.weight == 70.0) {
                "Expected weight to be 70.0, but got ${PersonManager.mainUser.weight}"
            }

            // Delete the weight
            composeTestRule.onNodeWithText("Enter your weight (kg)")
                .performTextInput("")

            composeTestRule.onNodeWithText("Save")
                .performClick()

            // Assert weight is  not cleared in PersonManager
            assert(PersonManager.mainUser.weight == 70.0) {
                "Expected weight to be 70.0, but got ${PersonManager.mainUser.weight}"
            }

            // Retype weight
            composeTestRule.onNodeWithText("Enter your weight (kg)")
                .performTextInput("85")

            composeTestRule.onNodeWithText("Save")
                .performClick()

            // Assert updated weight in PersonManager
            assert(PersonManager.mainUser.weight == 85.0) {
                "Expected weight to be 85.0, but got ${PersonManager.mainUser.weight}"
            }
        }
    }

//    @Test
//    fun validNameIsSavedToPersonManager() {
//        composeTestRule.setContent {
//            HealthInfoSection()
//        }
//
//        // Enter a valid name
//        composeTestRule.onNodeWithText("Name")
//            .performTextInput("Alice")
//
////        // Click Save
////        composeTestRule.onNodeWithText("Save")
////            .performClick()
////
////        // Assert that the name is updated in PersonManager
////        assert(PersonManager.mainUser.name == "Alice")
//    }

//}

