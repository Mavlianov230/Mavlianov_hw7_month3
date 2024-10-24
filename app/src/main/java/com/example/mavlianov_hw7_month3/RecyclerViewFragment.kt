package com.example.mavlianov_hw7_month3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mavlianov_hw7_month3.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerViewBinding
    private lateinit var adapter: CarAdapter
    private var carlist = arrayListOf<Car>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerViewBinding.inflate(layoutInflater)
      return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        initAdapter()
    }

    private fun loadData() {
        carlist.add(Car("Mk4 Toyota Supra", "Toyota", "\$65000", "https://i.etsystatic.com/40475019/r/il/34e632/4831033008/il_fullxfull.4831033008_qkz8.jpg", "1234567890"))
        carlist.add(Car("BMW M5 F90", "BMW", "\$36800", "https://i.pinimg.com/736x/3a/8c/95/3a8c957d7a6a6540510c45b99c8ff3d5.jpg", "0987654321"))
        carlist.add(Car("Audi RS7 ", "Audi", "\$59500", "https://cdn.motor1.com/images/mgl/7ZmbmJ/s1/audi-rs7-by-abt.jpg", "1122334455"))
        carlist.add(Car("Mercedes Benz W218 CLS63 AMG", "Mercedes", "\$45000", "https://preview.redd.it/icgpf4uw4ad91.png?width=640&crop=smart&auto=webp&s=76bda47082b2cc482bf0124785b518581c32de14", "2233445566"))
        carlist.add(Car("Lamborghini Huracan EVO by ZACOE - Interior, Exterior and Drive", "Lamborghini", "\$488800", "https://i.ytimg.com/vi/MG4AAcV9Pc0/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLDN_0jWQ5wpqcSgJ2QgYKvDwW_Dmw", "3344556677"))
    }


    private fun initAdapter() {
        adapter = CarAdapter(carlist) { position ->

            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view,DetailFragment().apply {
                val bundle:Bundle = Bundle().apply {
                    putSerializable("car", carlist[position])
                }
                arguments = bundle

            }).addToBackStack(null).commit()

            Toast.makeText(requireContext(),"Clicked ${carlist[position].brand}", Toast.LENGTH_SHORT).show()


        }
        binding.recyclerView.adapter = adapter
    }

}