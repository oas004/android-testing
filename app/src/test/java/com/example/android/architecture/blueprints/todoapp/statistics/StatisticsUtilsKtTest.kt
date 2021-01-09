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
}
