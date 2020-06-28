package com.example.phonebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.phonebook.db.DatabaseRoom;
import com.example.phonebook.db.entity.User;

public class AddUserActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtPhone;
    Button btnAdd;

    DatabaseRoom db;
    User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        db = DatabaseRoom.getInstance(this);

        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(edtName.getText().toString());
                user.setPhoneNo(edtPhone.getText().toString());

                db.userDao().insert(user);

                Intent intent = new Intent(AddUserActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
