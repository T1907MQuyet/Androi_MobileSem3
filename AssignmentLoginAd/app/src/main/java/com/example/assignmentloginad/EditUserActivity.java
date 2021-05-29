package com.example.assignmentloginad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditUserActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btDone;
    private EditText edUser;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        btDone = (Button)findViewById(R.id.btDone)
         = (Button) findViewById(R.id.btEdit);
        btEdit.setOnClickListener(this);

        Intent intent = getIntent();

        String username= intent.getStringExtra("USER_NAME");

        tvUser.setText(username);
    }


    @Override
    public void onClick(View v) {

    }
}
