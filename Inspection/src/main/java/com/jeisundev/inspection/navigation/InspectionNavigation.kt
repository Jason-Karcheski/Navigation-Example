package com.jeisundev.inspection.navigation

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

inline infix fun <reified T: Any> NavGraphBuilder.inspectionGraph(controller: NavHostController) {
    navigation<T>(startDestination = InspectionDestination.TabA) {
        composable<InspectionDestination.TabA> {
            Text("Tab A")
        }
    }
}