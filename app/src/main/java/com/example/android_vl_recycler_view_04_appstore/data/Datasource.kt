package com.example.android_vl_recycler_view_04_appstore.data

import com.example.android_vl_recycler_view_04_appstore.data.model.Category
import com.example.android_vl_recycler_view_04_appstore.data.model.Product
import java.util.Collections
import java.util.Stack
import kotlin.random.Random

class Datasource {
    private fun loadProducts(count: Int = 100): List<Product> {
        val products = mutableListOf<Product>()
        for (i in 1..count) {
            products.add(generateRandomProduct()) // Default count is set 50, generateRandomProduct(1)
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

    private fun generateRandomProduct(count: Int = 50): Product {
        val name = StringBuilder()
        val randomMaxIntBetweenTwoAnd50 = (2..count).random()
        for (i in 1..randomMaxIntBetweenTwoAnd50) {
            name.append("${generateReadableName()} ")
        }
        return Product(name.toString(), getRandomColor())
    }

    private fun generateReadableName(): String {
        val consonants = "bcdfghjklmnpqrstvwxyz"
        val vowels = "aeiou"
        val random = Random.Default
        val name = StringBuilder()
        val randomMaxIntBetweenTwoAnd10 = (2..10).random()
        val firstChar = consonants[random.nextInt(consonants.length)].uppercaseChar()

        name.append(firstChar)

        for (i in 1..randomMaxIntBetweenTwoAnd10) {
            val charSet = if (i % 2 == 0) consonants else vowels
            val nextChar = charSet[random.nextInt(charSet.length)]
            name.append(nextChar)
        }

        return name.toString()
    }

    // https://stackoverflow.com/questions/5280367/android-generate-random-color-on-click
    private fun getSemiRandomColor(): Int {
        val recycle: Stack<Int> = Stack()
        val colors:Stack<Int> = Stack()

        recycle.addAll(
            listOf(
                // ARGB hex to int >> (0xFFEE5670.toInt(),...)
                -0xbbcca, -0x16e19d, -0x63d850, -0x98c549,
                -0xc0ae4b, -0xde690d, -0xfc560c, -0xff432c,
                -0xff6978, -0xb350b0, -0x743cb6, -0x3223c7,
                -0x14c5, -0x3ef9, -0x6800, -0xa8de,
                -0x86aab8, -0x616162, -0x9f8275, -0xcccccd
            )
        )

        if (colors.size == 0) {
            while (!recycle.isEmpty()) colors.push(recycle.pop())
        }

        Collections.shuffle(colors)
        val randomColor = colors.pop()
        recycle.push(randomColor)

        return randomColor
    }

    private fun getRandomColor(): Int {
        return  (Math.random() * 16777215).toInt() or (0xFF shl 24)
    }
}