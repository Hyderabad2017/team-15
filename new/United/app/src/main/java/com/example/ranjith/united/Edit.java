package com.example.ranjith.united;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Edit extends AppCompatActivity {

    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        SharedPreferences sp=getSharedPreferences("loginData", Context.MODE_PRIVATE);
        email=sp.getString("UserName","");
    }
    public void setOn(View v)
    {
        String tag_string_req = "req_edityes";
        final ArrayList<String> areasList=new ArrayList<>();
        areasList.clear();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_SEARCH_EDIT, new Response.Listener<String>() {

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

            params.put("Email",email);
            params.put("state","yes");
            return params;
        }

        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }




    public void setOff(View v)
    {
        String tag_string_req = "req_editno";


        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_SEARCH_EDIT, new Response.Listener<String>() {

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

            params.put("Email",email);
            params.put("state","no");
            return params;
        }

        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }












}
