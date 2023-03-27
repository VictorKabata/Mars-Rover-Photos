package com.vickbt.marsrover.utils

import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ExtensionsTest {

    @Test
    fun `toDateFormat returns correct date on valid date string`() = runTest {
        val networkDate = "1960-11-19"
        val expectedDate = "19 Nov, 1960"

        assertEquals(expected = expectedDate, actual = networkDate.toDateFormat())
    }

    @Test
    fun `toDateFormat returns same string on invalid date string`() = runTest {
        val networkDate = "11-19-1960"

        assertEquals(expected = networkDate, actual = networkDate.toDateFormat())
    }

    @Test
    fun `toDateFormat returns null on null date string`() = runTest {
        val networkDate: String? = null

        assertEquals(expected = null, actual = networkDate.toDateFormat())
    }

    @Test
    fun `capitalizeEachWord capitalizes string value correctly`() = runTest {
        val networkData = "rover statusIs activE"
        val expectedData = "Rover Statusis Active"

        assertEquals(expected = expectedData, actual = networkData.capitalizeEachWord())
    }

    @Test
    fun `capitalizeEachWord returns null on null string value`() = runTest {
        val networkData: String? = null

        assertEquals(expected = null, actual = networkData.capitalizeEachWord())
    }
}
