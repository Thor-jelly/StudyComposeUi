package com.dongdongwu.studycomposeui.tianqi.weathericon

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dongdongwu.studycomposeui.R

/**
 * 类描述：云<br/>
 * 创建人：吴冬冬<br/>
 * 创建时间：2022/1/18 13:45 <br/>
 */
@Composable
fun AnimatableCloud(modifier: Modifier = Modifier, durationMills: Int = 1500) {
    val transition = rememberInfiniteTransition()
    val animateTween by transition.animateFloat(
        initialValue = -1f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            tween(durationMills, easing = LinearEasing),
            RepeatMode.Reverse
        )
    )

    Cloud(modifier = modifier.offset(5.dp * animateTween))
}

@Composable
fun Cloud(modifier: Modifier = Modifier) {
    Image(
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_cloud),
        contentDescription = "",
        modifier = modifier.clearAndSetSemantics { }
    )
}

@Preview
@Composable
fun PreviewAnimatableCloud() {
    AnimatableCloud()
}