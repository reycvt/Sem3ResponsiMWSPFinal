package com.example.restapimwsp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restapimwsp.api.response.ApiConfig
import com.example.restapimwsp.api.response.Inresponse.ParticipantResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val mainAdapter = MainAdapter()

    companion object{
        const val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnadd= findViewById<Button>(R.id.btnAdd)
        val btnupdate = findViewById<Button>(R.id.btnupdate)
        val btndelete = findViewById<Button>(R.id.btndelete)
        val rvWebinar = findViewById<RecyclerView>(R.id.rvWebinar)

        btnadd.setOnClickListener {
            val intent = Intent(this, InsertDataActivity::class.java)
            startActivity(intent)
            this.recreate()

        }
        with(rvWebinar){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mainAdapter
        }
        getData()
//        insertData(
//            "52001011",
//            "ilmyBeloveku",
//            "P",
//            "informatika"
//        )
    }
    private fun getData(){
        val client = ApiConfig.getService().getWebinar()
        client.enqueue(object : Callback<ParticipantResponse>{
            override fun onResponse(
                call: Call<ParticipantResponse>,
                response: Response<ParticipantResponse>
            ) {
                Log.e(TAG, response.body().toString())
                mainAdapter.setData(response.body()!!.data)
            }

            override fun onFailure(call: Call<ParticipantResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

}