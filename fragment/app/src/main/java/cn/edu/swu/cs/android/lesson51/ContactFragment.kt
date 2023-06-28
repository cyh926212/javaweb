package cn.edu.swu.cs.android.lesson51

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactFragment : Fragment() {

    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        //

        val recycler = view.findViewById<RecyclerView>(R.id.recycler_contact)
        val layoutManager = LinearLayoutManager(view.context)
        adapter = NewsAdapter()

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter

        loadData()
    }

    fun loadData(){
        val arr = ArrayList<Friend>()
        arr.add(Friend("新的朋友","无","5.20",R.mipmap.contact1))
        arr.add(Friend("群聊","无","5.20",R.mipmap.contact2))
        arr.add(Friend("标签","无","5.20",R.mipmap.contact3))
        arr.add(Friend("公众号","无","5.20",R.mipmap.contact4))
        for(i in 0 ..100){
            arr.add(Friend("好友$i","噜啦啦噜啦啦噜啦噜啦类","5.20",R.mipmap.touxiang))
        }
        adapter.setData(arr)
    }

    inner class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

        val data = ArrayList<Friend>()

        inner class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val img = view.findViewById<ImageView>(R.id.img1)
            val name = view.findViewById<TextView>(R.id.name)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent,false)
            val holder = NewsViewHolder(view)

            holder.itemView.setOnClickListener{
                val pos = holder.adapterPosition
                val item = data[pos]

                (activity as MainActivity).show(item)
            }
            return NewsViewHolder(view)
        }

        override fun getItemCount() = data.size

        override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
            val item = data[position]

            holder.img.setImageResource(item.avatar)
            holder.name.text = item.name
        }

        fun setData(arr:ArrayList<Friend>){
            data.clear()
            data.addAll(arr)
        }
    }
}