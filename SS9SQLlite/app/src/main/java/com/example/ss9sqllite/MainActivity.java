package com.example.ss9sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DBHelper db;
    private EditText edName,edDes;
    private Button btRegister;
    private Spinner spinner;
    private CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void insertUser()
    {

        User user = new User("Nguyen Van A","Male",20);
        //String message = db.insertDB(user);
        //Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    private void getAllUser()
    {
//        List<User> listUser = db.getAllUser();
//        for (User user : listUser)
//        {
//            Log.d("USER","name: "+user.getName()+" id: "+user.getId()+" age: "+user.getAge());
//        }
    }

    private void updateUser()
    {
        User user = new User();
        user.setId(3);
        user.setName("Nguyen Van Hung Update");
        user.setAge(15);
       // String message = db.updateUser(user);
        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void deleteUser()
    {
        db.deleteUser(5);
    }

    @Override
    protected void onStop() {
        super.onStop();
        db.close();
    }

    private void initView()
    {
        edName = (EditText) findViewById(R.id.edUser);
        edDes = (EditText) findViewById(R.id.edDes);
        btRegister = (Button) findViewById(R.id.btRegister);
        checkBox = (CheckBox) findViewById(R.id.ck);
        btRegister.setOnClickListener(this);

        String[] genders = {"Male","Famale","Unknow"};
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genders);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == btRegister){
            onRegister();
        }
    }

    private void onRegister()
    {
        if (edName.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Please enter username",Toast.LENGTH_LONG).show();
            return;
        }

        if (!checkBox.isChecked())
        {
            Toast.makeText(this,"Please agree rules",Toast.LENGTH_LONG).show();
            return;
        }
        String isAdd = db.insertDB(edName.getText().toString(),spinner.getSelectedItem().toString(),edDes.getText().toString());
        Toast.makeText(this, isAdd, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this, ListUserAct.class);
        startActivity(intent);
    }
}