package com.jeisundev.navigationexample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jeisundev.assetverification.navigation.AssetVerificationDestination
import com.jeisundev.assetverification.navigation.assetVerificationGraph
import com.jeisundev.inspection.navigation.inspectionGraph
import kotlinx.serialization.Serializable

/**
 * The apps only [NavHost]. Contains top-level navigation logic for the application.
 */
@Composable
internal fun AppNavHost(
    modifier: Modifier = Modifier,
    controller: NavHostController
) {
    NavHost(
        modifier = modifier,
        startDestination = AppDestination.AssetVerification,
        navController = controller
    ) {
        assetVerificationGraph<AppDestination.AssetVerification>(controller = controller)
        inspectionGraph<AppDestination.Inspection>(controller = controller)
    }
}

sealed interface AppDestination {
    @Serializable data object AssetVerification : AppDestination
    @Serializable data object Inspection : AppDestination
}