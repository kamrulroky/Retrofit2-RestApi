package com.example.kamrulhasan.retrofit2_restapidemo.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kamrulhasan.retrofit2_restapidemo.R;
import com.example.kamrulhasan.retrofit2_restapidemo.model.Flower;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamrul hasan on 2/6/2017.
 */


//FOR RECYCLER VIEW

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {
    private static final String TAG = FlowerAdapter.class.getSimpleName();  //Override method
    private final FlowerClickListener mListener;


    private List<Flower> mFlowers;

    public FlowerAdapter(FlowerClickListener listener){
        mFlowers = new ArrayList<>();
        mListener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);

        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Flower currFlower = mFlowers.get(position);

        holder.mName.setText(currFlower.getName());
        holder.mPrice.setText("$"+Double.toString(Double.parseDouble(currFlower.getPrice())));
        Picasso.with(holder.itemView.getContext()).load("http://services.hanselandpetal.com/photos/"+currFlower.getPhoto()).into(holder.mPhoto);


    }

    @Override
    public int getItemCount() {
        return mFlowers.size();
    }

    public void addFlower(Flower flower) {

        Log.d(TAG,flower.getPhoto());
        mFlowers.add(flower);
        notifyDataSetChanged();

    }

    public Flower setSelectedFlower(int position) {
        return mFlowers.get(position);
    }


    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{       //creating Holder class and Constructor

        private ImageView mPhoto;
        private TextView mName,mPrice;

        public Holder(View itemView) {
            super(itemView);
            mPhoto = (ImageView) itemView.findViewById(R.id.flowerPhoto);
            mName = (TextView)itemView.findViewById(R.id.flowerName);
            mPrice = (TextView)itemView.findViewById(R.id.flowerPrice);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onclick(getLayoutPosition());

        }
    }

    public interface FlowerClickListener{
        void onclick(int position);
    }
}
