package cn.edu.swu.cs.android.lesson51

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val TAG = "MainActivity"

    val data = ArrayList<Friend>()

    lateinit var adapter: FriendAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMsg = findViewById<View>(R.id.btn_msg)
        val btnContact = findViewById<View>(R.id.btn_contact)
        val btnDis = findViewById<View>(R.id.btn_discover)
        val btnMe = findViewById<View>(R.id.btn_me)

        btnMsg.setOnClickListener(this)
        btnContact.setOnClickListener(this)
        btnDis.setOnClickListener(this)
        btnMe.setOnClickListener(this)

        showFragment("msg", MsgFragment())

    }

    override fun onClick(view: View?) {
        Log.d(TAG, "clicked ${view?.id}")
        when (view?.id) {
            R.id.btn_msg -> {
                showFragment("msg", MsgFragment())
            }
            R.id.btn_contact -> {
                showFragment("contact", ContactFragment())
            }
            R.id.btn_discover -> {
                showFragment("discover", DiscoverFragment())
            }
            R.id.btn_me -> {
                showFragment("me", MeFragment())
            }
        }
    }

    fun showFragment(name: String, fragment: Fragment) {
        val manager = supportFragmentManager
        val trans = manager.beginTransaction()
        val frag = manager.findFragmentByTag(name)
        manager.fragments.forEach {
            trans.hide(it)
        }
        if (frag != null) {
            trans.show(frag)
        } else {
            //trans.add(fragment,name)
            trans.add(R.id.layout, fragment, name)
        }
        trans.addToBackStack(null)
        //trans.setReorderingAllowed(true)
        trans.commit()
    }

    fun show(item: Friend) {
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("avatar",item.avatar)
        intent.putExtra("name",item.name)
        intent.putExtra("talk",item.talk)
        intent.putExtra("date",item.date)
        startActivity(intent)
    }
    fun showFunction(item: cn.edu.swu.cs.android.lesson51.Function) {
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("avatar",item.cover)
        intent.putExtra("name",item.name)
        startActivity(intent)
    }
}

