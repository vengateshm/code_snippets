package com.vengateshm.android.jetpackcompose

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CourseNameTagTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testAreCourseNameAndTagsDisplayed() {
        val course = Course("Microservices", listOf("springboot", "hysterisis", "modular", "cloud"))
        composeTestRule.setContent {
            CourseNameTag(course = course)
        }

        composeTestRule.onNodeWithText("Microservices")
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(TEST_TAG_TAGS)
            .assertIsDisplayed()
    }

    @Test
    fun testIfTagsAreEmpty() {
        val course = Course("Microservices", emptyList())
        composeTestRule.setContent {
            CourseNameTag(course = course)
        }

        composeTestRule.onNodeWithText("Microservices")
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(TEST_TAG_TAGS)
            .assertIsNotDisplayed()
    }

    @Test
    fun testTagCount() {
        val course = Course("Microservices", listOf("springboot", "hysterisis", "modular", "cloud"))
        composeTestRule.setContent {
            CourseNameTag(course = course)
        }

        composeTestRule.onNodeWithText("Microservices")
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(TEST_TAG_TAGS)
            .assertIsDisplayed()
            .onChildren()
            .assertCountEquals(4)
    }

    @Test
    fun testFirstAndLastTagText() {
        val course = Course("Microservices", listOf("firstTag", "hysterisis", "modular", "lastTag"))
        composeTestRule.setContent {
            CourseNameTag(course = course)
        }

        composeTestRule.onNodeWithText("Microservices")
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(TEST_TAG_TAGS)
            .assertIsDisplayed()
            .onChildren()
            .onFirst()
            .assert(hasText("#firstTag"))

        composeTestRule.onNodeWithText("Microservices")
            .assertIsDisplayed()
        composeTestRule.onNodeWithTag(TEST_TAG_TAGS)
            .assertIsDisplayed()
            .onChildren()
            .onLast()
            .assert(hasText("#lastTag"))
    }
}