package cn.edu.swu.cs.android.todolist

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DBHelper (context: Context?,
                name: String?,
                version: Int
) : SQLiteOpenHelper(context, name, null,version) {

    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("CREATE TABLE ${Todo.TABLE} (\n" +
                "\t${Todo.COL_ID} integer PRIMARY KEY autoincrement,\n" +
                "\t${Todo.COL_CONTENT} text,\n" +
                "\t${Todo.COL_TIME} REAL,\n"+
                "\t${Todo.COL_TITLE} text)")

    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.delete(Todo.TABLE,null,null)

        db.execSQL("CREATE TABLE ${Todo.TABLE} (\n" +
                "\t${Todo.COL_ID} integer PRIMARY KEY autoincrement,\n" +
                "\t${Todo.COL_CONTENT} text,\n" +
                "\t${Todo.COL_TIME} REAL,\n"+
                "\t${Todo.COL_TITLE} text)")
    }
}