package com.example.aksesoris_hp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.aksesoris_hp.R
import com.example.aksesoris_hp.model.accessoris

class accessorisListAdapter(
    private val onItemClickListener: (accessoris) -> Unit
): ListAdapter<accessoris, accessorisListAdapter.accessorisViewHolder>(WORDS_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): accessorisViewHolder {
        return accessorisViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: accessorisViewHolder, position: Int) {
        val accessoris=getItem(position)
        holder.bind(accessoris)
        holder.itemView.setOnClickListener{
            onItemClickListener(accessoris)
        }
    }

    class accessorisViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.namaTextView)
        private val addressTextView: TextView = itemView.findViewById(R.id.addressTextView2)

        fun bind(accessoris: accessoris?) {
            nameTextView.text=accessoris?.name
            addressTextView.text=accessoris?.address
        }

        companion object {
            fun create(parent: ViewGroup): accessorisListAdapter.accessorisViewHolder {
                val view: View= LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_accessoris, parent, false)
                return accessorisViewHolder(view)
            }
        }
    }
    companion object{
            private val WORDS_COMPARATOR=object :DiffUtil.ItemCallback<accessoris>(){
                override fun areItemsTheSame(oldItem: accessoris, newItem: accessoris): Boolean {
                    return oldItem==newItem
                }

                override fun areContentsTheSame(oldItem: accessoris, newItem: accessoris): Boolean {
                    return oldItem.id==newItem.id
                }
            }
    }
}