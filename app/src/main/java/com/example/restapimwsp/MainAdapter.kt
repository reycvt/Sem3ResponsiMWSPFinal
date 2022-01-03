package com.example.restapimwsp

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.restapimwsp.MainActivity.Companion.TAG
import com.example.restapimwsp.api.response.ApiConfig
import com.example.restapimwsp.api.response.Inresponse.DataItem
import com.example.restapimwsp.api.response.Inresponse.Item
import com.example.restapimwsp.api.response.Inresponse.ParticipantResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

//    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//
//    }

private var data: ArrayList<DataItem> = arrayListOf()

    fun setData(data: List<DataItem>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvID= itemView.findViewById<TextView>(R.id.tvID)
        val tvNim = itemView.findViewById<TextView>(R.id.tvNim)
        val tvName = itemView.findViewById<TextView>(R.id.TvNama)
        val tvProdi = itemView.findViewById<TextView>(R.id.tvProdi)
        val tvJenisKelamin = itemView.findViewById<TextView>(R.id.tvJenisKelamin)
        val btnupdate = itemView.findViewById<Button>(R.id.btnupdate)
        val btndelete = itemView.findViewById<Button>(R.id.btndelete)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.items_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = data[position]
        holder.tvID.text=itemData.id
        holder.tvNim.text = itemData.nim
        holder.tvName.text = itemData.nama
        holder.tvProdi.text = itemData.prodi
        holder.tvJenisKelamin.text = itemData.jenisKelamin
        holder.btnupdate.setOnClickListener {
            val context=holder.itemView.context
            val intent = Intent( context, MainActivityUpdateData::class.java)
            intent.putExtra("Key_Id", holder.tvID.text.toString().toInt())
            intent.putExtra("Key_Nim", holder.tvNim.text.toString())
            intent.putExtra("Key_Nama", holder.tvName.text.toString())
//            intent.putExtra("Key_Kampus", holder.tvProdi.isSelected)
//            intent.putExtra("Key_Gender", holder.tvJenisKelamin.text)
            context.startActivity(intent)
        }
        holder.btndelete.setOnClickListener {
            val nim = holder.tvNim.text.toString()
            ApiConfig.getService().deleteWebinar(nim = nim).enqueue(object : Callback<ParticipantResponse>{
                override fun onResponse(
                    call: Call<ParticipantResponse>,
                    response: Response<ParticipantResponse>
                ) {
                    Log.e(TAG, response.body().toString())
//                    val toast =Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<ParticipantResponse>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message}")
                }

            })
            val context=holder.itemView.context
            val intent = Intent( context, MainActivity::class.java)
            context.startActivity(intent)
        }

//        val context=holder.itemView.context
//        val intent = Intent( context, MainActivityUpdateData::class.java)
//        intent.putExtra("Key_Nim", holder.tvNim.text.toString())
//        intent.putExtra("Key_Nama", holder.tvName.text)
//        intent.putExtra("Key_Kampus", holder.tvProdi.text)
//        intent.putExtra("Key_Gender", holder.tvJenisKelamin.text)
//        context.startActivity(intent)

    }



    override fun getItemCount(): Int {
        return this.data.size
    }
}