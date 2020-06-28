package com.example.phonebook;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.phonebook.db.DatabaseRoom;

public class MainActivity extends AppCompatActivity implements ICallBack {

    RecyclerView rvUser;
    Button btnAdd;
    DatabaseRoom db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = DatabaseRoom.getInstance(this);
        rvUser = findViewById(R.id.rvUser);
        btnAdd = findViewById(R.id.btnAdd);
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        rvUser.setAdapter(new UserAdapter(db.userDao().users(),this));


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void call(String phoneNo) {

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNo));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1);

            return;
        }
        startActivity(intent);
    }

    @Override
    public void sms(String phoneNo) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + phoneNo));
        startActivity(intent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {

        }
    }
}
