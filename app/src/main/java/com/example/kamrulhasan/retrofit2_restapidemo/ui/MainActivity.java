package com.example.kamrulhasan.retrofit2_restapidemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kamrulhasan.retrofit2_restapidemo.R;
import com.example.kamrulhasan.retrofit2_restapidemo.controller.RestManager;
import com.example.kamrulhasan.retrofit2_restapidemo.model.Flower;
import com.example.kamrulhasan.retrofit2_restapidemo.model.adapter.FlowerAdapter;
import com.example.kamrulhasan.retrofit2_restapidemo.model.helper.Constants;
import com.example.kamrulhasan.retrofit2_restapidemo.model.helper.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements FlowerAdapter.FlowerClickListener {

    private RecyclerView mRecyclerView;
    private RestManager mManager;
    private FlowerAdapter mFlowerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        configView();

        mManager = new RestManager();

        if(Utils.isNetworkAvailable(getApplicationContext())) {
            getFeed();
        }
        else {
            getFeedFromDB();
        }


    }

    private void getFeedFromDB() {

    }

    private void getFeed() {

        Call<List<Flower>> listCall =mManager.getmFlowerService().getAllFlowers();
        listCall.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {

                if (response.isSuccessful()){
                    List<Flower>flowerList = response.body();

                    for (int i=0;i<flowerList.size();i++){

                        Flower flower = flowerList.get(i);
                        mFlowerAdapter.addFlower(flower);
                    }
                }
                else {
                    int sc = response.code();
                    switch (sc){

                    }
                }

            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {

            }
        });
    }

    private void configView() {
        mRecyclerView= (RecyclerView)this.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));

         mFlowerAdapter=new FlowerAdapter(this);

        mRecyclerView.setAdapter(mFlowerAdapter);
    }


    @Override
    public void onclick(int position) {
        Flower selectedFlower = mFlowerAdapter.setSelectedFlower(position);
        Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
        intent.putExtra(Constants.REFERENCE.FLOWER,selectedFlower);
        startActivity(intent);
    }
}
