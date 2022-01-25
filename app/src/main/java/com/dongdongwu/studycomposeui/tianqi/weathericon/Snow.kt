package com.dongdongwu.studycomposeui.tianqi.weathericon

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt


/**
 * 类描述：雪 <br/>
 * 创建人：吴冬冬<br/>
 * 创建时间：2022/1/18 16:57 <br/>
 */
@Composable
private fun AnimatableSnowDrop(
    modifier: Modifier = Modifier,
    durationMillis: Int = 1000
) {
    val transition = rememberInfiniteTransition()

    val animateY by transition.animateFloat(
        initialValue = 0F,
        targetValue = 2.5F,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis,
                easing = LinearEasing
            ),
            RepeatMode.Restart
        )
    )

    val animateX by transition.animateFloat(
        initialValue = -1F,
        targetValue = 1F,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis / 3,
                easing = LinearEasing
            ),
            RepeatMode.Reverse
        )
    )

    val animateAlpha by transition.animateFloat(
        initialValue = 1F,
        targetValue = 0F,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis,
                easing = FastOutLinearInEasing
            ),
            RepeatMode.Restart
        )
    )

    SnowDrop(modifier, animateX, animateY, animateAlpha)
}

@Composable
private fun SnowDrop(
    modifier: Modifier = Modifier,
    xOffset: Float = 1F,
    yOffset: Float = 1F,
    alpha: Float = 1F
) {
    //画圆环
    //计算半径
    Canvas(modifier) {
        val r = size.width / 2 //半径
        val c = center.copy(
            x = center.x + center.x * xOffset,
            y = center.y + center.y * yOffset,
        )
        //画白芯
        drawCircle(
            color = Color.White.copy(alpha = alpha),
            center = c,
            radius = r
        )
        //画黑环
        drawCircle(
            color = Color.Black.copy(alpha = alpha),
            center = c,
            radius = r,
            style = Stroke(width = r * 0.5F)
        )
    }
}

@Composable
fun AnimatableSnow(modifier: Modifier = Modifier) {
    Snow(modifier, true)
}

@Composable
fun Snow(
    modifier: Modifier = Modifier,
    animate: Boolean = false,
) {
    Layout(
        modifier = modifier,
        content = {

            if (animate) {
                AnimatableSnowDrop(
                    modifier.fillMaxSize(),
                    2200
                )
                AnimatableSnowDrop(
                    modifier.fillMaxSize(),
                    1600
                )
                AnimatableSnowDrop(
                    modifier.fillMaxSize(),
                    1800
                )
            } else {
                SnowDrop(
                    modifier.fillMaxSize()
                )
                SnowDrop(
                    modifier.fillMaxSize()
                )
                SnowDrop(
                    modifier.fillMaxSize()
                )
            }
        }
    ) { measurables, constraints ->
        // Don't constrain child views further, measure them with given constraints
        // List of measured children
        val placeables = measurables.mapIndexed { index, measurable ->
            // Measure each children

            val height = when (index) {
                0 -> constraints.maxHeight * 0.6f
                1 -> constraints.maxHeight * 1.0f
                2 -> constraints.maxHeight * 0.7f
                else -> 0f
            }
            measurable.measure(
                constraints.copy(
                    minWidth = 0,
                    minHeight = 0,
                    maxWidth = constraints.maxWidth / 5, // snowdrop width
                    maxHeight = height.roundToInt(),
                )
            )
        }
        layout(constraints.maxWidth, constraints.maxHeight) {
            var xPosition = constraints.maxWidth / ((placeables.size + 1))
            placeables.forEachIndexed { index, placeable ->
                placeable.place(x = xPosition, y = -(constraints.maxHeight * 0.2).roundToInt())
                xPosition += (constraints.maxWidth / ((placeables.size + 1) * 0.9f)).roundToInt()
            }
        }
    }
}

@Preview
@Composable
fun PreviewSnow() {
    Row {
        Column {
            AnimatableSnow(
                modifier = Modifier
                    .width(150.dp)
                    .height(200.dp)
            )
        }
    }
}
