package com.example.demo

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


class DetailActivity : AppCompatActivity() {
    lateinit var imgBanner: ImageView
    lateinit var tvContent: TextView
    lateinit var tvWebView: TextView
    lateinit var tvTitle: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        tvWebView = findViewById(R.id.tv_link_to_webview)
        imgBanner = findViewById(R.id.imgBanner)
        tvContent = findViewById(R.id.tv_content)
        tvTitle = findViewById(R.id.title_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        val people = intent.getSerializableExtra("data") as? ItemPhimLe
        val introduction = intent.getStringExtra("introduction")
        val image = intent.getStringExtra("image")
        val name = intent.getStringExtra("name")
        val url = intent.getStringExtra("url")
        supportActionBar?.title = name
        tvTitle.text = name
        tvContent.text = introduction
        tvWebView.text = url
        tvContent.text = introduction
        Picasso.get().load(image).into(imgBanner)
        tvWebView.setOnClickListener {
            val intent = Intent(this@DetailActivity, WebviewActivity::class.java)
            intent.putExtra("url", url)
            this.startActivity(intent)
        }
        tvWebView.setPaintFlags(tvWebView.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}