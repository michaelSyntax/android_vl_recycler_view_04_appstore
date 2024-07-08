package com.example.android_vl_recycler_view_04_appstore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_vl_recycler_view_04_appstore.data.model.Product
import com.example.android_vl_recycler_view_04_appstore.databinding.ListItemProductBinding

class ProductAdapter(
    private val products: List<Product>
): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val vb: ListItemProductBinding): RecyclerView.ViewHolder(vb.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val viewBinding = ListItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
       val product = products[position]
        holder.vb.tvProductName.text = product.name
    }
}