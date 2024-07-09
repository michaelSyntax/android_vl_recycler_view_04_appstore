package com.example.android_vl_recycler_view_04_appstore.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_vl_recycler_view_04_appstore.R
import com.example.android_vl_recycler_view_04_appstore.data.model.Product
import com.example.android_vl_recycler_view_04_appstore.databinding.ListItemProductBinding
import com.example.android_vl_recycler_view_04_appstore.ui.ProductDetailActivity
import com.google.android.material.card.MaterialCardView
import com.google.android.material.color.MaterialColors.getColor
import com.google.android.material.snackbar.Snackbar

const val EXTRA_KEY_PRODUCT_NAME = "PRODUCT_NAME"

class ProductAdapter(
    private val context: Context,
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

        holder.vb.root.setOnClickListener {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtra(EXTRA_KEY_PRODUCT_NAME, product.name)
            intent.putExtra("Prodcut_price", 3)
            context.startActivity(intent)
        }
    }
}