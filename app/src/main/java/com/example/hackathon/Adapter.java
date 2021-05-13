package com.example.hackathon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class Adapter extends ArrayAdapter<Event> {

    private LayoutInflater inflater;
    private int layout;
    private List<Event> states;

    public Adapter(Context context, int resource, List<Event> states) {
        super(context, resource, states);
        this.states = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Event state = states.get(position);

        viewHolder.imageView.setImageBitmap(state.getPhoto());
        viewHolder.nameView.setText(state.getName());
        viewHolder.capitalView.setText(state.getDate().toString());

        return convertView;
    }

    private class ViewHolder {
        final ImageView imageView;
        final TextView nameView, capitalView;

        ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.imageView2);
            nameView = (TextView) view.findViewById(R.id.textView2);
            capitalView = (TextView) view.findViewById(R.id.textView3);
        }
    }
}