package com.example.a25fli.myfirsthomework;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 25fli on 23.02.2019.
 */

public class NewsOneActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_one);
        ImageView image = findViewById(R.id.news_image);
        TextView title = findViewById(R.id.news_title);
        ImageView ava = findViewById(R.id.ava_image);
        TextView name = findViewById(R.id.name);
        TextView post_data = findViewById(R.id.post_data);
        TextView like_count = findViewById(R.id.like_count);
        TextView repost_count = findViewById(R.id.repost_count);
        TextView comment_count = findViewById(R.id.comment_count);
    }
}
