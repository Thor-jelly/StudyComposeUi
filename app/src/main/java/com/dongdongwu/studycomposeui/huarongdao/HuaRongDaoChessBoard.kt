package com.dongdongwu.studycomposeui.huarongdao

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

/**
 * 类描述：华容道  棋盘 <br/>
 * 创建人：吴冬冬<br/>
 * 创建时间：2022/1/25 13:16 <br/>
 */
@Composable
fun Density.HuaRongDaoChessBoard(
    modifier: Modifier = Modifier,
    list: List<HuaRongDaoChessModel>,
    onMove: (moveChessName: String, x: Int, y: Int) -> Unit = { _, _, _ -> }
) {
    val scope = rememberCoroutineScope()
    Box(
        modifier.fillMaxSize()
    ) {
        Log.e("123===", "${HuaRongDaoChessModel.BOARD_W.toDp()}")
        Box(
            Modifier
                .background(MaterialTheme.colors.secondary.copy(alpha = 0.2F))
                .padding(10.dp)
                .width(HuaRongDaoChessModel.BOARD_W.toDp())
                .height(HuaRongDaoChessModel.BOARD_H.toDp())
                .background(MaterialTheme.colors.secondary)
                .align(Alignment.Center)
        ) {
            //放置棋子
            list.forEach { chess ->
                Image(
                    painter = painterResource(id = chess.imageRes()),
                    contentDescription = chess.name,
                    modifier = Modifier
                        .offset {//棋子偏移量
                            chess.offset
                        }
                        .width(
                            chess
                                .getWidth()
                                .toDp()
                        )//棋子宽度
                        .height(
                            chess
                                .getHeight()
                                .toDp()
                        )//棋子高度
                        .border(1.dp, Color.Black)//棋子外边框
                        .draggable(//监听水平方向手势
                            orientation = Orientation.Horizontal,
                            state = rememberDraggableState(onDelta = {
                                onMove(chess.name, it.roundToInt(), 0)
                            })
                        )
                        .pointerInput(Unit) {
                            //另一种方式监听手势
                            //这里需要放到协程中
                            scope.launch {
                                detectVerticalDragGestures { change, dragAmount ->
                                    change.consumeAllChanges()
                                    onMove(chess.name, 0, dragAmount.roundToInt())
                                }
                            }
                        }
                )
            }
        }
    }
}