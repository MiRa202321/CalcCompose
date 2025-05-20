package com.example.calccompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.calccompose.ui.theme.LightGray
import com.example.calccompose.ui.theme.Orange


@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {
    //we will keep it in a box so as to align with bottom

    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),    //inside the box, hence access to this
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)  // ensures there is 8 dp of space btw columns in vertical direction
        ) {
            Text(
                text = state.num1 + (state.operation?.Symbol ?: "") + state.num2,
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2,
                textAlign = TextAlign.End,          //right aligned
                modifier = Modifier                // to make it fill whole width again
                    .fillMaxWidth()
                    .padding(vertical = 32.dp) // we have space between the result and the number grid  (spacing result form above and below)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Clear)
                    }
                )

                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Delete)
                    }
                )

                CalculatorButton(
                    symbol = "%",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Modulus))
                    }
                )

                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(7))
                    }
                )

                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(8))
                    }
                )

                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(9))
                    }
                )

                CalculatorButton(
                    symbol = "*",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    }
                )
            }



            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(4))
                    }
                )

                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(5))
                    }
                )

                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(6))
                    }
                )

                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    }
                )
            }



            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(1))
                    }
                )

                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(2))
                    }
                )

                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(3))
                    }
                )

                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    }
                )
            }



            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(2f)    //width of the button is twice of others
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Number(0))
                    }
                )

                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Decimal)
                    }
                )

                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)    //width of the button is twice of others
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Calculate)
                    }
                )
            }
        }
    }
}