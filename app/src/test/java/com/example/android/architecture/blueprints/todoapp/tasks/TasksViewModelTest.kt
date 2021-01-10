package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.nullValue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun addNewTask_setsNewTaskEvent() {
        val taskViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())

        taskViewModel.addNewTask()
        val value = taskViewModel.newTaskEvent.getOrAwaitValue()
        assertThat(value.getContentIfNotHandled(), not(nullValue()))
    }
}
