package cn.edu.swu.cs.android.lesson51

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FunctionAdapter: RecyclerView.Adapter<FunctionAdapter.FriendViewHolder>() {
    val TAG = "FriendAdapter"

    val data = ArrayList<Function>()

    inner class FriendViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.findViewById<ImageView>(R.id.img1)
        val nam = view.findViewById<TextView>(R.id.name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.function_item, parent,false)

        return FriendViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val item = data[position]

        Log.d(TAG, "on item render : $position")

        holder.img.setImageResource(item.cover)
        holder.nam.text = item.name

    }

    //设置渲染的数据
    fun setData(arr: ArrayList<cn.edu.swu.cs.android.lesson51.Function>){
        data.clear()
        data.addAll(arr)
        // 通知数据变化
        // notifyDataSetChanged()
    }

}