package com.example.searchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var heart: ImageView
    private lateinit var search: EditText
    private lateinit var resultSearch: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        heart = findViewById(R.id.imageView)
        search = findViewById(R.id.edtSearch)
        resultSearch = findViewById(R.id.tvResult)

        heart.animation = AnimationUtils.loadAnimation(this, R.anim.anim_heart)

        search.addTextChangedListener(textWatcher)
    }

    private val textWatcher = object : TextWatcher {
        var someList = listOf("Eratani", "Ada untuk petani", "Di seluruh indonesia", "Era")
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val result = LinearSearch().search(someList,
                s.toString().lowercase(Locale.getDefault())
            )
            if (s.toString() == "") {
                resultSearch.text = ""
            } else {
                resultSearch.text = result
            }
        }
    }
}