package com.example.session2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvHello;
    private static final int REQUEST_C0DE = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG","onCreate()");
        Button btClick = (Button) findViewById(R.id.btClick);
        Button btCancel = (Button) findViewById(R.id.btCancel);

        tvHello = (TextView) findViewById(R.id.tvHello);
        tvHello.setText("Chao cac ban");

        btClick.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG","onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG","onStop()");
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","onDestroy()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG","onPause()");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btClick:
                Log.i("TAG","onClick onClick !!!");
                Intent intent new  Intent(MainActivity.this,ProfileAct.class);
                intent.putExtra(Constant.USER,tvHello.getText().toString());
                intent.putExtra("AGE",30);
                break;
            case R.id.btCancel:
                Log.i("TAG,"");


        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_C0DE){
            if (requestCode == Constant.RESULTCODE){
                String text = data.getStringExtra("PROFILE");
                tvHello.setText(text);
            }
        }
    }
}