package com.example.android_vl_recycler_view_04_appstore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_vl_recycler_view_04_appstore.data.model.Category
import com.example.android_vl_recycler_view_04_appstore.databinding.ListItemCategoryBinding

class CategoryAdapter(
    private val context: Context,
    private val categories: List<Category>
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(val vb: ListItemCategoryBinding): RecyclerView.ViewHolder(vb.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val viewBinding = ListItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.vb.tvCategoryTitle.text = category.name
        holder.vb.rvProducts.adapter = ProductAdapter(context, category.products)
        holder.vb.rvProducts.isNestedScrollingEnabled = false
    }
}