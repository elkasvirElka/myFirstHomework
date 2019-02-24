package com.example.a25fli.myfirsthomework;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.a25fli.myfirsthomework.model.NewsModel;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.example.a25fli.myfirsthomework.JSONHelper.importFromJSON;


/**
 * Created by 25fli on 18.02.2019.
 */
//Лайк и передача параметров
    //Дата - возврат 7 дней назад или дату
public class NewsPresenter {
    NewsView view;
    Context context;
    SwipeRefreshLayout mSwipeRefreshLayout;
    public NewsPresenter(NewsView view, SwipeRefreshLayout mSwipeRefreshLayout, Context context){
        this.view = view;
        this.mSwipeRefreshLayout = mSwipeRefreshLayout;
        this.context = context;
        getNews();
    }
    private boolean requestInprogress = false;
    public void getNews() {
        requestInprogress = true;
        //при refresh обновляем тоже самое кол-во записей
        List<NewsModel> items = new ArrayList<>();
        try {
            items = importFromJSON(context);
            mSwipeRefreshLayout.setRefreshing(false);
            requestInprogress = false;
            view.onSuccess(items);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            view.onError(e.getMessage());
        }
    }

    RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            getNews();
        }
    };
}
