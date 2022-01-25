package com.dongdongwu.studycomposeui.tianqi.weathericon

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.lang.Math.cos
import java.lang.Math.sin


/**
 * 类描述：晴天<br/>
 * 创建人：吴冬冬<br/>
 * 创建时间：2022/1/18 17:52 <br/>
 */
@Composable
fun AnimatableSun(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition()

    val animateTween by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(5000), RepeatMode.Restart)
    )

    Canvas(modifier.rotate(animateTween)) {
        val radius = size.width / 6
        val stroke = size.width / 20
        val centerOffset = Offset(size.width / 30, size.width / 30)

        //画圆
        drawCircle(
            color = Color.Black,
            radius = radius + stroke / 2,
            style = Stroke(width = stroke),
            center = center + centerOffset
        )
        drawCircle(
            color = Color.White,
            radius = radius,
            style = Fill,
            center = center + centerOffset
        )

        //画光
        val lineLength = radius * 0.6f
        val lineOffset = radius * 1.8f
        (0..7).forEach { i ->

            val radians = Math.toRadians(i * 45.0)

            val offsetX = lineOffset * cos(radians).toFloat()
            val offsetY = lineOffset * sin(radians).toFloat()

            val x1 = size.width / 2 + offsetX + centerOffset.x
            val x2 = x1 + lineLength * cos(radians).toFloat()

            val y1 = size.height / 2 + offsetY + centerOffset.y
            val y2 = y1 + lineLength * sin(radians).toFloat()

            drawLine(
                color = Color.Black,
                start = Offset(x1, y1),
                end = Offset(x2, y2),
                strokeWidth = stroke,
                cap = StrokeCap.Round
            )
        }
    }
}

@Composable
fun Sun(modifier: Modifier = Modifier) {
    Canvas(modifier) {
        val radius = size.width / 6
        val stroke = size.width / 20
        drawCircle(
            color = Color.Black,
            radius = radius + stroke / 2,
            style = Stroke(width = stroke),
        )
        drawCircle(
            color = Color.White,
            radius = radius,
            style = Fill,
        )
        val lineLength = radius * 0.2f
        val lineOffset = radius * 1.8f
        (0..7).forEach { i ->
            val radians = Math.toRadians(i * 45.0)

            val offsetX = lineOffset * cos(radians).toFloat()
            val offsetY = lineOffset * sin(radians).toFloat()

            val x1 = size.width / 2 + offsetX
            val x2 = x1 + lineLength * cos(radians).toFloat()

            val y1 = size.height / 2 + offsetY
            val y2 = y1 + lineLength * sin(radians).toFloat()

            drawLine(
                color = Color.Black,
                start = Offset(x1, y1),
                end = Offset(x2, y2),
                strokeWidth = stroke,
                cap = StrokeCap.Round
            )
        }
    }
}

@Preview
@Composable
fun PreviewAnimatableSun() {
    AnimatableSun(Modifier.size(100.dp))
}