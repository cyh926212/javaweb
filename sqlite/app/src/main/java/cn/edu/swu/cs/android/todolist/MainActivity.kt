package cn.edu.swu.cs.android.todolist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    val TAG = "@@MAIN"
    val KEY_ITEM = "item"

    lateinit var helper:DBHelper
    lateinit var adapter: TodoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    override fun onResume() {
        super.onResume()
        init()

    }

    @SuppressLint("NotifyDataSetChanged", "Range")
    private fun init(){
        helper = DBHelper(this,"todo.db",1)

        adapter = TodoAdapter()

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

//        readFromSp()
//        readInFile()
        readInDb()


        findViewById<ImageView>(R.id.add).setOnClickListener {
            val intent = Intent(this@MainActivity, EditActivity::class.java)
            intent.putExtra("id",0)
            intent.putExtra("content","")
            intent.putExtra("title", "")
            intent.putExtra("createTime", "")
            startActivity(intent)

        }

    }

    @SuppressLint("Range")
    private fun readInDb() {
        val db = helper.readableDatabase
        val cursor = db.query(Todo.TABLE,null,null,null,null,null,
            "${Todo.COL_ID}" +
                    " ")
        val arr = arrayListOf<Todo>()
        if(cursor.moveToFirst()){
            do{
                arr.add(
                    Todo(
                        cursor.getString(cursor.getColumnIndex(Todo.COL_CONTENT)),
                        cursor.getLong(cursor.getColumnIndex(Todo.COL_TIME)),
                        cursor.getString(cursor.getColumnIndex(Todo.COL_TITLE))
                    ).apply {
                        id = cursor.getInt(cursor.getColumnIndex(Todo.COL_ID))
                    }
                )
            }while (cursor.moveToNext())
        }

        adapter.setData(arr)

        cursor.close()
    }


    private fun transportInformationToEdit(it: Intent, record: Todo) {
        it.putExtra("id", record.id)
        it.putExtra("content", record.content)
        it.putExtra("title", record.title)
        it.putExtra("createTime", record.createTime)

    }

    private fun deleteinDB(id1:Int){
        val db=helper.writableDatabase
        val sql = "delete from Todo where id =$id1 "
        AlertDialog.Builder(this)
            .setTitle("请确认")
            .setMessage("您确定要删除吗？")
            .setNegativeButton("取消"){d,w->
                Toast.makeText(this,"已取消",Toast.LENGTH_LONG).show()
                db.close()
            }
            .setPositiveButton("确定"){d,w->
                db.execSQL(sql)
                db.close()
                adapter.deleteById(id1)
            }
            .show()
    }

    inner class TodoAdapter : RecyclerView.Adapter<TodoViewHolder>() {

        val data  = arrayListOf<Todo>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent,false)
            return TodoViewHolder(view).apply {
                content = view.findViewById(R.id.content)
                btnDelete = view.findViewById(R.id.btn_delete)

            }
        }

        override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
            holder.render(data[position])
        }

        override fun getItemCount(): Int {
            return data.size
        }

        fun setData(arr: ArrayList<Todo>) {
            data.addAll(arr)

            notifyDataSetChanged()
        }

        private fun findIdx(id: Int?): Int {
            var idx = -1
            data.forEachIndexed { index, todo ->
                if(todo.id == id){
                    idx = index
                }
            }
            return idx
        }
        fun deleteById(id1: Int) {
            val idx = findIdx(id1)
            if(idx >= 0){
                data.removeAt(idx)
                notifyItemRemoved(idx)
            }
            notifyDataSetChanged()
        }
        fun replaceItem(id: Int?, item: Todo) {
            val idx = findIdx(id)
            if(idx >= 0) {
                data.set(idx, item)
                notifyItemChanged(idx)
            }
        }
        fun additem(item: Todo){
            data.add(0,item)
            notifyItemInserted(0)
        }


    }

    inner class TodoViewHolder(view: View): RecyclerView.ViewHolder(view){

        var id:TextView? = null
        var content:TextView? = null

        var btnDelete:TextView? = null


        @SuppressLint("Range")
        fun render(todo: Todo) {
            id?.text = todo.id.toString()
            content?.text = todo.title



            btnDelete?.setOnClickListener {
                todo.id?.let { it1 -> deleteinDB(it1) }
            }
            content?.setOnClickListener {
                val intent = Intent(this@MainActivity, EditActivity::class.java)
                transportInformationToEdit(intent,todo)
                startActivity(intent)
            }


        }

    }
}
