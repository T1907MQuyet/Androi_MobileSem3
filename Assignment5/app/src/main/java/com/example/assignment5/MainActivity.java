 package com.example.assignment5;

 import androidx.appcompat.app.AppCompatActivity;

 import android.os.Bundle;
 import android.widget.ImageView;
 import android.widget.ListView;
 import android.widget.TextView;

 import java.util.ArrayList;
 import java.util.List;

 public class MainActivity extends AppCompatActivity implements IOnChildItemClick{

     private List<ContactModel> listContact = new ArrayList<>();
     private ListView lvContact;
     private ContactAdapter mAdapter;
     private ImageView ivUser;
     private TextView tvName;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
     }

     private void initView()
     {
         lvContact = (ListView)findViewById(R.id.lvContact);
         ivUser = (ImageView) findViewById(R.id.ivUser);
         tvName = (TextView)findViewById(R.id.tvName);
     }

     private void initData()
     {
         listContact.add(new ContactModel("Tran A","09999999",R.drawable.male02));
         listContact.add(new ContactModel("Tran B","011111111",R.drawable.male02));
         listContact.add(new ContactModel("Tran C","022222222",R.drawable.male02));
         listContact.add(new ContactModel("Tran D","033333333",R.drawable.male02));
         listContact.add(new ContactModel("Tran E","044444444",R.drawable.male02));
         listContact.add(new ContactModel("Tran F","055555555",R.drawable.male02));
         listContact.add(new ContactModel("Tran G","066666666",R.drawable.male02));
         listContact.add(new ContactModel("Tran H","077777777",R.drawable.male02));
     }

     @Override
     protected void onDestroy() {
         super.onDestroy();

     }


 }
