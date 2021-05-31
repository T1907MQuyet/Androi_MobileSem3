package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvContact;
    private List<ContacModel>  listContact = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        lvContact = (ListView) findViewById(R.id.lvContact);
        ContactAdapter adapter = new ContactAdapter(listContact,this);
        lvContact.setAdapter(adapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContacModel contacModel = listContact.get(position);
                Toast.makeText(MainActivity.this,contacModel.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }
    private  void initData(){
        ContacModel contac = new ContacModel("Nguyen Van A","083347474",R.drawable.ic_user);
        listContact.add(contac);
        contac = new ContacModel("Nguyen Van B","0880494949",R.drawable.ic_user);
        listContact.add(contac);
        contac = new ContacModel("Nguyen Van C","0880494949",R.drawable.ic_user);
        listContact.add(contac);
        contac = new ContacModel("Nguyen Van C","0880494949",R.drawable.ic_user);
        listContact.add(contac);
        contac = new ContacModel("Nguyen Van E","0880494949",R.drawable.ic_user);
        listContact.add(contac);
        contac = new ContacModel("Nguyen Van F","0880494949",R.drawable.ic_user);
        listContact.add(contac);
        contac = new ContacModel("Nguyen Van G","0880494949",R.drawable.ic_user);
        listContact.add(contac);



    }
}