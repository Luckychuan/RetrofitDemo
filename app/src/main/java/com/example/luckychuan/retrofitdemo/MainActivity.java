package com.example.luckychuan.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.luckychuan.retrofitdemo.dao.ApiService;
import com.example.luckychuan.retrofitdemo.dao.Item;
import com.example.luckychuan.retrofitdemo.dao.Tab;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestItem();


    }

    private void requestItem() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.tngou.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        //获取tab
        Call<Tab> call = apiService.getTab();
        call.enqueue(new Callback<Tab>() {
            @Override
            public void onResponse(Call<Tab> call, Response<Tab> response) {
               Tab tab = response.body();
                if(tab.isStatus()){
                    for(Tab.TabData data: tab.getDataList()){
                        Log.d("MainActivity", "onResponse: "+data.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<Tab> call, Throwable t) {

            }
        });

        //获取item

        Call<Item> call1 = apiService.getItem(1);
        call1.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                Item item = response.body();
                if(item.isStatus()){
                    for(Item.ItemData data : item.getDataList()){
                        Log.d(TAG, "onResponse: "+data.toString());

                    }
                }
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {

            }
        });




    }
}
