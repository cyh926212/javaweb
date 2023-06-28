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

class DiscoverFragment : Fragment() {

    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        //
        val recycler = view.findViewById<RecyclerView>(R.id.recycler_discover)
        val layoutManager = LinearLayoutManager(view.context)
        adapter = NewsAdapter()

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter

        loadData()
    }

    fun loadData(){
        val arr = ArrayList<cn.edu.swu.cs.android.lesson51.Function>()
        arr.add(cn.edu.swu.cs.android.lesson51.Function("朋友圈",R.mipmap.find1))
        arr.add(cn.edu.swu.cs.android.lesson51.Function("扫一扫",R.mipmap.find2))
        arr.add(cn.edu.swu.cs.android.lesson51.Function("摇一摇",R.mipmap.find3))
        arr.add(cn.edu.swu.cs.android.lesson51.Function("看一看",R.mipmap.find4))
        arr.add(cn.edu.swu.cs.android.lesson51.Function("搜一搜",R.mipmap.find5))
        arr.add(cn.edu.swu.cs.android.lesson51.Function("附近的人",R.mipmap.find6))
        arr.add(cn.edu.swu.cs.android.lesson51.Function("附近的餐厅",R.mipmap.find7))
        arr.add(cn.edu.swu.cs.android.lesson51.Function("购物",R.mipmap.find8))
        arr.add(cn.edu.swu.cs.android.lesson51.Function("游戏",R.mipmap.find9))
        arr.add(cn.edu.swu.cs.android.lesson51.Function("小程序",R.mipmap.find10))
        adapter.setData(arr)
    }

    inner class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

        val data = ArrayList<cn.edu.swu.cs.android.lesson51.Function>()

        inner class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val img = view.findViewById<ImageView>(R.id.img1)
            val name = view.findViewById<TextView>(R.id.name)
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
            holder.name.text = item.name
        }

        fun setData(arr:ArrayList<cn.edu.swu.cs.android.lesson51.Function>){
            data.clear()
            data.addAll(arr)
        }
    }
}