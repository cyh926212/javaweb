package cn.edu.swu.cs.android.lesson51

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MeFragment : Fragment() {

    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_me, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        //
        val recycler = view.findViewById<RecyclerView>(R.id.recycler_me)
        val layoutManager = LinearLayoutManager(view.context)
        adapter = NewsAdapter()

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter

        loadData()
    }

    fun loadData(){
        val arr = ArrayList<cn.edu.swu.cs.android.lesson51.Function>()
        arr.add(cn.edu.swu.cs.android.lesson51.Function("支付",R.mipmap.me1))
        arr.add(cn.edu.swu.cs.android.lesson51.Function("收藏",R.mipmap.me2))
        arr.add(cn.edu.swu.cs.android.lesson51.Function("相册",R.mipmap.me3))
        arr.add(cn.edu.swu.cs.android.lesson51.Function("卡包",R.mipmap.me4))
        arr.add(cn.edu.swu.cs.android.lesson51.Function("表情",R.mipmap.me5))
        arr.add(cn.edu.swu.cs.android.lesson51.Function("设置",R.mipmap.me6))
        adapter.setData(arr)
    }

    inner class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

        val data = ArrayList<cn.edu.swu.cs.android.lesson51.Function>()

        inner class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val img = view.findViewById<ImageView>(R.id.img1)
            val wxnumber = view.findViewById<TextView>(R.id.name)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.function_item,parent,false)
            val holder = NewsViewHolder(view)

            holder.itemView.setOnClickListener{
                val pos = holder.adapterPosition
                val item = data[pos]

                (activity as MainActivity).showFunction(item)
            }
            return NewsViewHolder(view)
        }

        override fun getItemCount() = data.size

        override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
            val item = data[position]

            holder.img.setImageResource(item.cover)
            holder.wxnumber.text = item.name
        }

        fun setData(arr:ArrayList<cn.edu.swu.cs.android.lesson51.Function>){
            data.clear()
            data.addAll(arr)
        }
    }
}