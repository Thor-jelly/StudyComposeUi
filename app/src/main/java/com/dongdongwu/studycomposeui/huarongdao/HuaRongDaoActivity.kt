package com.dongdongwu.studycomposeui.huarongdao

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

/**
 * 类描述：华容道 <br/>
 * https://github.com/vitaviva/compose-huarongdao
 * 创建人：吴冬冬<br/>
 * 创建时间：2022/1/25 10:32 <br/>
 */
class HuaRongDaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                color = MaterialTheme.colors.background,
                modifier = Modifier.fillMaxSize()
            ) {
                Column {
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "华容道",
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    var chessState: List<HuaRongDaoChessModel> by remember {
                        mutableStateOf(huaRongDaoOpening.toList())
                    }

                    with(LocalDensity.current) {
                        //棋盘
                        HuaRongDaoChessBoard(
                            Modifier.weight(1F),
                            list = chessState
                        ) { currentName, x, y ->
                            //棋子移动逻辑
                            chessState = chessState.map {
                                if (it.name == currentName) {
                                    if (x != 0) {
                                        //水平移动
                                        it.checkAndMoveX(x, chessState)
                                    } else {
                                        //垂直移动
                                        it.checkAndMoveY(y, chessState)
                                    }
                                } else {
                                    it
                                }
                            }
                        }
                    }

                    Row {
                        Button(onClick = {
                            chessState = huaRongDaoOpening.toList()
                        }) {
                            Text(text = "重置")
                        }
                    }
                }
            }
        }
    }
}