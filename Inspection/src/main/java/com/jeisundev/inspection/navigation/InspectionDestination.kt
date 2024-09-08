package com.jeisundev.inspection.navigation

import kotlinx.serialization.Serializable

sealed interface InspectionDestination {
    @Serializable data object TabA : InspectionDestination
}