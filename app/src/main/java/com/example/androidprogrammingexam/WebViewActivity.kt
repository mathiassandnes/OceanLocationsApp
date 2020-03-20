package com.example.androidprogrammingexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {


    companion object{
        const val LINK = "LINK"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        var link  = ""

        if(this?.intent.hasExtra(LINK)){
            link = this?.intent.getStringExtra(LINK)
        }

        webView.loadUrl(link)
    }
}