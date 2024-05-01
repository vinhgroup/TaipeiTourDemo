package com.example.demo.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.DetailActivity
import com.example.demo.R
import com.squareup.picasso.Picasso
import quicktype.Datum
import java.sql.Time

class InforAdapter : RecyclerView.Adapter<InforAdapter.InforHolder> {
    private var arrInfor: ArrayList<Datum>
    private lateinit var mContext: Context

    constructor(arrInfor: ArrayList<Datum>, context: Context) : super() {
        this.arrInfor = arrInfor
        this.mContext = context
    }

    override fun getItemCount(): Int {
        return arrInfor.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InforHolder {
        return InforHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.inner_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: InforHolder, position: Int) {
        if (holder != null) {
            holder.tvTitle.text = arrInfor[position].name
            holder.tvContent.text = arrInfor[position].introduction
            holder.tvTime.text = arrInfor[position].open_time
//            Log.d("AAAXX", arrInfor[position].images[0].src)
            if (arrInfor[position].images.size != 0 ) {
                Picasso.get().load(arrInfor[position].images[0].src).into(holder.imgViewAvatar)
            }
            holder.itemView.setOnClickListener() {
                val intent = Intent(mContext, DetailActivity::class.java)
//                intent.putExtra("poster_url","https://img.phimapi.com/" + arrInfor[position].poster_url)
                intent.putExtra("name",arrInfor[position].name)
                intent.putExtra("introduction",arrInfor[position].introduction)
                intent.putExtra("url", arrInfor[position].url)
                if (arrInfor[position].images.size != 0 ) {
                    intent.putExtra("image", arrInfor[position].images[0].src )
                }
                mContext.startActivity(intent)
            }
        }
    }


    class InforHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var imgViewAvatar: ImageView = itemView!!.findViewById(R.id.imgView)
        var tvTitle: TextView = itemView!!.findViewById(R.id.title)
        var tvContent: TextView = itemView!!.findViewById(R.id.content)
        var tvTime: TextView = itemView!!.findViewById(R.id.tv_time)
    }
}
