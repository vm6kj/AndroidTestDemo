package com.kun.androidtestdemo

import android.content.Context
import android.os.Build
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

private const val FAKE_STRING = "Fake string for test"
private const val LOGIN_SUCCESSFULLY_STRING = "Login successfully!"

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class RobolectricUnitTest {

    @Test
    fun robolectricGetFakeStringTest() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = Utils.getFakeString(context)
        // Truth library (https://truth.dev/)
        assertThat(result).isEqualTo(FAKE_STRING)

        val homeActivity = ActivityScenario.launch(HomeActivity::class.java)
        homeActivity.onActivity {
            assertThat(it.txtLoginNotify.text).isEqualTo(LOGIN_SUCCESSFULLY_STRING)
        }

        /** Robolectric allows the tests run outside of the emulator by simulating Android environment
         * as shown in the following.
        val yourService = Robolectric.setupService(YourServiceClass::class.java)
        val yourContentProvider = Robolectric.setupContentProvider(YourContentProviderClass::class.java)
        ...
         */
    }
}