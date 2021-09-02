package com.vengateshm.android.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.vengateshm.android.jetpackcompose.ui.theme.JetPackComposeAndroidTheme

const val TASK_LIST_TEST_TAG = "task_list_test_tag"

class TasksActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tasks = listOf(Task("Buy Milk and eggs!"),
            Task("Run 3 miles"),
            Task("Take puppy to clinic"),
            Task("Plan for weekend trip"))

        setContent {
            JetPackComposeAndroidTheme {
                TaskListScreen(tasks)
            }
        }
    }
}

@Composable
fun TaskListScreen(tasks: List<Task>) {
    // A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(modifier = Modifier.testTag(TASK_LIST_TEST_TAG)) {
            items(tasks) { task ->
                Text(text = task.description)
            }
        }
    }
}

data class Task(val description: String)