package com.example.androidprogrammingexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidprogrammingexam.adaptor.NewsFeedAdapter
import com.example.androidprogrammingexam.api.DummyNews
import com.example.androidprogrammingexam.gsontypes.NewsStory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener /*Implementing OnClickListener*/ {

    var newsEndpoint = "https://www.vg.no/rss/feed/?format=json" // web api link

    lateinit var adapter: NewsFeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme) // splash screen
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        //Setting up recyclerView view
        adapter = NewsFeedAdapter() // Empty adapter
        recyclerView.layoutManager = LinearLayoutManager(this) // We want the list to be linear & vertical list
        recyclerView.adapter = adapter // associating the adapter with recyclerView

        adapter.onClickListener = this // clicking listening interface association

        updateNews(DummyNews.getNews()) // getting dummy feed for layout implementation


    }

    // Refreshing the news feed
    private fun updateNews( feed: ArrayList<NewsStory>) {
        adapter.list = feed // setting new feed ArrayList
        adapter.notifyDataSetChanged() // This notifies the adapter that data has changed. RecyclerView needs refresh
    }


    override fun onClick(v: View?) {

        var newsItem = v?.tag as NewsStory

        Intent(this, WebViewActivity::class.java).also {intent->
            intent.putExtra(WebViewActivity.LINK,newsItem.url)
            startActivity(intent)
        }

    }
}