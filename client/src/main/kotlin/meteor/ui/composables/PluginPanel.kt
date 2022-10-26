package meteor.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import meteor.plugins.EventSubscriber
import meteor.ui.composables.preferences.background
import meteor.ui.composables.preferences.darkLightMode
import meteor.ui.composables.preferences.darkThemeColors
import meteor.ui.composables.preferences.lightThemeColors

open class PluginPanel : EventSubscriber() {
    @Composable
    fun CreateComponent() {
        val mod = Modifier.background(background  ).fillMaxHeight()

        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
            Column(modifier = mod) {
                MaterialTheme(colors = if (darkLightMode.value)darkThemeColors else lightThemeColors ) {
                    Header()
                    Content()
                }
            }
        }
    }

    @Composable
    open fun Header() {
    }

    @Composable
    open fun Content() {
    }
}