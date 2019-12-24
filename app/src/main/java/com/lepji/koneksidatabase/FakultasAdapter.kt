package com.lepji.koneksidatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FakultasAdapter (val context: Context, val listFakultas: ArrayList<FakultasModel>)
    : RecyclerView.Adapter<FakultasAdapter.FakultasViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FakultasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fakultas_layout, parent, false)

        return FakultasViewHolder(view)
    }

    override fun getItemCount(): Int = listFakultas!!.size



    override fun onBindViewHolder(holder: FakultasViewHolder, position: Int) {
        val currentPosition = listFakultas[position]

        holder.kodeFakultas.text = currentPosition.kode_fakultas
        holder.namaFakultas.text = currentPosition.nama_fakultas
    }

    class FakultasViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val kodeFakultas : TextView = itemView.findViewById<TextView>(R.id.kodeFakultas)
        val namaFakultas : TextView = itemView.findViewById<TextView>(R.id.namaFakultas)

    }

}