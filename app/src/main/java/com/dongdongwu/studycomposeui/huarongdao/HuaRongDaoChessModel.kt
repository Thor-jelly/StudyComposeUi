package com.dongdongwu.studycomposeui.huarongdao

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset

/**
 * 类描述：华容道 棋子model <br/>
 * 创建人：吴冬冬<br/>
 * 创建时间：2022/1/25 11:02 <br/>
 */
data class HuaRongDaoChessModel(
    val name: String, //名称
    val imageRes: @Composable () -> Int,//图片资源
    private val w: Int,
    private val h: Int,
    private var _offset: IntOffset = IntOffset(0, 0)//棋子偏移量
) {
    val offset
        get() = _offset

    companion object {
        const val GRID_PX = 200//最小大小
        const val BOARD_W = GRID_PX * 4
        const val BOARD_H = GRID_PX * 5
    }

    //获取当前棋子在布局中宽度
    fun getWidth() = w * GRID_PX

    //获取当前棋子在布局中高度
    fun getHeight() = h * GRID_PX

    //获取当前棋子在布局中x轴开始位置
    fun getLeft() = offset.x

    //获取当前棋子在布局中x轴结束位置
    fun getRight() = offset.x + getWidth()

    //获取当前棋子在布局中y轴开始位置
    fun getTop() = offset.y

    //获取当前棋子在布局中y轴结束位置
    fun getBottom() = offset.y + getHeight()

    //移动偏移量
    fun moveBy(offset: IntOffset): HuaRongDaoChessModel {
        this._offset = this.offset + offset
        return this
    }

    //移动x轴
    fun moveX(x: Int) = moveBy(IntOffset(x, 0))

    //移动y轴
    fun moveY(y: Int) = moveBy(IntOffset(0, y))
}