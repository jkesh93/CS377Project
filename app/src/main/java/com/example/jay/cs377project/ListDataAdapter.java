package com.example.jay.cs377project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 9/28/2016.
 */

public class ListDataAdapter extends ArrayAdapter{

    List list = new ArrayList();


    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
        TextView title;
        TextView category;
        TextView rating;
        TextView review;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position){

        return list.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            layoutHandler = new LayoutHandler();
            layoutHandler.title = (TextView) row.findViewById(R.id.title_RL);
            layoutHandler.category = (TextView) row.findViewById(R.id.category_RL);
            layoutHandler.rating = (TextView) row.findViewById(R.id.rating_RL);
            layoutHandler.review = (TextView) row.findViewById(R.id.review_RL);
            row.setTag(layoutHandler);
        }
        else{
            layoutHandler =(LayoutHandler) row.getTag();
        }
        DataProvider dataProvider = (DataProvider) this.getItem(position);
        layoutHandler.title.setText(dataProvider.getTitle());
        layoutHandler.category.setText(dataProvider.getCategory());
        layoutHandler.rating.setText(dataProvider.getRating());
        layoutHandler.review.setText(dataProvider.getReview());
        return row;

    }
}
