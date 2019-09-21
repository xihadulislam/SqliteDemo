package com.cra.sqlitedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {


    Context context;
    List<String > namelist;
    List<String > addresslist;
    List<String > phonelist;

    public MyAdapter(Context context, List<String> namelist, List<String> addresslist, List<String> phonelist) {
        this.context = context;
        this.namelist = namelist;
        this.addresslist = addresslist;
        this.phonelist = phonelist;
    }


    @Override
    public int getCount() {
        return namelist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {



        view = LayoutInflater.from(context).inflate(R.layout.itemview,null,false);


        TextView tname,tadd,tphone;

        tname = view.findViewById(R.id.itemname);
        tadd = view.findViewById(R.id.itemadd);
        tphone = view.findViewById(R.id.itemphone);


        tname.setText(namelist.get(i));
        tadd.setText(addresslist.get(i));
        tphone.setText(phonelist.get(i));


        return view;

    }
}
