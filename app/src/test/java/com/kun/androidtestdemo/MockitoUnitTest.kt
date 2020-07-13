package com.kun.androidtestdemo

import android.content.Context
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

private const val FAKE_STRING = "Fake string for test"

@RunWith(MockitoJUnitRunner::class)
class MockitoUnitTest {

    @Mock
    private lateinit var mockContext: Context

    @Test
    fun mockitoGetFakeStringTest() {
        `when`(mockContext.getString(R.string.fake_string)).thenReturn(FAKE_STRING)

        val result: String = Utils.getFakeString(mockContext)

        // Hamcrest assertion framework (http://hamcrest.org/)
        assertThat(result, `is`(FAKE_STRING))
    }
}