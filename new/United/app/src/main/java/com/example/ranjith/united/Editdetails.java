package com.example.ranjith.united;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Editdetails extends AppCompatActivity {

    EditText age,mobilenum;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editdetails);
        age = (EditText) findViewById(R.id.userageEdit);
        mobilenum = (EditText) findViewById(R.id.usermobileEdit);
        SharedPreferences sp=getSharedPreferences("loginData", Context.MODE_PRIVATE);
        email=sp.getString("UserName","");
    }

    public  void doUpdate(View v)
    {


        String tag_string_req = "req_editdetails";


        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_SEARCH_EDITDETAIL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
            }
        }, new Response.ErrorListener() {



            @Override
            public void onErrorResponse(VolleyError error) {
                // Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

            }
        })

        {@Override
        protected Map<String, String> getParams() {
            Map<String, String> params = new HashMap<String, String>();


            params.put("Age",age.getText().toString());
            params.put("Phone",mobilenum.getText().toString());
            params.put("Email",email);
            return params;
        }

        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }


}

