package com.example.mavlianov_hw7_month3

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mavlianov_hw7_month3.databinding.ItemCarBinding
import android.view.LayoutInflater as LayoutInflater1

class CarAdapter(var carlist: ArrayList<Car>, var onClick: (position: Int) -> Unit) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    inner class CarViewHolder(val binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(car: Car){
            binding.apply{
                textViewCost.text = car.cost
                textViewBrand.text = car.brand
                Glide.with(itemView).load(car.image).into(imageView)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater1.from(parent.context),parent,false)
        return CarViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return carlist.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.onBind(carlist[position])
        holder.itemView.setOnClickListener{
            onClick(position)
        }
    }
}