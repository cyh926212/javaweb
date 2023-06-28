package cn.edu.swu.cs.android.lesson7

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    val PHONE_PER_CODE = 1024

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_call).setOnClickListener {
            val phonePer = "android.permission.CALL_PHONE"
            if (ActivityCompat.checkSelfPermission(this, phonePer)
                == PackageManager.PERMISSION_GRANTED
            ) {
                call()
            } else {
                requestPermissions(arrayOf(phonePer),PHONE_PER_CODE)
            }
        }
    }

        override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == PHONE_PER_CODE){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                call()
            }else{
               Toast.makeText(this,"您没有同意授权打电话！",Toast.LENGTH_LONG).show()
            }
        }
    }
    fun call() {
        val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
    }
}