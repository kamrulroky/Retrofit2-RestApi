package com.example.kamrulhasan.retrofit2_restapidemo.model;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by kamrul hasan on 2/6/2017.
 */

//CLASS FOR FLOWER JSON ARRAY AND OBJECT NAME.GETTER AND SETTER METHOD

public class Flower implements Serializable {


    @Expose
    private String category;

    @Expose
    private String price;

    @Expose
    private String instructions;

    @Expose
    private String photo;

    @Expose
    private String name;

    @Expose
    private int productId;
    private Bitmap picture;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(Bitmap picture){
        this.picture = picture;
    }

    public Bitmap getPicture() {

        return picture;
    }
}
