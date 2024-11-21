package com.example.bactrack.uiScreens

import android.util.Log
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.bactrack.PersonManager
import com.example.bactrack.PersonalInformationSection
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PersonalInformationSectionTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        // Reset PersonManager's name before each test
        PersonManager.mainUser.name = "John Doe" // Default name
        PersonManager.mainUser.email = "abc@gmail.com" // Default email
        PersonManager.mainUser.phoneNumber = 8051112222 // Default phone number
        PersonManager.mainUser.emergencyContactNum = 8058001234 // Default emergency contact
    }


    @Test
    fun validNameIsSavedToPersonManager() {
        composeTestRule.setContent {
            PersonalInformationSection()
        }
        assert(PersonManager.mainUser.name == "John Doe")
        // Backspace to clear the current name (default "John Doe")
        composeTestRule.onNodeWithText("Name") // Locate the "Name" field
            .performTextClearance()

        // Enter a valid new name
        composeTestRule.onNodeWithText("Name")
            .performTextInput("Alice")

        // Assert that the new name is updated in PersonManager
        assert(PersonManager.mainUser.name == "Alice")
    }

    @Test
    fun longNameIsTruncatedToTwentyCharacters() {
        composeTestRule.setContent {
            PersonalInformationSection()
        }

        composeTestRule.onNodeWithText("Name") // Locate the "Name" field
            .performTextClearance()

        composeTestRule.onNodeWithText("Name")
            .performTextInput("T")

        composeTestRule.onNodeWithText("Name")
            .performTextInput("h")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("i")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("s")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("I")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("s")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("A")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("N")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("a")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("m")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("e")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("T")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("h")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("a")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("t")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("I")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("s")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("T")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("o")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("o")
        composeTestRule.onNodeWithText("Name")
            .performTextInput("L")


        // Assert with a custom error message
        val actualName = PersonManager.mainUser.name
        val expectedName = "ThisIsANameThatIsToo"
        assert(actualName == expectedName) {
            "Test failed: Expected name to be '$expectedName', but was '$actualName'"
        }
    }
    //No need to test birthdate since the repo will handle that for us!
    @Test
    fun validEmailIsSavedToPersonManager() {
        composeTestRule.setContent {
            PersonalInformationSection()
        }

        composeTestRule.onNodeWithText("Email")
            .performTextClearance()

        // Enter a valid email
        val validEmail = "test@example.com"
        composeTestRule.onNodeWithText("Email")
            .performTextInput(validEmail)

        // Assert that the valid email is saved in PersonManager
        assert(PersonManager.mainUser.email == validEmail) {
            "Test failed: Expected email to be '$validEmail', but was '${PersonManager.mainUser.email}'"
        }
    }


    @Test
    fun invalidEmailDoesNotUpdatePersonManager() {
        composeTestRule.setContent {
            PersonalInformationSection()
        }

        // Clear the current email
        composeTestRule.onNodeWithText("Email")
            .performTextClearance()

        // Enter an invalid email (missing '@')
        val invalidEmail = "testexample.com"
        composeTestRule.onNodeWithText("Email")
            .performTextInput(invalidEmail)

        // Print the current value in PersonManager for debugging
        println("PersonManager.mainUser.email = ${PersonManager.mainUser.email}")

        // Assert that PersonManager's email was not modified becauee it was invalid
        assert(PersonManager.mainUser.email == "abc@gmail.com") {
            "Test failed: Invalid email '$invalidEmail' should not have been saved, but was '${PersonManager.mainUser.email}'"
        }
    }

    @Test
    fun validPhoneNumberIsSavedToPersonManager() {
        composeTestRule.setContent {
            PersonalInformationSection()
        }
        assert(PersonManager.mainUser.phoneNumber == 8051112222)
        // Enter a valid phone number

        //clear the text field
        composeTestRule.onNodeWithText("Phone Number")
            .performTextClearance()

        val validPhoneNumber = "1234567890"
        composeTestRule.onNodeWithText("Phone Number")
            .performTextInput(validPhoneNumber)

        // Assert that the valid phone number is saved in PersonManager
        assert(PersonManager.mainUser.phoneNumber == 1234567890L) {
            "Test failed: Expected phone number to be '1234567890', but was '${PersonManager.mainUser.phoneNumber}'"
        }
    }

    @Test
    fun invalidPhoneNumberDoesNotUpdatePersonManager() {
        composeTestRule.setContent {
            PersonalInformationSection()
        }

        composeTestRule.onNodeWithText("Phone Number")
            .performTextClearance()

        // Enter an invalid phone number (less than 10 digits)
        val invalidPhoneNumber = "123456"
        composeTestRule.onNodeWithText("Phone Number")
            .performTextInput(invalidPhoneNumber)

        // Assert that the invalid phone number is not saved in PersonManager
        assert(PersonManager.mainUser.phoneNumber == 8051112222) {
            "Test failed: Invalid phone number '$invalidPhoneNumber' should not have been saved, but was '${PersonManager.mainUser.phoneNumber}'"
        }
    }

    @Test
    fun validEmergencyContactNumIsSavedToPersonManager() {
        composeTestRule.setContent {
            PersonalInformationSection()
        }
        assert(PersonManager.mainUser.emergencyContactNum == 8058001234)
        // Enter a valid phone number

        //clear the text field
        composeTestRule.onNodeWithText("Emergency Contact")
            .performTextClearance()

        val validPhoneNumber = "8053412702"
        composeTestRule.onNodeWithText("Emergency Contact")
            .performTextInput(validPhoneNumber)

        // Assert that the valid phone number is saved in PersonManager
        assert(PersonManager.mainUser.emergencyContactNum == 8053412702) {
            "Test failed: Expected phone number to be '8053412702', but was '${PersonManager.mainUser.emergencyContactNum}'"
        }
    }

    @Test
    fun invalidEmergencyContactNumberDoesNotUpdatePersonManager() {
        composeTestRule.setContent {
            PersonalInformationSection()
        }

        composeTestRule.onNodeWithText("Emergency Contact")
            .performTextClearance()

        // Enter an invalid phone number (less than 10 digits)
        val invalidPhoneNumber = "123456"
        composeTestRule.onNodeWithText("Emergency Contact")
            .performTextInput(invalidPhoneNumber)

        // Assert that the invalid phone number is not saved in PersonManager
        assert(PersonManager.mainUser.emergencyContactNum == 8058001234) {
            "Test failed: Invalid phone number '$invalidPhoneNumber' should not have been saved, but was '${PersonManager.mainUser.phoneNumber}'"
        }
    }

}