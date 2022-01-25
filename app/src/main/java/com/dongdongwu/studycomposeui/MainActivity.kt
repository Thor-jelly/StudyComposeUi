package com.dongdongwu.studycomposeui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dongdongwu.studycomposeui.composeui.studyhello.StudyHelloWord
import com.dongdongwu.studycomposeui.eluosi.ELuSiActivity
import com.dongdongwu.studycomposeui.tianqi.TianQiIconActivity

//compose ui学习
//https://github.com/google/accompanist
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            getDefaultPreview()
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun getDefaultPreview() {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            TextButton(
                onClick = {
                    //跳转到俄罗斯方块界面
                    startActivity(Intent(this@MainActivity, StudyHelloWord::class.java))
                }, Modifier
                    .fillMaxWidth()
                    .background(Color(0xff00ff00))
            ) {
                Text(text = "compse基础学习，具体查看对应Activity")
            }

            TextButton(
                onClick = {
                    //跳转到俄罗斯方块界面
                    startActivity(Intent(this@MainActivity, TianQiIconActivity::class.java))
                }, Modifier
                    .fillMaxWidth()
                    .background(Color(0xf000ff00))
            ) {
                Text(text = "天气图标")
            }

            TextButton(
                onClick = {
                    //跳转到俄罗斯方块界面
                    startActivity(Intent(this@MainActivity, ELuSiActivity::class.java))
                }, Modifier
                    .fillMaxWidth()
                    .background(Color(0xee00ff00))
            ) {
                Text(text = "俄罗斯方块")
            }
        }
    }
}