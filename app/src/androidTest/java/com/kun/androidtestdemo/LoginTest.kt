package com.kun.androidtestdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTest {

    @Rule
    @JvmField
    val loginActivityRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun checkEditTextStateChange() {
        onView(withId(R.id.ed_account)).check(matches((isEnabled())))
        onView(withId(R.id.ed_password)).check(matches((isEnabled())))

        onView(withId(R.id.ed_account)).perform(typeText("kc_hsu@htc.com"))
        onView(withId(R.id.ed_password)).perform(typeText("123456"))
        onView(withId(R.id.btn_login)).perform(click())

        onView(withId(R.id.btn_logout)).perform(click())
        onView(withText("OK")).inRoot(isDialog()).perform(click())
    }
}