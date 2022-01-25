package com.dongdongwu.studycomposeui.tianqi

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dongdongwu.studycomposeui.tianqi.weathericon.*

/**
 * https://juejin.cn/post/6944884453038620685
 * 创建人：吴冬冬<br/>
 * 创建时间：2022/1/18 13:14 <br/>
 */
class TianQiIconActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Log.e("123===", "天气iconActivity，setContent")
            //TestCanvas()

            Row {
                Column {
                    AnimatableCloud()
                    Spacer(Modifier.height(5.dp))
                    Rains(modifier = Modifier.size(150.dp))
                    Spacer(Modifier.height(5.dp))
                    AnimatableRains(modifier = Modifier.size(150.dp))
                    Spacer(Modifier.height(5.dp))
                    AnimatableSnow(
                        modifier = Modifier
                            .width(150.dp)
                            .height(200.dp)
                    )
                }
                Spacer(Modifier.height(5.dp))
                AnimatableSun(Modifier.size(100.dp))
            }
        }

    }

    @Composable
    fun TestCanvas() {
        Canvas(modifier = Modifier.fillMaxWidth()) {
            //通过size获取当前canvas的width 和height
            val w = size.width
            val h = size.height

            Log.e("123===", "获取到的宽：${w}，高=${h}")

            //绘制直线
            drawLine(
                start = Offset(w, 0f),
                end = Offset(0f, h),
                color = Color.Blue,
                strokeWidth = 5F//设置直线宽度
            )
        }
    }
}