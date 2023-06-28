package cn.edu.swu.cs.android.todolist

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates


class EditActivity : AppCompatActivity() {

    val KEY_ITEM = "item"
    var id1:Int = 0
    lateinit var title1:String
    lateinit var content1:String
    lateinit var createtime1:String
    lateinit var editTtile:EditText
    lateinit var editcontent:EditText


    lateinit var helper:DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val it = getIntent()
        getInformationFromMain(it)
        editTtile=findViewById(R.id.edit_title)
        editTtile.setText(title1)
        editcontent=findViewById(R.id.content)
        editcontent.setText(content1)
        init()
    }

    private fun init(){
        helper = DBHelper(this,"todo.db",1)

        findViewById<Button>(R.id.btn_save).setOnClickListener {
            saveInput()
            //val intent = Intent(this@EditActivity, MainActivity::class.java)
            //startActivity(intent)
        }

        findViewById<Button>(R.id.btn_clean).setOnClickListener {
            clean()
        }

        findViewById<ImageView>(R.id.btn_back).setOnClickListener {
            //val intent = Intent(this@EditActivity, MainActivity::class.java)
            //startActivity(intent)
            finish()
        }
    }


    private fun saveInput() {
        val text = findViewById<EditText>( R.id.content).text.toString()
        val title=findViewById<EditText>(R.id.edit_title).text.toString()
//        writeInSp(text)
//        writeInFile(text)
        saveInDb(title,text)
    }

    private fun saveInDb(title:String,text: String) {
        val db = helper.writableDatabase
        val values = ContentValues().apply {
            put(Todo.COL_TITLE,title)
            put(Todo.COL_CONTENT,text)
            put(Todo.COL_TIME,System.currentTimeMillis())
        }
        if(id1==0) {
            val rs = db.insert(Todo.TABLE, null, values)
            Toast.makeText(this,if(rs < 0) "保存失败" else "保存成功" , Toast.LENGTH_LONG).show()
        }
        else {
            val rs=db.update(Todo.TABLE,values,"id=?", arrayOf("$id1"))
            Toast.makeText(this, if (rs < 0) "保存失败" else "保存成功", Toast.LENGTH_LONG).show()
        }
        db.close()
    }


    private fun clean() {
        var editText: EditText
        editText = findViewById<EditText>(R.id.edit_title)
        editText.getText().clear()
        editText = findViewById<EditText>(R.id.content)
        editText.getText().clear()
    }

    private fun getInformationFromMain(it: Intent){

        id1=it.getIntExtra("id",0)
        title1= it.getStringExtra("title").toString()
        content1=it.getStringExtra("content").toString()
        createtime1=it.getStringExtra("createtime").toString()
    }

}