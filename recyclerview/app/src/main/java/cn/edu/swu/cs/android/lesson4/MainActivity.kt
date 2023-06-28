package cn.edu.swu.cs.android.lesson4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(){
    val TAG = "MainActivity"

    val data = ArrayList<Teacher>()

    lateinit var adapter: TeacherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = intent.getStringExtra("user")
        if(name == null){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        Log.i(TAG,"login user = $name")

        adapter = TeacherAdapter()
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val manager = LinearLayoutManager(this)
        recycler.layoutManager = manager
        recycler.adapter = adapter

        //模拟加载数据
        loadData()
    }

    private fun loadData(){
        data.add(Teacher("杨坤",45,"男，四川南充人，1982年生，西南大学外国语学院教授，博士，博士后，硕士生导师。主要研究方向为认知语言学、构式语法、句法语义的界面研究、词汇类型学等。主编或参编教材4部，主持国家社科基金1项，国家社科基金重大项目子项目1项，主研国家级、省部级和校级等科研项目14项。近年来在Lingua(SSCI和A&HCI)、Metaphor and Symbol（SSCI和A&HCI）、Australian Journal of Linguistics（SSCI和A&HCI）论文30余篇。", R.mipmap.yangkun))
        data.add(Teacher("黄敏",35,"西南大学外国语学院副教授，硕士。2002年毕业于西南师范大学获得英语教育学士学位；同年保送攻读西南师范大学英语语言文学硕士研究生，2005年获得硕士学位。2002年本科毕业留校至今先后任教于西南师范大学和西南大学。曾担任综合英语、大学英语视听说、大学英语读写译、跨文化交际、大学英语演讲、拔尖人才培养含弘学院英语、英语二专听力、大学英语四六级、出国教师英语培训等多门课程的主讲教师。",R.mipmap.huangmin))
        data.add(Teacher("段云",46,"英语语言文学博士，副教授，硕士生导师。1994年毕业于西南师范大学获文学学士学位，1996年在西南师范大学获英语语言文学方向硕士学位, 2012年在西南大学获英语语言文学方向博士学位。1994年7月至今任教于西南大学外国语学院。2003年赴澳大利亚塔斯玛尼亚大学学习。主要研究兴趣：认知语言学、语用学、语义学、语篇分析、英语教学、外语教育等。中国认知语言学研究会会员。",R.mipmap.duanyun))
        data.add(Teacher("杨坤额",45,"男，四川南充人，1982年生，西南大学外国语学院教授，博士，博士后，硕士生导师。主要研究方向为认知语言学、构式语法、句法语义的界面研究、词汇类型学等。主编或参编教材4部，主持国家社科基金1项，国家社科基金重大项目子项目1项，主研国家级、省部级和校级等科研项目14项。近年来在Lingua(SSCI和A&HCI)、Metaphor and Symbol（SSCI和A&HCI）、Australian Journal of Linguistics（SSCI和A&HCI）论文30余篇。", R.mipmap.yangkun))
        data.add(Teacher("黄敏啦",35,"西南大学外国语学院副教授，硕士。2002年毕业于西南师范大学获得英语教育学士学位；同年保送攻读西南师范大学英语语言文学硕士研究生，2005年获得硕士学位。2002年本科毕业留校至今先后任教于西南师范大学和西南大学。曾担任综合英语、大学英语视听说、大学英语读写译、跨文化交际、大学英语演讲、拔尖人才培养含弘学院英语、英语二专听力、大学英语四六级、出国教师英语培训等多门课程的主讲教师。",R.mipmap.huangmin))
        data.add(Teacher("段云哈",46,"英语语言文学博士，副教授，硕士生导师。1994年毕业于西南师范大学获文学学士学位，1996年在西南师范大学获英语语言文学方向硕士学位, 2012年在西南大学获英语语言文学方向博士学位。1994年7月至今任教于西南大学外国语学院。2003年赴澳大利亚塔斯玛尼亚大学学习。主要研究兴趣：认知语言学、语用学、语义学、语篇分析、英语教学、外语教育等。中国认知语言学研究会会员。",R.mipmap.duanyun))
        data.add(Teacher("杨",45,"男，四川南充人，1982年生，西南大学外国语学院教授，博士，博士后，硕士生导师。主要研究方向为认知语言学、构式语法、句法语义的界面研究、词汇类型学等。主编或参编教材4部，主持国家社科基金1项，国家社科基金重大项目子项目1项，主研国家级、省部级和校级等科研项目14项。近年来在Lingua(SSCI和A&HCI)、Metaphor and Symbol（SSCI和A&HCI）、Australian Journal of Linguistics（SSCI和A&HCI）论文30余篇。", R.mipmap.yangkun))
        data.add(Teacher("黄",35,"西南大学外国语学院副教授，硕士。2002年毕业于西南师范大学获得英语教育学士学位；同年保送攻读西南师范大学英语语言文学硕士研究生，2005年获得硕士学位。2002年本科毕业留校至今先后任教于西南师范大学和西南大学。曾担任综合英语、大学英语视听说、大学英语读写译、跨文化交际、大学英语演讲、拔尖人才培养含弘学院英语、英语二专听力、大学英语四六级、出国教师英语培训等多门课程的主讲教师。",R.mipmap.huangmin))
        data.add(Teacher("段",46,"英语语言文学博士，副教授，硕士生导师。1994年毕业于西南师范大学获文学学士学位，1996年在西南师范大学获英语语言文学方向硕士学位, 2012年在西南大学获英语语言文学方向博士学位。1994年7月至今任教于西南大学外国语学院。2003年赴澳大利亚塔斯玛尼亚大学学习。主要研究兴趣：认知语言学、语用学、语义学、语篇分析、英语教学、外语教育等。中国认知语言学研究会会员。",R.mipmap.duanyun))

        //告知adapter
        adapter.setData(data)
    }
}