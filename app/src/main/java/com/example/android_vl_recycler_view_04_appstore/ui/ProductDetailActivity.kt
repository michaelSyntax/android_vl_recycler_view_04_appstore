package com.example.android_vl_recycler_view_04_appstore.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_vl_recycler_view_04_appstore.R
import com.example.android_vl_recycler_view_04_appstore.adapter.EXTRA_KEY_PRODUCT_NAME
import com.example.android_vl_recycler_view_04_appstore.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var vb: ActivityProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityProductDetailBinding.inflate(layoutInflater)
        enableEdgeToEdge()

        setContentView(vb.root)

        val productName = intent.extras?.getString(EXTRA_KEY_PRODUCT_NAME)
        vb.tvProductName.text = productName

        vb.btShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, productName)
            intent.type = "text/plain"

            val shareIntent = Intent.createChooser(intent, "Product")
            startActivity(shareIntent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}