package com.example.amolgursali.kotlinvolley.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.amolgursali.kotlinvolley.GetSet.MobileDetails
import com.example.amolgursali.kotlinvolley.R

class MobileDetail : AppCompatActivity() {

    var arrayList = ArrayList<MobileDetails>()
    var position : Int = 0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobile_detail)
        val intent =this.intent
        if(intent!=null)
        {
            position=intent.getIntExtra("position",0)

            arrayList=intent.getParcelableArrayListExtra("array")
        }
        Toast.makeText(this,arrayList.get(position).companyName,Toast.LENGTH_SHORT).show()
        Toast.makeText(this,arrayList.get(position).name,Toast.LENGTH_SHORT).show()

    }
}

