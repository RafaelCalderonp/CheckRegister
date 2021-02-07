package com.example.checkregister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.checkregister.databinding.FragmentSecondBinding
import com.example.checkregister.viewModel.ItemViewModel
import androidx.lifecycle.Observer


class SecondFragment : Fragment() {
    private lateinit var mBinding: FragmentSecondBinding
    private val mViewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSecondBinding.inflate(inflater, container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter =ItemAdapter()
        mBinding.recyclerView.adapter = adapter
        mBinding.recyclerView.layoutManager = LinearLayoutManager(context)
        mViewModel.allItem.observe(viewLifecycleOwner, Observer {
            it?.let{
                adapter.update(it)
            }
            mBinding.fbBorrar.setOnClickListener {
                mViewModel.deleteAll()
            }

        })

    }
}