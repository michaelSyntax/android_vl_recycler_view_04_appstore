package com.example.android_vl_recycler_view_04_appstore.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.android_vl_recycler_view_04_appstore.R
import com.example.android_vl_recycler_view_04_appstore.adapter.EXTRA_KEY_PRODUCT_NAME
import com.example.android_vl_recycler_view_04_appstore.databinding.FragmentProductDetailBinding


class ProductDetailFragment : Fragment() {

    private lateinit var vb: FragmentProductDetailBinding
    private val args: ProductDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentProductDetailBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vb.tvProductName.text = args.productTitleId

        vb.btShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "productName")
            intent.type = "text/plain"

            val shareIntent = Intent.createChooser(intent, "Product")
            startActivity(shareIntent)
        }
    }
}