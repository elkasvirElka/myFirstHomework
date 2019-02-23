package com.example.a25fli.myfirsthomework;

import android.content.Context;
import android.util.JsonReader;

import com.example.a25fli.myfirsthomework.model.NewsModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class JSONHelper {

    private static final String FILE_NAME = "vk_post.json";

    boolean exportToJSON(Context context, List<NewsModel> dataList) {

        Gson gson = new Gson();
        DataItems dataItems = new DataItems();
        dataItems.setData(dataList);
        String jsonString = gson.toJson(dataItems);

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fileOutputStream.write(jsonString.getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    static List<NewsModel> importFromJSON(Context context) throws UnsupportedEncodingException {

        InputStreamReader streamReader = null;
        InputStream fileInputStream = null;
        try{
            fileInputStream = context.getResources().openRawResource(R.raw.vk_posts);
            streamReader = new InputStreamReader(fileInputStream);
          //  streamReader.setLenient(true);
            Gson gson = new Gson();
          //  DataItems dataItems  = constructUsingGson(json, DataItems.class);


            DataItems  dataItems = gson.fromJson(streamReader, DataItems.class);
            return  dataItems.getData();
        } finally {
            if (streamReader != null) {
                try {
                    streamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static <T> T constructUsingGson(String jsonString, Class<T> type) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonString, type);
    }
    private class DataItems {
        @SerializedName("data")
        public List<NewsModel> data;

        List<NewsModel> getData() {
            return data;
        }
        void setData(List<NewsModel> data) {
            this.data = data;
        }
    }
}