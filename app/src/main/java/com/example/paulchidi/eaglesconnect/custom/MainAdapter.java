package com.example.paulchidi.eaglesconnect.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paulchidi.eaglesconnect.R;
import com.example.paulchidi.eaglesconnect.activities.MainBookActivity;

/**
 * Created by Paul Chidi on 3/26/2016.
 */
public class MainAdapter extends BaseAdapter {

    private static LayoutInflater inflater;
    String[] result;
    Context context;
    int[] imageId;

    public MainAdapter(MainBookActivity mainBookActivity, String[] nameList, int[] images) {

        result = nameList;
        context = mainBookActivity;
        imageId = images;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.mainbook_list, null);
        holder.tvName = (TextView) rowView.findViewById(R.id.textView_name);
        holder.ivAvatar = (ImageView) rowView.findViewById(R.id.imageView_avatar);
        holder.tvName.setText(result[position]);
        holder.ivAvatar.setImageResource(imageId[position]);
        /*rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You tapped " + result[position], Toast.LENGTH_LONG).show();
            }
        });*/
        return rowView;
    }

    public class Holder {
        TextView tvName;
        ImageView ivAvatar;
    }
}
