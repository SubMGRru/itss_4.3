package com.example.itss_43;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyMonthAdapter adapter = new MyMonthAdapter(this, makeMonth());
        ListView lv = (ListView) findViewById(R.id.countriesList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name =  ((MyMonth)parent.getItemAtPosition(position)).name;
                String url = "https://www.google.ru/search?q=" + name.replace(" ", "+");
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    MyMonth[] makeMonth() {
        MyMonth[] arr = new MyMonth[10];
        String[] monthArr = {"Bill Gates", "Warren Buffett", "Jeff Bezos", "Amancio Ortega", "Marc Zuckerberg", "Carlos Slim", "Larry Ellison", "Charles Koch", "David Koch", "Michael Bloomberg"};
        String[] flag = {"usa", "usa", "usa", "spain", "usa", "mexico", "usa", "usa", "usa", "usa"};
        String [] dayArr = {"$86 B", "$75.6 B", "$72.8 B", "$71.3 B", "$56 B", "$54.5 B", "$52.2 B", "$48.3 B", "$48.3 B", "$47.5 B"};

        for (int i = 0; i < arr.length; i++) {
            MyMonth month = new MyMonth();
            month.name = monthArr[i];
            month.flag_res = flag[i];
            month.money = dayArr[i];
            arr[i] = month;
        }
        return arr;
    }
}