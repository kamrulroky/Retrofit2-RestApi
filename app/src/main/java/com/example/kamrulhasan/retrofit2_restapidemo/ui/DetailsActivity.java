package com.example.kamrulhasan.retrofit2_restapidemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kamrulhasan.retrofit2_restapidemo.R;
import com.example.kamrulhasan.retrofit2_restapidemo.model.Flower;
import com.example.kamrulhasan.retrofit2_restapidemo.model.helper.Constants;
import com.squareup.picasso.Picasso;

/**
 * Created by kamrul hasan on 2/8/2017.
 */

public class DetailsActivity extends AppCompatActivity {

    private ImageView mPhoto;
    private TextView mName,mID,mCategory,mInstruction,mPrice;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        Flower flower = (Flower) intent.getSerializableExtra(Constants.REFERENCE.FLOWER);

        configViews();

        mName.setText(flower.getName());
        mPrice.setText("$"+Double.toString(Double.parseDouble(flower.getPrice())));
        mID.setText("" + flower.getProductId());
        mCategory.setText(flower.getCategory());
        mInstruction.setText(flower.getInstructions());
        Picasso.with(getApplicationContext()).load("http://services.hanselandpetal.com/photos/"+ flower.getPhoto()).into(mPhoto);
    }

    private void configViews() {
        mPhoto = (ImageView) findViewById(R.id.flowerPhoto);
        mName = (TextView)findViewById(R.id.flowerName);
        mPrice = (TextView)findViewById(R.id.flowerPrice);
        mCategory = (TextView)findViewById(R.id.flowerCategory);
        mID = (TextView)findViewById(R.id.flowerID);
        mInstruction = (TextView)findViewById(R.id.flowerInstruction);

    }
}
