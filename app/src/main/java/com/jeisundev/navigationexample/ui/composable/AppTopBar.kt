package com.jeisundev.navigationexample.ui.composable

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import com.jeisundev.assetverification.navigation.AssetVerificationDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(currentBackStackEntry: NavBackStackEntry?) {
    val config = currentBackStackEntry?.destination?.getTopBarConfig()

    config?.let { (label, actions) ->
        TopAppBar(
            title = { Text(label) },
            actions = {
                actions?.forEach { Text(it) }
            }
        )
    }
}


sealed class TopBarConfig(private val title: String, private val actions: List<String>? = null) {
    operator fun component1(): String = title
    operator fun component2(): List<String>? = actions

    data object Audit : TopBarConfig(title = "Audit")
    data object Rectify : TopBarConfig(title = "Rectify")
    data object Tags : TopBarConfig(title = "Tags")
    data object Support : TopBarConfig(title = "Support")
}

private fun NavDestination.getTopBarConfig() : TopBarConfig? = when {
    this.hasRoute<AssetVerificationDestination.Audit>() -> TopBarConfig.Audit
    this.hasRoute<AssetVerificationDestination.Rectify>() -> TopBarConfig.Rectify
    this.hasRoute<AssetVerificationDestination.Tags>() -> TopBarConfig.Tags
    this.hasRoute<AssetVerificationDestination.Support>() -> TopBarConfig.Support
    else -> null
}