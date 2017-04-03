package com.example.kamrulhasan.retrofit2_restapidemo.model.service;

import com.example.kamrulhasan.retrofit2_restapidemo.model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kamrul hasan on 2/7/2017.
 */

public interface FlowerService {
    @GET("/feeds/flowers.json")
    Call<List<Flower>> getAllFlowers();
}
