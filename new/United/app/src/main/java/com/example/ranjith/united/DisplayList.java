package com.example.ranjith.united;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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

public class DisplayList extends AppCompatActivity {

    ArrayList<Person> list;
    String blood, area, city;
    final Context context = this;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
        listView = (ListView) findViewById(R.id.listView);
        Intent intent2 = getIntent();
        blood = intent2.getStringExtra("Group");
        final Context context = this;
        area = intent2.getStringExtra("Area");
        city = intent2.getStringExtra("City");
        list = new ArrayList<Person>();
        listing();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = list.get(position).getName();
                String phone = list.get(position).getPhone();
                String gender = list.get(position).getGender();
                String state = list.get(position).getStatus();
                if (state.equalsIgnoreCase("no")) {
                    Toast.makeText(context, "User Unavailable", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(DisplayList.this, DisplayDetails.class);
                    intent.putExtra("Name", name);
                    intent.putExtra("Phone", phone);
                    intent.putExtra("Gender", gender);
                    startActivity(intent);
                }
            }


        });


    }

    public void listing() {


        String tag_string_req = "req_displaylist";

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_SEARCH_DISPLAY, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jobj = new JSONObject(response);
                    JSONArray arrData = jobj.getJSONArray("Display");
                    Log.d("Test", arrData.toString());
                    boolean error = jobj.getBoolean("error");
                    if (!error) {
                        for (int i = 0; i < arrData.length(); i++) {

                            JSONObject jdata = arrData.getJSONObject(i);
                            Person feed = new Person();
                            feed.setName(jdata.getString("Name"));
                            feed.setPhone(jdata.getString("Mobile"));
                            feed.setGender(jdata.getString("Gender"));
                            feed.setStatus(jdata.getString("state"));
                            list.add(feed);
                            Bases baseadapter = new Bases(context, list);
                            listView.setAdapter(baseadapter);

                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Sry No Area available", Toast.LENGTH_LONG).show();

                    }
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
                params.put("Bgroup", blood);
                params.put("Area", area);
                params.put("City", city);
                return params;
            }

        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }


}