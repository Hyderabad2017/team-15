package com.example.ranjith.united;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void recipient(View v)
    {
        startActivity(new Intent(MainActivity.this,reclogin.class));
    }


    public void donor(View v)
    {
        startActivity(new Intent(MainActivity.this,Login.class));
    }
    public void admin(View v)
    {
        startActivity(new Intent(MainActivity.this,Admin.class));
    }


}
