package com.example.luckychuan.retrofitdemo.dao;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Luckychuan on 2017/4/10.
 */
public interface ApiService {

    //获得标题数据
    @GET("api/lore/classify")
    Call<Tab> getTab();

    @GET("api/lore/list")
    Call<Item> getItem(@Query("id") int id);


}
