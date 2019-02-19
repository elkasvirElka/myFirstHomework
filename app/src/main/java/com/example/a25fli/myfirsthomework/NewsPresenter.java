package com.example.a25fli.myfirsthomework;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.a25fli.myfirsthomework.model.NewsModel;

import org.json.JSONObject;

import java.util.List;

import static com.example.a25fli.myfirsthomework.JSONHelper.importFromJSON;


/**
 * Created by 25fli on 18.02.2019.
 */

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
        //при refresh обновляем тоже самое кол-во записей

        List<NewsModel> items = importFromJSON(context);

        requestInprogress = true;
        /*RetrofitClientInstance.service.getNews(currentPage + 1 ).enqueue(new Callback<NewsListModel>() {
            @Override
            public void onResponse(Call<NewsListModel> call, Response<NewsListModel> response) {
                requestInprogress = false;
                if ( response.body() != null && response.isSuccessful()) {
                    currentPage = response.body().page;
                    pageCount = response.body().totalPages;
                    view.onSuccess(response.body().news);
                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        view.onError(jObjError.getString("message"));
                    } catch (Exception e) {
                        e.printStackTrace();
                        view.onError(null);
                    }
                }

                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<NewsListModel> call, Throwable t) {
                requestInprogress = false;
                view.onError(null);
            }
        });*/
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
