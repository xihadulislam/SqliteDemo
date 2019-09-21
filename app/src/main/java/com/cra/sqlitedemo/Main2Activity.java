package com.cra.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    ListView listView ;

    List<String > namelist =new ArrayList<>();
    List<String > addresslist = new ArrayList<>();
    List<String > phonelist = new ArrayList<>();
    List<String> idlist = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.listviewId);


        DatabaseHelper db = new DatabaseHelper(this);

        Cursor data = db.getData();




        if (data.getCount()==0){

            Toast.makeText(this, "no data able", Toast.LENGTH_SHORT).show();
        }
        else

        {

            while (data.moveToNext()){
                idlist.add(data.getString(0));
                namelist.add(data.getString(1));
                addresslist.add(data.getString(2));
                phonelist.add(data.getString(3));
            }

            MyAdapter adapter = new MyAdapter(this,namelist,addresslist,phonelist);

            listView.setAdapter(adapter);


            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {


                    Intent intent =  new Intent(Main2Activity.this,UpdateActivity.class);
                    intent.putExtra("n",namelist.get(i));
                    intent.putExtra("a",addresslist.get(i));
                    intent.putExtra("p",phonelist.get(i));
                    intent.putExtra("id",idlist.get(i));

                    startActivity(intent);



                    return false;
                }
            });



        }

    }
}
