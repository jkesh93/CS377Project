package com.example.jay.cs377project;


import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 9/28/2016.
 */

public class ListDataAdapter extends ArrayAdapter{
    List list = new ArrayList();

    static class LayoutHandler{
        TextView title, category, rating, review;
    }


    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
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

    public Object getItem(int position){
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;

        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.review_layout_close, parent, false);
            layoutHandler = new LayoutHandler();
            layoutHandler.title = (TextView) row.findViewById(R.id.title_LC);
            layoutHandler.category = (TextView) row.findViewById(R.id.category_LC);
            layoutHandler.rating = (TextView) row.findViewById(R.id.rating_LC);
            layoutHandler.review = (TextView) row.findViewById(R.id.review_LC);

            row.setTag(layoutHandler);

        }
        else{
            layoutHandler =(LayoutHandler) row.getTag();
        }

        DataProvider dataProvider = (DataProvider) this.getItem(position);

        return row;

    }
}
