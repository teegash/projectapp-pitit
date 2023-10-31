package com.nikolovlazar.goodbyemoney.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nikolovlazar.goodbyemoney.pages.Add
import com.nikolovlazar.goodbyemoney.pages.Categories
import com.nikolovlazar.goodbyemoney.pages.Expenses
import com.nikolovlazar.goodbyemoney.pages.Reports
import com.nikolovlazar.goodbyemoney.pages.Settings
import com.nikolovlazar.goodbyemoney.ui.theme.screens.home.Home
import com.nikolovlazar.goodbyemoney.ui.theme.screens.profile.Profile
import com.nikolovlazar.goodbyemoney.ui.theme.screens.profile.SplashScreen


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
            Home(navController)
    }
}
}
