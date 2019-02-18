package com.example.a25fli.myfirsthomework;

import com.example.a25fli.myfirsthomework.model.NewsModel;

import java.util.List;

public interface NewsView {
    void onError(String message);
    void onSuccess(List<NewsModel> models);
}
