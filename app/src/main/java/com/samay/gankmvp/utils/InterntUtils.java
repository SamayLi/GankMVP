package com.samay.gankmvp.utils;

import com.samay.gankmvp.core.GankAPI;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shaohua.li on 7/7/16.
 */
public class InterntUtils {
    private GankAPI gankAPI;

    public InterntUtils() {
        OkHttpClient client=new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        gankAPI=retrofit.create(GankAPI.class);
    }

    public GankAPI getGankAPI(){
        return gankAPI;
    }
}
