package com.example.mavlianov_hw7_month3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mavlianov_hw7_month3.databinding.FragmentDetailBinding
import java.io.Serializable


@Suppress("DEPRECATION")
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val car: Car = arguments?.getSerializable("car") as Car
            car.let { car ->
                textViewBrand.text = car.brand
                textViewCost.text = car.cost
                textViewDesc.text = car.desc
                Glide.with(imageView).load(car.image).into(imageView)

                buttonCall.setOnClickListener {
                    val callIntent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:${car.phoneNumber}")
                    }
                    startActivity(callIntent)
                }

                buttonWhatsApp.setOnClickListener {
                    val whatsappIntent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse("https://api.whatsapp.com/send?phone=${car.phoneNumber}")
                    }
                    startActivity(whatsappIntent)
                }
            }
        }
    }


}