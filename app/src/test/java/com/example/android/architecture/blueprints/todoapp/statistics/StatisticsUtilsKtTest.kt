package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.Assert.assertEquals
import org.junit.Test

class StatisticsUtilsKtTest {

    @Test
    fun getActiveCompletedTest_noCompleted_returnsHundredZero() {
        val tasks = listOf<Task>(
            Task(title = "", description = "", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks = tasks)
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 100f)
    }

    @Test
    fun getActiveCompleteStats_empty_returnsZero() {
        val tasks = listOf<Task>()

        val result = getActiveAndCompletedStats(tasks = tasks)
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 0f)
    }

    @Test
    fun getActiveCompletedStats_null_returnsZero() {
        val tasks = null

        val result = getActiveAndCompletedStats(tasks = tasks)
        assertEquals(result.activeTasksPercent, 0f)
        assertEquals(result.completedTasksPercent, 0f)
    }

    @Test
    fun getActiveCompletedStats_both_returns_forthy_sixty() {
        val tasks = listOf(
            Task(title = "", description = "", isCompleted = false),
            Task(title = "", description = "", isCompleted = false),
            Task(title = "", description = "", isCompleted = true),
            Task(title = "", description = "", isCompleted = true),
            Task(title = "", description = "", isCompleted = true)
        )
        val result = getActiveAndCompletedStats(tasks = tasks)
        assertEquals(result.completedTasksPercent, 60f)
        assertEquals(result.activeTasksPercent, 40f)
    }
}
