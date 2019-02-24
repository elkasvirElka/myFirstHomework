package com.example.a25fli.myfirsthomework.utils;

import com.example.a25fli.myfirsthomework.App;
import com.example.a25fli.myfirsthomework.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 25fli on 23.02.2019.
 */

public class DateUtils {
    static ArrayList<String> monthes = null;
    public static String getDate(Long timeStamp) {
        if(timeStamp == null){
            return "";
        }
        timeStamp = timeStamp*1000L;
        if ( monthes == null ) {
            monthes = new ArrayList<>(Arrays.asList(App.getContext().getResources().getStringArray(R.array.monthes)));
        }
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeStamp);
        int month =  cal.get(Calendar.MONTH);
        int day =  cal.get(Calendar.DAY_OF_MONTH);
        int hour =  cal.get(Calendar.HOUR_OF_DAY);
        int minutes =  cal.get(Calendar.MINUTE);
        String date = day + " " + monthes.get(month) + ", " + hour + ":" + (minutes<10 ? "0"+minutes : minutes);

        return date;
    }
    public static long getDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long dateLong = date.getTime();
        return dateLong;
    }

}
