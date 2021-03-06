package com.kun.androidtestdemo

import android.content.Context
import java.util.regex.Matcher
import java.util.regex.Pattern

object Utils {
    fun isEmailValid(email: String): Boolean {
        val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun getFakeString(context: Context): String {
        return context.getString(R.string.fake_string)
    }
}