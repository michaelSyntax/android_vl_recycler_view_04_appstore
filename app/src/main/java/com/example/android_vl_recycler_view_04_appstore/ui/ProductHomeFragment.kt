package com.example.android_vl_recycler_view_04_appstore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_vl_recycler_view_04_appstore.R
import com.example.android_vl_recycler_view_04_appstore.adapter.CategoryAdapter
import com.example.android_vl_recycler_view_04_appstore.data.Datasource
import com.example.android_vl_recycler_view_04_appstore.databinding.FragmentProductHomeBinding


class ProductHomeFragment : Fragment() {

    private lateinit var viewBinding: FragmentProductHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentProductHomeBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categories = Datasource().loadCategories()
        viewBinding.rvAppStore.adapter = CategoryAdapter(requireContext(), categories)
    }
}