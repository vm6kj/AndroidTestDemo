package com.kun.androidtestdemo

import android.content.Intent.getIntent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EspressoTest {

    @Rule
    @JvmField
    val loginActivityRule = ActivityTestRule(LoginActivity::class.java)
//    val loginActivityTest = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun loginThenLogoutTest() {
        onView(withId(R.id.ed_account)).check(matches((isEnabled())))
        onView(withId(R.id.ed_password)).check(matches((isEnabled())))

        onView(withId(R.id.ed_account)).perform(replaceText("kc_hsu@htc.com"))
        onView(withId(R.id.ed_password)).perform(typeText("123456"))
        onView(withId(R.id.btn_login)).perform(click())

        onView(withId(R.id.btn_logout)).perform(click())
        onView(withText("OK")).inRoot(isDialog()).perform(click())
    }
}