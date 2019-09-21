package com.cra.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText name,addres,phone;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name = findViewById(R.id.nameId2);
        addres = findViewById(R.id.addressId2);
        phone = findViewById(R.id.phoneId2);
        save = findViewById(R.id.saveID2);


        Intent intent = getIntent();

        String nm = intent.getStringExtra("n");
        String ad = intent.getStringExtra("a");
        String ph = intent.getStringExtra("p");
      final   String id = intent.getStringExtra("id");

        name.setText(nm);
        addres.setText(ad);
        phone.setText(ph);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String newname = name.getText().toString().trim();
                String newadd = addres.getText().toString().trim();
                String newphone = phone.getText().toString().trim();

                DatabaseHelper databaseHelper = new DatabaseHelper(UpdateActivity.this);
                long value = databaseHelper.updatedata(id,newname,newadd,newphone);

                if (value>0){

                    Toast.makeText(UpdateActivity.this, "Store ", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent (UpdateActivity.this,Main2Activity.class));
                    finish();
                }
                else
                {
                    Toast.makeText(UpdateActivity.this, "failed", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}
