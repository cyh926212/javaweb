package cn.edu.swu.cs.android.lesson51

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter_contact: RecyclerView.Adapter<Adapter_contact.ContactViewHolder>() {
    val TAG = "Adapter_contact"

    val data = ArrayList<Friend>()

    inner class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.findViewById<ImageView>(R.id.img1)
        val nam = view.findViewById<TextView>(R.id.name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent,false)

        return ContactViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = data[position]

        Log.d(TAG, "on item render : $position")

        holder.img.setImageResource(item.avatar)
        holder.nam.text = item.name

    }

    //设置渲染的数据
    fun setData(arr: ArrayList<Friend>){
        data.clear()
        data.addAll(arr)
        // 通知数据变化
        // notifyDataSetChanged()
    }

}