package com.example.restapimwsp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restapimwsp.api.response.Inresponse.DataItem
import com.example.restapimwsp.api.response.Inresponse.Item

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
        val tvNim = itemView.findViewById<TextView>(R.id.tvNim)
        val tvName = itemView.findViewById<TextView>(R.id.TvNama)
        val tvProdi = itemView.findViewById<TextView>(R.id.tvProdi)
        val tvJenisKelamin = itemView.findViewById<TextView>(R.id.tvJenisKelamin)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.items_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = data[position]
        holder.tvNim.text = itemData.nim
        holder.tvName.text = itemData.nama
        holder.tvProdi.text = itemData.prodi
        holder.tvJenisKelamin.text = itemData.jenisKelamin
    }

    override fun getItemCount(): Int {
        return this.data.size
    }
}