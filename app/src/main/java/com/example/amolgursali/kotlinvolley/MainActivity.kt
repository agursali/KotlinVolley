package com.example.amolgursali.kotlinvolley

import android.content.res.AssetManager
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.amolgursali.kotlinvolley.Adapter.MobileDetailAdapter
import com.example.amolgursali.kotlinvolley.GetSet.MobileDetails
import org.json.JSONArray
import java.io.InputStream
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    lateinit var recyclerview : RecyclerView
    lateinit var progressbar : ProgressBar
    val arrayList=ArrayList<MobileDetails>()
    companion object {
        const val URL="https://androidtutorialpoint.com/api/volleyJsonArray"
    }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview=findViewById(R.id.recyclerview)
        progressbar=findViewById(R.id.progressbar)
        val linearlayoutmanager=LinearLayoutManager(this)
        recyclerview.layoutManager=linearlayoutmanager
        recyclerview.itemAnimator=DefaultItemAnimator()
        getDatafromWebService(URL);

    }

    private fun getDatafromWebService(url: String)
    {
        val queue= Volley.newRequestQueue(this)
        val response: String? = null

        val finalResponse = response
        progressbar.visibility= View.VISIBLE
        val stringrequest=object : StringRequest(Request.Method.GET,url, Response.Listener
        {
            response ->
            try {
                val jsonArray=JSONArray(response)
                Log.d("Response : ", jsonArray.toString())
                for( i in  0 until jsonArray.length() )
                {
                    val c =jsonArray.getJSONObject(i)
                    val mobileGetSet=MobileDetails()
                    mobileGetSet.rom=c.getString("rom")
                    mobileGetSet.screenSize=c.getString("screenSize")
                    mobileGetSet.backCamera=c.getString("backCamera")
                    mobileGetSet.companyName=c.getString("companyName")
                    mobileGetSet.name=c.getString("name")
                    mobileGetSet.frontCamera=c.getString("frontCamera")
                    mobileGetSet.battery=c.getString("battery")
                    mobileGetSet.operatingSystem=c.getString("operatingSystem")
                    mobileGetSet.processor=c.getString("processor")
                    mobileGetSet.url=c.getString("url")
                    mobileGetSet.ram=c.getString("ram")
                    arrayList.add(mobileGetSet)
                }
                val adapter=MobileDetailAdapter(this@MainActivity,arrayList)
                recyclerview.adapter=adapter
                progressbar.visibility=View.GONE
            }
            catch (e : Exception)
            {
                e.printStackTrace()
                progressbar.visibility=View.GONE
            }



        },
          Response.ErrorListener
        {
            Log.d("Error",finalResponse)
            progressbar.visibility=View.GONE
        })
        {

        }
        stringrequest.retryPolicy=DefaultRetryPolicy(0,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        queue.add(stringrequest)

    }

}
