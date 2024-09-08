package com.jeisundev.navigationexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jeisundev.assetverification.navigation.AssetVerificationDestination
import com.jeisundev.navigationexample.ui.composable.AppBottomBar
import com.jeisundev.navigationexample.ui.composable.AppTopBar
import com.jeisundev.navigationexample.ui.composable.BottomBarItem
import com.jeisundev.navigationexample.ui.navigation.AppNavHost
import com.jeisundev.navigationexample.ui.theme.NavigationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NavigationExampleTheme {
                val navigationController: NavHostController = rememberNavController()
                val currentBackStackEntry by navigationController.currentBackStackEntryAsState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        AppTopBar(currentBackStackEntry = currentBackStackEntry)
                    },
                    bottomBar = {
                        AppBottomBar { item ->
                            navigationController.navigateToBottomBarDestination(item)
                        }
                    }
                ) { innerPadding ->
                    AppNavHost(
                        modifier = Modifier.padding(innerPadding),
                        controller = navigationController
                    )
                }
            }
        }
    }

    private fun NavHostController.navigateToBottomBarDestination(item: BottomBarItem) {
        val destination = when (item) {
            is BottomBarItem.Audit -> AssetVerificationDestination.Audit
            is BottomBarItem.Rectify -> AssetVerificationDestination.Rectify
            is BottomBarItem.Tags -> AssetVerificationDestination.Tags
            is BottomBarItem.Support -> AssetVerificationDestination.Support
        }

        this.run {
            popBackStack()
            navigate(destination)
        }
    }
}