package com.example.picturematch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class imdAdapter extends BaseAdapter {

    private Context context;
    private int [] drawables;
    public  imdAdapter(Context context, int[] drawables){
        this.context=context;
        this.drawables = drawables;
    }

    @Override
    public int getCount() {
        return drawables.length * 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView==null){

            imageView =new ImageView(this.context);
            if(drawables.length<=4)
                imageView.setLayoutParams(new ViewGroup.LayoutParams(420,420));
            else
                imageView.setLayoutParams(new ViewGroup.LayoutParams(320,320));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        else
            imageView=(ImageView)convertView;

        imageView.setImageResource(R.drawable.im0);


        return imageView;
    }
}

















//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.GridView;
//import android.widget.ImageView;
//
//public class imdAdapter extends BaseAdapter {
//
//    private Context context;
//    public  imdAdapter(Context context){
//        this.context=context;
//
//
//
//
//    }
//    @Override
//    public int getCount() {
//        return 4;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView imageView;
//        if(convertView==null){
//
//            imageView =new ImageView(this.context);
//            imageView.setLayoutParams(new ViewGroup.LayoutParams(420,420));
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//        }
//        else
//            imageView=(ImageView)convertView;
//            imageView.setImageResource(R.drawable.im0);
//
//
//        return imageView;
//    }
//}
