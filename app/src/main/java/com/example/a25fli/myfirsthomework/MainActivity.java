package com.example.a25fli.myfirsthomework;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.a25fli.myfirsthomework.model.NewsModel;

import java.util.List;

/**
 * Created by 25fli on 17.02.2019.
 */

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, NewsView{

    RecyclerView newsList;
    SwipeRefreshLayout mSwipeRefreshLayout;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {

    }

    @Override
    public void onError(String message) {
        String error = message == null ? "Ошибка" : message;
        Toast.makeText( this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(List<NewsModel> models) {

    }
}
