package com.example.denpa.ghostshuttle;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * Created by denpa on 2018/01/17.
 */

public class ColorAdapter extends ArrayAdapter<ColorGridItem> {

    private int mResource;
    private List<ColorGridItem> mItems;
    private LayoutInflater mInflater;

    public ColorAdapter(Context context, int resource, List<ColorGridItem> items) {
        super(context, resource, items);
        mResource = resource;
        mItems = items;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView != null) {
            view = convertView;
        }
        else {
            view = mInflater.inflate(mResource, null);
        }

        // リストビューに表示する要素を取得
        ColorGridItem item = mItems.get(position);
        RoundedImageView thumbnail = view.findViewById(R.id.icon);
        thumbnail.setBackgroundColor(Color.parseColor(item.getColor()));

        return view;
    }

}