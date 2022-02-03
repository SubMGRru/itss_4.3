package com.example.itss_43;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class MyMonthAdapter extends ArrayAdapter<MyMonth> {

    public MyMonthAdapter(Context context, MyMonth[] arr) {
        super(context, R.layout.adapter_item, arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final MyMonth month = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, null);
        }

// Заполняем адаптер
        ((TextView) convertView.findViewById(R.id.textView)).setText(month.name);
        ((TextView) convertView.findViewById(R.id.textView2)).setText(String.valueOf(month.money));
// Выбираем картинку для месяца
        if (month.flag_res == "cuba")
            ((ImageView) convertView.findViewById(R.id.imageView)).setImageResource(R.drawable.flag_cuba);
        else if (month.flag_res == "usa")
            ((ImageView) convertView.findViewById(R.id.imageView)).setImageResource(R.drawable.flag_united_states);
        else if (month.flag_res == "spain")
            ((ImageView) convertView.findViewById(R.id.imageView)).setImageResource(R.drawable.flag_spain);
        else if (month.flag_res == "mexico")
            ((ImageView) convertView.findViewById(R.id.imageView)).setImageResource(R.drawable.flag_mexico);
        else
            ((ImageView) convertView.findViewById(R.id.imageView)).setImageResource(R.drawable.flag_france);
        return convertView;
    }
}