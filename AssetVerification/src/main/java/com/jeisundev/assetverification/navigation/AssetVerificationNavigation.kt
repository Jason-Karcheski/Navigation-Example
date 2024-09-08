package com.jeisundev.assetverification.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

inline fun <reified T: Any> NavGraphBuilder.assetVerificationGraph(controller: NavHostController) {
    navigation<T>(startDestination = AssetVerificationDestination.Audit) {
        composable<AssetVerificationDestination.Audit> {
            Text("Audit Screen")
        }
        composable<AssetVerificationDestination.Rectify> {
            Text("Rectify Screen")
        }
        composable<AssetVerificationDestination.Tags> {
            Text("Tags Screen")
        }
        composable<AssetVerificationDestination.Support> {
            Text("Support Screen")
        }
    }
}