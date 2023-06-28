package cn.edu.swu.cs.android.lesson3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG,"onCreated...")
        setContentView(R.layout.activity_main)

        //增加按钮事件

        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            Log.i(TAG,"on click button . ")
            val intent = Intent(this,SecondActicity::class.java)

            //传递参数
            intent.putExtra("name","Jack")
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart...")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume...")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause...")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop...")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy...")
    }
}