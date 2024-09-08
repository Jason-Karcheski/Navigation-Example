package com.jeisundev.assetverification.navigation

import kotlinx.serialization.Serializable

/**
 * Represents a navigation route - each screen and nested navigation graph will be represented as a [AssetVerificationDestination].
 */
sealed interface AssetVerificationDestination {
    /**
     * Represents the Audit screen.
     */
    @Serializable
    data object Audit: AssetVerificationDestination

    /**
     * Represents the Rectify screen.
     */
    @Serializable
    data object Rectify: AssetVerificationDestination

    /**
     * Represents the Tags screen.
     */
    @Serializable
    data object Tags: AssetVerificationDestination

    /**
     * Represents the Support screen.
     */
    @Serializable
    data object Support: AssetVerificationDestination
}