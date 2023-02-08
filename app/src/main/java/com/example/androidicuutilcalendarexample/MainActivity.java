package com.example.androidicuutilcalendarexample;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv);

        // 현재 날짜를 가지고 와서 출력
        tv.setText(Calendar.getInstance().getTime().toString());

        // 현재 날짜의 년월일 추출
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        // 년월일 로그
        Log.i(this.getClass().getSimpleName(), "year = " + year);
        Log.i(this.getClass().getSimpleName(), "month = " + month);
        Log.i(this.getClass().getSimpleName(), "day = " + day);

        // "2023-02-07 19:55:45" 이 날짜를 Calendar에 넣어서 년월일 추출하고 tv에 출력, 년월일 로그에 출력
        String date = "2000-01-22 03:33:52";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            calendar.setTime(sdf.parse(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        tv.setText(calendar.getTime().toString());
        Log.i(this.getClass().getSimpleName(), "year = " + calendar.get(Calendar.YEAR));
        Log.i(this.getClass().getSimpleName(), "month = " + calendar.get(Calendar.MONTH) + 1);
        Log.i(this.getClass().getSimpleName(), "day = " + calendar.get(Calendar.DAY_OF_MONTH));

        // date와 현재의 DAY_OF_YEAR 로그 찍어보기
        Log.i(this.getClass().getSimpleName(), "date = " + calendar.get(Calendar.DAY_OF_YEAR));
        Log.i(this.getClass().getSimpleName(), "today = " + Calendar.getInstance().get(Calendar.DAY_OF_YEAR) + 1);

        // date와 현재의 DATE 로그 찍어보기
        Log.i(this.getClass().getSimpleName(), "date = " + calendar.get(Calendar.DATE));
        Log.i(this.getClass().getSimpleName(), "today = " + Calendar.getInstance().get(Calendar.DATE));
    }
}