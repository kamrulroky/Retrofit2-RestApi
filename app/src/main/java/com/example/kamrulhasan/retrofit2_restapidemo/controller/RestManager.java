package com.example.kamrulhasan.retrofit2_restapidemo.controller;

import com.example.kamrulhasan.retrofit2_restapidemo.model.helper.Constants;
import com.example.kamrulhasan.retrofit2_restapidemo.model.service.FlowerService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kamrul hasan on 2/7/2017.
 */

public class RestManager {


    private FlowerService mFlowerService;

    public FlowerService getmFlowerService(){
        if (mFlowerService== null){

            Retrofit retrofit = new  Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mFlowerService = retrofit.create(FlowerService.class);



        }
        return mFlowerService;
    }
}
