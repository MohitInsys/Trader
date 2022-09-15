package com.example.newsjpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newsjpc.screen.BottomBar
import com.example.newsjpc.screen.Home
import com.example.newsjpc.screen.Interest
import com.example.newsjpc.ui.theme.NewsJPCTheme
import com.example.newsjpc.ui.theme.Pink

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsJPCTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    com.example.newsjpc.Navigation()
                }
            }
        }
    }
}
@Composable
fun NavigationController(navController:NavHostController){
    NavHost(navController = navController, startDestination = BottomBar.Home.route){
        composable(BottomBar.Home.route){
            Home()
        }
        composable(BottomBar.Interest.route){
            Interest()
        }


    }

}
@Composable
fun Navigation(){
    val navController = rememberNavController()
    val items= listOf(BottomBar.Home,BottomBar.Interest)
    Scaffold(bottomBar = { BottomNavigation(backgroundColor = Color.White) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute=navBackStackEntry?.destination?.route
        items.forEach{
                BottomNavigationItem(selected = currentRoute==it.route,
                    label = { Text(text = it.name,
                    color=if(currentRoute==it.route) Color.Black else Color.Gray)},
                    icon = { Icon(tint = if(currentRoute==it.route) Pink else Color.Gray,
                        imageVector = it.imageVector, contentDescription =null )}
                    , onClick = {
                        if(currentRoute!=it.route){
                            navController.graph?.startDestinationRoute?.let {
                                navController.popBackStack(it,true)
                            }
                            navController.navigate(it.route){
                                launchSingleTop=true
                            }
                        }
                    })
        }
        
    }}) {
        NavigationController(navController = navController)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsJPCTheme {
        Navigation()
    }
}