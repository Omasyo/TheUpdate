package com.keetr.theupdate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.keetr.theupdate.ui.TheUpdateApp
import com.keetr.theupdate.ui.theme.TheUpdateTheme

@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheUpdateTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    val viewModel: HomeViewModel = viewModel()
//                    val selectedArticleState = viewModel.selectedArticle.collectAsState().value
//                }
                TheUpdateApp()
            }
        }
    }
}