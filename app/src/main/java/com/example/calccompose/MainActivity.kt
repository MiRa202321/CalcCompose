package com.example.calccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calccompose.ui.theme.CalcComposeTheme
import com.example.calccompose.ui.theme.MediumGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalcComposeTheme {

                val viewModel= viewModel<CalculatorViewModel>()   //reference to the viewmodel
                val state= viewModel.state                          //reference to the viewmodel
                val buttonSpacing= 8.dp                  //space between buttons

                //for layout, we could have use a box, but here we have made a separate composable

                Calculator(
                    state = state,
                    onAction = viewModel::onAction,
                    buttonSpacing = buttonSpacing,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MediumGray)
                        .padding(32.dp)
                )


            }
        }
    }
}

