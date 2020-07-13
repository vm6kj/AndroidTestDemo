package com.kun.androidtestdemo

import android.content.Context
import android.os.Build
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.content.pm.ApplicationInfoBuilder
import androidx.test.core.content.pm.PackageInfoBuilder
import androidx.test.core.view.MotionEventBuilder
import androidx.test.core.view.PointerCoordsBuilder
import androidx.test.core.view.PointerPropertiesBuilder
import com.google.common.truth.Truth.assertThat
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

private const val FAKE_STRING = "Fake string for test"

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
class RobolectricUnitTest {

    @Test
    fun robolectricGetFakeStringTest() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = Utils.getFakeString(context)
        // Truth library (https://truth.dev/)
        assertThat(result).isEqualTo(FAKE_STRING)

//        val w = ApplicationInfoBuilder.newBuilder().build()
//        val c = ApplicationProvider.getApplicationContext<Context>()
//
//        val s = MotionEventBuilder.newBuilder().build()
//        val z = PointerCoordsBuilder.newBuilder().build()
//        val q = PointerPropertiesBuilder.newBuilder().build()
//
//        val a = PackageInfoBuilder.newBuilder().build()
    }
}