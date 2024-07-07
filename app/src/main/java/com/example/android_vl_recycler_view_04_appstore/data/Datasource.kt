package com.example.android_vl_recycler_view_04_appstore.data

import com.example.android_vl_recycler_view_04_appstore.data.model.Category
import com.example.android_vl_recycler_view_04_appstore.data.model.Product
import kotlin.random.Random
import kotlin.random.asJavaRandom

class Datasource {
    fun loadProducts(count: Int = 100): List<Product> {
        val products = mutableListOf<Product>()
        for (i in 1..count) {
            products.add(generateRandomProduct())
        }
        return products
    }

    fun loadCategories(): List<Category> {
        return listOf(
            Category("Entertainment", loadProducts()),
            Category("Social Networking", loadProducts()),
            Category("Life Style", loadProducts()),
            Category("Photo & Video", loadProducts()),
            Category("Education", loadProducts()),
            Category("Health & Fitness", loadProducts()),
            Category("Photo & Video", loadProducts()),
            Category("Productivity", loadProducts()),
            Category("Photo & Video", loadProducts()),
            Category("Utilities", loadProducts()),
            Category("Books", loadProducts()),
            Category("Sports", loadProducts()),
            Category("Music", loadProducts()),
            Category("Business", loadProducts()),
            Category("Graphics & Design", loadProducts()),
            Category("Navigation", loadProducts()),
            Category("Reference", loadProducts()),
            Category("Travel", loadProducts()),
            Category("News", loadProducts()),
            Category("Fiance", loadProducts()),
            Category("Medical", loadProducts()),
            Category("Travel", loadProducts()),
            Category("Weather", loadProducts()),
            Category("Developer Tools", loadProducts()),
            Category("Travel", loadProducts()),
            Category("Shopping", loadProducts()),
            Category("Kids", loadProducts()),
            Category("Magazine & Newspapers", loadProducts())
        )
    }

    private fun generateRandomProduct(): Product {
        val randomName = generateReadableName()
        return Product(randomName, 4.5, "", 1, 4.5)
    }

    fun generateReadableName(): String {
        val consonants = "bcdfghjklmnpqrstvwxyz"
        val vowels = "aeiou"
        val random = Random.asJavaRandom()

        val name = StringBuilder()
        name.append(consonants[random.nextInt(consonants.length)].uppercaseChar()) // Start with capital consonant

        // Alternate between consonants and vowels for better readabilityfor (i in 1..5) {
        //val charSet = if (i % 2 == 0) consonants else vowels
        //name.append(charSet[random.nextInt(charSet.length)])
        return name.toString()
    }
}