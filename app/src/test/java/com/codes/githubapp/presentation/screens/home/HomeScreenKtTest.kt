package com.codes.githubapp.presentation.screens.home

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.codes.githubapp.presentation.ui.theme.GithubAppTheme
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog
import java.io.IOException
import kotlin.jvm.Throws


@RunWith(RobolectricTestRunner::class)
class HomeScreenKtTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `test if btn is displayed`() {
        composeRule.setContent {
            GithubAppTheme {
                HomeScreen()
            }
        }
        composeRule.onNodeWithTag("first button").assertExists()
        composeRule.onNodeWithTag("first button").performClick()
    }

}