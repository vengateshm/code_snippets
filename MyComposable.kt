package com.vengateshm.android.jetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview

data class Course(val name: String, val tags: List<String>)

const val TEST_TAG_TAGS = "test_tag_tags"

@Composable
fun CourseNameTag(course: Course) {
    Column(modifier = Modifier.background(Color.White)) {
        Text(text = course.name)
        Row(modifier = Modifier.testTag(TEST_TAG_TAGS)) {
            course.tags.forEach { tag ->
                Text(text = "#$tag", color = Color.Blue)
            }
        }
    }
}

@Preview
@Composable
fun CourseNameTagPreview() {
    val course = Course("Microservices", listOf("springboot", "hysterisis", "modular", "cloud"))
    CourseNameTag(course = course)
}