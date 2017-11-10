package com.example.amolgursali.kotlinvolley.Adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.amolgursali.kotlinvolley.Activity.MobileDetail
import com.example.amolgursali.kotlinvolley.GetSet.MobileDetails
import com.example.amolgursali.kotlinvolley.MainActivity
import com.example.amolgursali.kotlinvolley.R
import com.squareup.picasso.Picasso

/**
 * Created by AmolGursali on 11/10/2017.
 */
class MobileDetailAdapter(val context: Context,val arrayList: ArrayList<MobileDetails>) : RecyclerView.Adapter<MobileDetailAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder
    {
        val v= LayoutInflater.from(context).inflate(R.layout.mobilelists,parent,false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder?, position: Int)
    {
        val mobiledetails : MobileDetails = arrayList[position]
        holder as ViewHolder
        holder.title.text=mobiledetails.name
        holder.subtitle.text=mobiledetails.companyName
        holder.itemView.setOnClickListener(View.OnClickListener {
            val i= Intent(context,MobileDetail::class.java)
            i.putParcelableArrayListExtra("array",arrayList)
            i.putExtra("position",holder.adapterPosition)
            context.startActivity(i)

        })
    }

    override fun getItemCount(): Int
    {
       return arrayList.size
    }


    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        val subtitle : TextView = view.findViewById(R.id.subtitle)
        val title : TextView = view.findViewById(R.id.title)
    }

}

