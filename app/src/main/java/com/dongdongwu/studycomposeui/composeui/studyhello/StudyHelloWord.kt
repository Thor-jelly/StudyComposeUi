package com.dongdongwu.studycomposeui.composeui.studyhello

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.util.Pair
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.dongdongwu.studycomposeui.R
import com.dongdongwu.studycomposeui.ui.theme.StudyComposeUiTheme
import kotlinx.coroutines.launch


/**
 * Compose基础
 * https://developer.android.google.cn/jetpack/compose/tutorial?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23article-https%3A%2F%2Fdeveloper.android.com%2Fjetpack%2Fcompose%2Ftutorial
 * 创建人：吴冬冬<br/>
 * 创建时间：2022/1/19 17:50 <br/>
 */
class StudyHelloWord : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Text("Hello World!")
            //可组合函数
            //TextName(name = "PDD")
            //布局
            //StudyLayout(Person("哈哈", "11"))
            //主题
            //StudyTheme()
            //列表
            //PreviewConversation()

            //Compose 编程思想
            //composeIdea()

            //Compose中的布局
            //StudyLayoutColdelab()

            //在jetpack Compose中使用状态
            //StudyComposeUseState()

            //Jetpack Compose主题设置
            //https://developer.android.google.cn/codelabs/jetpack-compose-theming?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-theming#0
            
        }
    }

    //在jetpack Compose中使用状态
    @Composable
    private fun StudyComposeUseState() {
        //https://developer.android.google.cn/codelabs/jetpack-compose-state?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-state#0

    }

    //Compose中的布局
    @Composable
    private fun StudyLayoutColdelab() {
        //1.Column垂直布局 Row水平布局 Box帧布局  https://developer.android.google.cn/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#0
        //2.在项目中使用Compose 需要检查 一些配置 https://developer.android.google.cn/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#1
        //3.修饰符 https://developer.android.google.cn/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#2
        //4.插槽Api  https://developer.android.google.cn/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#3
        //5.Material组件 https://developer.android.google.cn/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#4
        //    scaffold是最常见的顶层Material组件（为TopAppBar、BottomAppBar、FloatingActionBar和Drawer）提供槽位。
        //    使用Scaffold时，可以确保这些组件能钩正确放置并协同工作
        //TestLayoutScaffoldCodelab()
        //6.使用列表 https://developer.android.google.cn/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#5
        //TestLayoutListCodelab()
        //7.创建自定义布局 https://developer.android.google.cn/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#6
        //TestCustomLayoutCodelab()
        //8.复杂的自定义布局 https://developer.android.google.cn/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#7
        //9.深入了解布局修饰符 https://developer.android.google.cn/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#8
        //    修饰符会从左到右更新约束条件，然后从右到左返回大小。
        //10.约束布局  https://developer.android.google.cn/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#9
        //11.固有特性  https://developer.android.google.cn/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#10
    }

    private @Composable
    fun TestCustomLayoutCodelab() {
        //测量可组合项。只能测量子元素一次。
        //val placeable = measurable.measure(constraints)
        //放置完需要调用 placeable.placeRelative(x, y) 放置到哪个位置
    }

    @Composable
    private fun TestLayoutListCodelab() {
        //Column 不支持滑动
        /*Column {
            repeat(100) {
                Text(text = "item $it")
            }
        }*/
        //Column 如需要滚动需要添加verticalScroll
        /*val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxWidth()
        ) {
            repeat(100) {
                Text(text = "item $it")
            }
        }*/
        //延迟列表
        /*val scrollState = rememberLazyListState()
        LazyColumn(state = scrollState) {
            items(100) {
                TestImageListItemCodelab(index = it)
            }
        }*/
        //列表滚动
        val listSize = 100
        val scrollState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()
        Column {
            Row {
                Button(onClick = {
                    coroutineScope.launch {
                        // 0 is the first item index
                        scrollState.animateScrollToItem(0)
                    }
                }) {
                    Text("Scroll to the top")
                }

                Button(onClick = {
                    coroutineScope.launch {
                        // listSize - 1 is the last index of the list
                        scrollState.animateScrollToItem(listSize - 1)
                    }
                }) {
                    Text("Scroll to the end")
                }
            }

            LazyColumn(state = scrollState) {
                items(listSize) {
                    TestImageListItemCodelab(index = it)
                }
            }
        }
    }

    @Composable
    private fun TestImageListItemCodelab(index: Int) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberImagePainter
                    (
                    data = "https://developer.android.com/images/brand/Android_Robot.png"
                ),
                contentDescription = "Android Logo",
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Item $index",
                style = MaterialTheme.typography.subtitle1
            )
        }
    }

    @Composable
    private fun TestLayoutScaffoldCodelab() {
        Scaffold(
            topBar = {
                /*Text(
                    text = "topBarShowUiText",
                    style = MaterialTheme.typography.h3
                )*/
                TopAppBar(title = {
                    Text(text = "TopBarShowUiText")
                },
                    actions = {
                        IconButton(onClick = {
                            Toast.makeText(this@StudyHelloWord, "点击了Icon Button", Toast.LENGTH_LONG)
                                .show()
                        }) {
                            Icon(Icons.Filled.Favorite, contentDescription = null)
                        }
                    }
                )
            }
        ) {
            Column(Modifier.padding(it)) {
                TextName(name = "哈哈哈")
                TextName(name = "哈哈哈".repeat(10))
            }
        }
    }

    //Compose编程思想
    private fun composeIdea() {
        //https://developer.android.google.cn/jetpack/compose/mental-model?continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fcompose%23article-https%3A%2F%2Fdeveloper.android.com%2Fjetpack%2Fcompose%2Fmental-model
        /*
            Compose会智能地选择在任何给定时间需要重新绘制界面的哪部分。
            1.组合函数
            一个简单的可组合函数(可组合函数必须要@Compose注释)，系统向它传递了数据，它使用该数据在屏幕上呈现文本微件。
            2.声明性范式转变
            3.动态内容
            4.重组
              重组整个界面树在计算成本昂贵，因为会消耗计算能力并缩短电池续航时间。Compose使用只能重组来解决此问题。

           注意事项：
           - 可组合函数可以按任何顺序执行。
           - 可组合函数可以并行执行。
                为了确保应用正常运行，所有可组合函数都不应有附带效应，而应通过始终在界面线程上执行的onClick等回调触发附带效应。
           - 重组会跳过尽可能多的可组合函数和lambda。
           - 重组是乐观的操作，可能会被取消。
           - 可组合函数可能会像动画的每一帧一样频繁地运行。
         */
    }

    @Preview
    @Composable
    private fun PreviewConversation() {
        StudyComposeUiTheme {
            Conversation(
                persons = listOf(
                    Person("我是谁，测试主题", "100"),
                    Person("我是谁111111111，测试主题", "10111111110"),
                    Person("我是谁2222222222，测试主题", "122222222222222210"),
                    Person(
                        "我是谁33333333333333，测试主题",
                        "测试主题333333333333测试主题测试主题测".repeat(50)
                    ),
                )
            )
        }
    }

    //列表布局
    @Composable
    private fun Conversation(persons: List<Person>) {
        LazyColumn {
            items(persons) { person ->
                StudyLayout(person = person)
            }
        }
    }

    //主题
    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    private fun StudyTheme() {
        StudyComposeUiTheme {
            StudyLayout(person = Person("我是谁，测试主题", "100"))
        }
    }

    data class Person(val name: String, val age: String)

    //布局
    @Composable
    private fun StudyLayout(person: Person) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_cloud),
                contentDescription = "我是一个图片",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )

            Spacer(modifier = Modifier.width(10.dp))

            var isExpanded by remember {
                mutableStateOf(false)
            }
            val surfaceColor: Color by animateColorAsState(
                targetValue = if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
            )

            Column(
                modifier = Modifier.clickable {
                    isExpanded = !isExpanded
                }
            ) {
                Text(
                    text = person.name,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.height(3.dp))

                Surface(
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    color = surfaceColor,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {
                    Text(
                        text = person.age,
                        modifier = Modifier.padding(all = 4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }

    //定义可组合函数
    @Composable
    private fun TextName(name: String) {
        Text("Hello $name")
    }
}