package com.biodun.cathastrophy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.biodun.cathastrophy.databinding.RecyclerItemBinding

class CatsAdapter(private val cats: List<Cat>) : RecyclerView.Adapter<CatsAdapter.CatsViewHolder>() {
//    private val cats = mutableListOf<Cat>()

    inner class CatsViewHolder (private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bindView(cat: Cat){
            binding.itemTv1.text = cat.name
            binding.itemTv2.text = cat.weight


//            binding.itemIv1.load(breeds.) //load method is from coil library
//            binding.itemIv1.setImageResource(cats.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        return CatsViewHolder(
            RecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        val cat = cats[position]
        holder.bindView(cat)
    }

    override fun getItemCount(): Int {
        return cats.size
    }


}


//binding.fragTv1.text = cats.name
//binding.fragTv3.text = cats.weight
//binding.fragTv5.text = cats.life_span
//binding.fragTv6.text = cats.description
//binding.fragIv.setImageResource(cats.image)