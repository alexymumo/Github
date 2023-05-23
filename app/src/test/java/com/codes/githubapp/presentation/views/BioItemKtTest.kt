package com.codes.githubapp.presentation.views

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.codes.githubapp.presentation.ui.theme.GithubAppTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(RobolectricTestRunner::class)
internal class BioItemKtTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Before
    @Throws(IOException::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `test if bio item is displayed`() {
        composeRule.setContent {
            GithubAppTheme {

            }
        }
        composeRule.onNodeWithTag("bio item").assertIsDisplayed()
        composeRule.onNodeWithTag("bio item").assertExists()

    }



}