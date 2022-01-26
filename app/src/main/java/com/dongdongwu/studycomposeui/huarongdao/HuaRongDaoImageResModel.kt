package com.dongdongwu.studycomposeui.huarongdao

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import com.dongdongwu.studycomposeui.R

/**
 * 创建人：吴冬冬<br/>
 * 创建时间：2022/1/25 15:26 <br/>
 */
sealed interface HuaRongDaoImageResModel {
    val huangzhong: Int
    val caocao: Int
    val zhaoyun: Int
    val machao: Int
    val zhangfei: Int
    val guanyu: Int
    val zu: Int
}

object HuaRongDaoChessImageResFirstModel : HuaRongDaoImageResModel {
    override val huangzhong = R.drawable.huangzhong
    override val caocao = R.drawable.caocao
    override val zhaoyun = R.drawable.zhaoyun
    override val zhangfei = R.drawable.zhangfei
    override val guanyu = R.drawable.guanyu
    override val machao = R.drawable.machao
    override val zu = R.drawable.zu
}

//https://developer.android.google.cn/jetpack/compose/compositionlocal
internal var LocalHuaRongDaoChessImageRes = compositionLocalOf {
    HuaRongDaoChessImageResFirstModel
}

//当前华容道 展示图片
val MaterialTheme.huaRongDaoChessImageRes
    @Composable
    @ReadOnlyComposable
    get() = LocalHuaRongDaoChessImageRes.current