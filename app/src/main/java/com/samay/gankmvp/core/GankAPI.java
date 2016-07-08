package com.samay.gankmvp.core;

import com.samay.gankmvp.mode.AllData;
import com.samay.gankmvp.mode.AndroidData;
import com.samay.gankmvp.mode.IOSData;
import com.samay.gankmvp.mode.WelfareData;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by shaohua.li on 7/7/16.
 */
public interface GankAPI {
    @GET("data/Android/{pagesize}/{page}")
    Observable<AllData> getALLs(@Path("pagesize") int pagesize,@Path("page") int page);

    @GET("data/iOS/{pagesize}/{page}")
    Observable<IOSData> getIOSs(@Path("pagesize") int pagesize,@Path("page") int page);

    @GET("data/Android/{pagesize}/{page}")
    Observable<AndroidData> getAndroids(@Path("pagesize") int pagesize,@Path("page") int page);

    @GET("data/福利/{pagesize}/{page}")
    Observable<WelfareData> getWelfare(@Path("pagesize") int pagesize,@Path("page") int page);
}
