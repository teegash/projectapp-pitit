package com.nate.pitit.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nate.pitit.ui.theme.screens.add.Add
import com.nate.pitit.ui.theme.screens.settings.Categories
import com.nate.pitit.ui.theme.screens.expenses.Expenses
import com.nate.pitit.ui.theme.screens.reports.Reports
import com.nate.pitit.ui.theme.screens.settings.Settings
import com.nate.pitit.ui.theme.screens.home.Home
import com.nate.pitit.ui.theme.screens.profile.Profile
import com.nate.pitit.ui.theme.screens.profile.SplashScreen


@Composable
fun AppNavHost(modifier: Modifier=Modifier, navController: NavHostController = rememberNavController(),
               startDestination:String= ROUTE_SPLASH_SCREEN
) {

NavHost(
navController = navController, modifier = modifier,
startDestination = startDestination
) {
    composable(ROUTE_EXPENSES) {
            Expenses(navController)
    }
    composable(ROUTE_REPORTS) {
            Reports()
    }
    composable(ROUTE_ADD) {
            Add(navController)
    }
    composable(ROUTE_SETTINGS) {
            Settings(navController)
    }
    composable(ROUTE_CATEGORIES) {
            Categories(navController)
    }
    composable(ROUTE_SPLASH_SCREEN) {
            SplashScreen(navController)
    }
    composable(ROUTE_PROFILEPAGE){
            Profile(navController)
    }
    composable(ROUTE_PROFILEPAGE){
            Home(navController, Uri.parse("uri"))
    }
}
}
