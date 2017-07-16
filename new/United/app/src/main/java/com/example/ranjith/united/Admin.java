package com.example.ranjith.united;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Admin extends AppCompatActivity {
    EditText e_email, e_reg_id, e_password, bloodbank;
    Spinner bloodspinner;
    String email,reg;
    String name,b_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        e_email = (EditText) findViewById(R.id.city_search);

        e_password = (EditText) findViewById(R.id.area_search);
        e_reg_id = (EditText) findViewById(R.id.reg);
        bloodspinner=(Spinner)findViewById(R.id.bloodspinner);
        bloodbank=(EditText)findViewById(R.id.bloodbank);

        String tag_string_req = "req_search";
        final ArrayList<String> blist = new ArrayList<>();
        blist.clear();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_ACCEPT, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jobj = new JSONObject(response);
                    JSONArray arrData = jobj.getJSONArray("Details");
                    boolean error = jobj.getBoolean("error");
                    if (!error) {
                        for (int i = 0; i < arrData.length(); i++) {

                            JSONObject jdata = arrData.getJSONObject(i);
                             Log.d("len",arrData.length()+"");
                            //here u can get all field like this

                          name= jdata.getString("name");

                            blist.add(name);



                        }
                    } else {
                        //Toast.makeText(getApplicationContext(), "Sry No city available", Toast.LENGTH_LONG).show();

                    }
                    Log.d("name",name);
                    assign(name);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
              final ArrayAdapter<String> cities=new ArrayAdapter<String>(Admin.this,android.R.layout.simple_list_item_1,blist);
                bloodspinner.setAdapter(cities);
                bloodspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String var=cities.getItem(position);
                        bloodbank.setText(var);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                assign(name);


            }
        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                // Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

            }
        })

        {


            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                //blood=var;
                //params.put("Bgroup", var);
                // params.put("Password",pwd);


                return params;
            }

        };


        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);



    }


    public void assign(String name) {

        b_name=name;
        String tag_string_req = "req_search";
        final ArrayList<String> citiesList = new ArrayList<>();
        citiesList.clear();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_ADMINASSIGN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jobj = new JSONObject(response);
                    JSONArray arrData = jobj.getJSONArray("Details");
                    boolean error = jobj.getBoolean("error");
                    if (!error) {
                        for (int i = 0; i < arrData.length(); i++) {

                            JSONObject jdata = arrData.getJSONObject(i);

                            //here u can get all field like this

                            email = jdata.getString("email");
                            reg=jdata.getString("reg");
                          //  Toast.makeText(getApplicationContext(),email,Toast.LENGTH_LONG).show();




                        }
                    } else {


                    }
                    e_email.setText(email);
                    e_reg_id.setText(reg);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                // Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

            }
        })

        {


            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("name", b_name);



                return params;
            }

        };


        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
Toast.makeText(getApplicationContext(),email,Toast.LENGTH_LONG).show();

  }


    public void accept(View v)
    {


        String tag_string_req = "req_search";
        final ArrayList<String> citiesList = new ArrayList<>();
        citiesList.clear();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_ADMINPASS, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jobj = new JSONObject(response);
                    JSONArray arrData = jobj.getJSONArray("Details");
                    boolean error = jobj.getBoolean("error");
                    if (!error) {
                        for (int i = 0; i < arrData.length(); i++) {

                            JSONObject jdata = arrData.getJSONObject(i);






                        }
                    } else {


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

            }
        })

        {


            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();


                params.put("email",e_email.getText().toString());
                params.put("pwd", e_password.getText().toString());




                return params;
            }

        };


        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
        Toast.makeText(getApplicationContext(),email,Toast.LENGTH_LONG).show();

    }
}

