package com.dongdongwu.studycomposeui.huarongdao

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import kotlin.math.max
import kotlin.math.min

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
        return this.copy(_offset = this.offset + offset)
    }

    //移动x轴
    private fun moveX(x: Int) = moveBy(IntOffset(x, 0))

    //移动y轴
    private fun moveY(y: Int) = moveBy(IntOffset(0, y))

    //检测边界+水平移动
    fun checkAndMoveX(x: Int, otherList: List<HuaRongDaoChessModel>): HuaRongDaoChessModel {
        //return moveX(x)
        otherList.filter {
            it.name != this.name
        }.forEach { other ->
            if (x > 0 && this isToLeftOf other && this.getRight() + x >= other.getLeft()) {
                //右移 && 当前移动的在其他的左边 && 当前移动的距离+right >= 其右边Left的位置  边界位置
                return moveX(other.getLeft() - this.getRight())
            } else if (x < 0 && this isToRightOf other && this.getLeft() + x <= other.getRight()) {
                //左移
                return moveX(other.getRight() - this.getLeft())
            }
        }
        return if (x > 0)
            moveX(min(x, BOARD_W - this.getRight()))
        else
            moveX(max(x, 0 - this.getLeft()))
    }

    //检测边界+垂直移动
    fun checkAndMoveY(y: Int, otherList: List<HuaRongDaoChessModel>): HuaRongDaoChessModel {
        otherList.filter {
            it.name != name
        }.forEach { other ->
            if (y > 0 && this isAboveOf other && getBottom() + y >= other.getTop())
                return moveY(other.getTop() - getBottom())
            else if (y < 0 && this isBelowOf other && getTop() + y <= other.getBottom())
                if (getTop() + y <= other.getBottom()) return moveY(other.getBottom() - getTop())
        }
        return if (y > 0)
            moveY(min(y, BOARD_H - getBottom()))
        else
            moveY(max(y, 0 - getTop()))
    }
}

infix fun HuaRongDaoChessModel.isToRightOf(other: HuaRongDaoChessModel) =
    (getLeft() >= other.getRight())
            && ((getTop() until getBottom()) intersect (other.getTop() until other.getBottom())).isNotEmpty()

infix fun HuaRongDaoChessModel.isToLeftOf(other: HuaRongDaoChessModel) =
    (getRight() <= other.getLeft())
            && ((getTop() until getBottom()) intersect (other.getTop() until other.getBottom())).isNotEmpty()

infix fun HuaRongDaoChessModel.isAboveOf(other: HuaRongDaoChessModel) =
    (getBottom() <= other.getTop()) && ((getLeft() until getRight()) intersect (other.getLeft() until other.getRight())).isNotEmpty()

infix fun HuaRongDaoChessModel.isBelowOf(other: HuaRongDaoChessModel) =
    (getTop() >= other.getBottom()) && ((getLeft() until getRight()) intersect (other.getLeft() until other.getRight())).isNotEmpty()