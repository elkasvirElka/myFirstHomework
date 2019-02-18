package com.example.a25fli.myfirsthomework;

import android.support.v4.widget.SwipeRefreshLayout;

import org.json.JSONObject;

/**
 * Created by 25fli on 18.02.2019.
 */

public class NewsPresenter {
    NewsView view;
    SwipeRefreshLayout mSwipeRefreshLayout;
    public NewsPresenter(NewsView view, SwipeRefreshLayout mSwipeRefreshLayout){
        this.view = view;
        this.mSwipeRefreshLayout = mSwipeRefreshLayout;
        getNews();
    }
    private boolean requestInprogress = false;
    public void getNews() {
        //при refresh обновляем тоже самое кол-во записей

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
