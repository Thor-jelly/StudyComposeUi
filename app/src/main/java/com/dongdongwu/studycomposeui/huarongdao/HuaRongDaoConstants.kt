package com.dongdongwu.studycomposeui.huarongdao

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.IntOffset

/**
 * 类描述：华容道 棋子model生成  <br/>
 * 创建人：吴冬冬<br/>
 * 创建时间：2022/1/25 16:26 <br/>
 */
//创建10个棋子
val zhang = HuaRongDaoChessModel(
    "张飞",
    {
        MaterialTheme.huaRongDaoChessImageRes.zhangfei
    },
    1, 2
)
val cao = HuaRongDaoChessModel(
    "曹操",
    {
        MaterialTheme.huaRongDaoChessImageRes.caocao
    },
    2, 2
)
val zhao = HuaRongDaoChessModel(
    "赵云",
    {
        MaterialTheme.huaRongDaoChessImageRes.zhaoyun
    },
    1, 2
)
val huang = HuaRongDaoChessModel(
    "黄忠",
    {
        MaterialTheme.huaRongDaoChessImageRes.huangzhong
    },
    1, 2
)
val guan = HuaRongDaoChessModel(
    "关羽",
    {
        MaterialTheme.huaRongDaoChessImageRes.guanyu
    },
    2, 1
)
val ma = HuaRongDaoChessModel(
    "马超",
    {
        MaterialTheme.huaRongDaoChessImageRes.machao
    },
    1, 2
)

//4个卒棋子
@OptIn(ExperimentalStdlibApi::class)
val zu = buildList<HuaRongDaoChessModel> {
    repeat(4) {
        add(
            HuaRongDaoChessModel(
                "卒$it",
                {
                    MaterialTheme.huaRongDaoChessImageRes.zu
                },
                1, 1
            )
        )
    }
}

//初始棋子位置 集合
//别名
typealias HuaRongDaoChessOpening = List<Triple<HuaRongDaoChessModel, Int, Int>>

@OptIn(ExperimentalStdlibApi::class)
val huaRongDaoOpening: HuaRongDaoChessOpening = buildList {
    //创建初始布局，并把10个棋子放到指定位置
    add(Triple(zhang, 0, 0))
    add(Triple(cao, 1, 0))
    add(Triple(zhao, 3, 0))
    add(Triple(huang, 0, 2))
    add(Triple(guan, 1, 2))
    add(Triple(ma, 3, 2))
    add(Triple(zu[0], 1, 3))
    add(Triple(zu[1], 2, 3))
    add(Triple(zu[2], 0, 4))
    add(Triple(zu[3], 3, 4))
}

fun HuaRongDaoChessOpening.toList() = map { (chess, x, y) ->
    //转化成真实像素距离
    chess.moveBy(IntOffset(x * HuaRongDaoChessModel.GRID_PX, y * HuaRongDaoChessModel.GRID_PX))
}