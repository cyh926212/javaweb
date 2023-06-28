package cn.edu.swu.cs.android.lesson51

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FriendAdapter: RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {
    val TAG = "FriendAdapter"

    val data = ArrayList<Friend>()

    inner class FriendViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.findViewById<ImageView>(R.id.img1)
        val nam = view.findViewById<TextView>(R.id.name)
        val talk = view.findViewById<TextView>(R.id.talk)
        val date = view.findViewById<TextView>(R.id.date)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.weixin_item, parent,false)

        return FriendViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val item = data[position]

        Log.d(TAG, "on item render : $position")

        holder.img.setImageResource(item.avatar)
        holder.nam.text = item.name
        holder.talk.text = item.talk
        holder.date.text = item.date

    }

    //设置渲染的数据
    fun setData(arr: ArrayList<Friend>){
        data.clear()
        data.addAll(arr)
        // 通知数据变化
        // notifyDataSetChanged()
    }

}