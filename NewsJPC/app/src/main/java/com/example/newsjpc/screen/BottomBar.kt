package com.example.newsjpc.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBar(val route:String,val name:String,val imageVector: ImageVector){
    object Home:BottomBar("home","Home", Icons.Default.Home)
    object Interest:BottomBar("interest","Interest",Icons.Default.Info)
}
