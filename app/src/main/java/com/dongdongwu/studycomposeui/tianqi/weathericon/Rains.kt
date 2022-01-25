package com.dongdongwu.studycomposeui.tianqi.weathericon

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

/**
 * 类描述：下雨    <br/>
 * 创建人：吴冬冬<br/>
 * 创建时间：2022/1/18 13:30 <br/>
 */
@Composable
private fun AnimatableRaindrop(modifier: Modifier = Modifier, durationMillis: Int = 800) {
    val transition = rememberInfiniteTransition()
    val animateTween by transition.animateFloat(
        initialValue = 0F,
        targetValue = 1F,
        animationSpec = infiniteRepeatable(
            tween(durationMillis, easing = LinearEasing),
            RepeatMode.Restart
        )
    )

    RainDrop(modifier, animateTween)
}

@Composable
private fun RainDrop(modifier: Modifier = Modifier, animateTween: Float = 0F) {
    //雨滴 是两个小雨滴组成 类似：- -
    Canvas(modifier = modifier) {
        //绘制区域
        val w = size.width
        val h = size.height
        val x = w / 2
        //strokeCap的半径是 w/2
        //scopeHeight处预留strokeCap宽度，让雨滴移出时保持正圆，提高视觉效果
        val strokeCapR = w / 2
        val scopeHeight = h - strokeCapR

        //两个小雨滴之间间隙
        val space = h / 2.2F + strokeCapR //间隙size
        val spacePos = scopeHeight * animateTween //描点位置animationState变化
        val sy1 = spacePos - space / 2
        val sy2 = spacePos + space / 2

        //雨滴最大长度
        val lineHeight = scopeHeight - space

        //雨滴1
        val line1Y1 = max(0F, sy1 - lineHeight)
        val line1Y2 = max(line1Y1, sy1)

        //雨滴2
        val line2Y1 = min(sy2, scopeHeight)
        val line2Y2 = min(line2Y1 + lineHeight, scopeHeight)

        drawLine(
            Color.Black,
            Offset(x, line1Y1),
            Offset(x, line1Y2),
            strokeWidth = w,
            colorFilter = ColorFilter.tint(
                Color.Black
            ),
            cap = StrokeCap.Round
        )

        drawLine(
            Color.Black,
            Offset(x, line2Y1),
            Offset(x, line2Y2),
            strokeWidth = w,
            colorFilter = ColorFilter.tint(
                Color.Black
            ),
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun AnimatableRains(modifier: Modifier = Modifier) {
    Rains(modifier, true)
}

@Composable
fun Rains(modifier: Modifier = Modifier, animate: Boolean = false) {
    Layout(
        modifier = modifier.rotate(30F),
        content = {
            if (animate) {
                AnimatableRaindrop(
                    modifier.fillMaxWidth(),
                    500
                )
                AnimatableRaindrop(
                    modifier.fillMaxWidth(),
                    600
                )
                AnimatableRaindrop(
                    modifier.fillMaxWidth(),
                    600
                )
            } else {
                RainDrop(modifier.fillMaxWidth())
                RainDrop(modifier.fillMaxWidth())
                RainDrop(modifier.fillMaxWidth())
            }
        }) { measurables, constraints ->
        val placeables = measurables.mapIndexed { index, measurable ->
            val h = when (index) {
                0 -> constraints.maxHeight * 0.8F
                1 -> constraints.maxHeight * 0.9F
                2 -> constraints.maxHeight * 0.6F
                else -> 0F
            }

            measurable.measure(
                constraints.copy(
                    minWidth = 0,
                    minHeight = 0,
                    maxWidth = constraints.maxWidth / 10,
                    maxHeight = h.toInt()
                )
            )
        }
        layout(constraints.maxWidth, constraints.maxHeight) {
            var xPosition = constraints.maxWidth / ((placeables.size + 1) * 2)
            placeables.forEachIndexed { index, placeable ->
                placeable.place(x = xPosition, y = 0)
                xPosition += (constraints.maxWidth / ((placeables.size + 1) * 0.8f)).roundToInt()
            }
        }
    }
}

@Preview
@Composable
fun PreviewRains() {
    Row {
        Column {
            Rains(modifier = Modifier.size(150.dp))
            Spacer(Modifier.height(5.dp))
            AnimatableRains(modifier = Modifier.size(150.dp))
        }
        Divider(
            Modifier
                .height(300.dp)
                .padding(10.dp)
                .width(1.dp)
        )
        Column {
            Rains(modifier = Modifier.size(150.dp))
            Spacer(Modifier.height(5.dp))
            AnimatableRains(modifier = Modifier.size(150.dp))
        }
    }
}