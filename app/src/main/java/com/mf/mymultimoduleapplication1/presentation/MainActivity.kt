package com.mf.mymultimoduleapplication1.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mf.mymultimoduleapplication1.presentation.screens.SelectionScreen
import com.mf.mymultimoduleapplication1.presentation.view_models.SelectionSearchScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.mf.mymultimoduleapplication1.presentation.models.IUiState
import com.mf.mymultimoduleapplication1.presentation.theme.MyMultiModuleApp1Theme
import dagger.Provides


@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyMultiModuleApp1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavHost(innerPadding)
                }
            }
        }
    }
}