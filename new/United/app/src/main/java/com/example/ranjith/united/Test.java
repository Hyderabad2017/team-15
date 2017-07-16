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

public class Test extends AppCompatActivity {
    EditText e_group,e_city,e_area;
    Spinner s_group,s_city,s_area;
    String blood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    e_group=(EditText)findViewById(R.id.group_search);
    e_city=(EditText)findViewById(R.id.city_search);
    e_area=(EditText)findViewById(R.id.area_search);
    s_group=(Spinner)findViewById(R.id.spin_group);
    s_city=(Spinner)findViewById(R.id.spin_city);
    s_area=(Spinner)findViewById(R.id.spin_area);
    final ArrayList<String> bloodGroupsList=new ArrayList<>();
    bloodGroupsList.add("Blood Group");
    bloodGroupsList.add("A Plus");
    bloodGroupsList.add("A Minus");
    bloodGroupsList.add("B Plus");
    bloodGroupsList.add("B Minus");
    bloodGroupsList.add("O Plus");
    bloodGroupsList.add("O Minus");
    bloodGroupsList.add("AB Plus");
    bloodGroupsList.add("AB Minus");
    final ArrayAdapter<String> arrayBloodAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,bloodGroupsList);
    s_group.setAdapter(arrayBloodAdapter);
    s_group.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String var=arrayBloodAdapter.getItem(position);
            e_group.setText(var);
            e_city.setText("");
            e_area.setText("");
            if(!var.equalsIgnoreCase("Blood group")){
                assignCities(var);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });


}
    public void assignCities(final String var)
    {
        Toast.makeText(getApplicationContext(),"nknk",Toast.LENGTH_LONG).show();
        String tag_string_req = "req_search";
        final ArrayList<String> citiesList=new ArrayList<>();
        citiesList.clear();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_SEARCH, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {



                try {
                    JSONObject jobj = new JSONObject(response);
                    JSONArray arrData=jobj.getJSONArray("Details");
                    boolean error =jobj.getBoolean("error");
                    if(!error)
                    {
                        for (int i = 0; i < arrData.length(); i++)
                        {

                            JSONObject jdata=arrData.getJSONObject(i);

                            //here u can get all field like this

                            String  city=jdata.getString("City");

                            citiesList.add(city);


                        }
                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(),"Sry No city available",Toast.LENGTH_LONG).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                final ArrayAdapter<String> cities=new ArrayAdapter<String>(Test.this,android.R.layout.simple_list_item_1,citiesList);
                s_city.setAdapter(cities);
                s_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String var=cities.getItem(position);
                        e_city.setText(var);
                        e_area.setText("");
                        if(!var.equalsIgnoreCase("")){
                            assignAreas(var,blood);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });






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
                blood=var;
                params.put("Bgroup", var);
                // params.put("Password",pwd);



                return params;}

        };


        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);



    }

    public void assignAreas(final String var, final String blood)
    {
        String tag_string_req = "req_searcharea";
        final ArrayList<String> areasList=new ArrayList<>();
        areasList.clear();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_SEARCH_AREA, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {



                try {
                    JSONObject jobj = new JSONObject(response);
                    JSONArray arrData=jobj.getJSONArray("Area");
                    boolean error =jobj.getBoolean("error");
                    if(!error)
                    {
                        for (int i = 0; i < arrData.length(); i++)
                        {

                            JSONObject jdata=arrData.getJSONObject(i);

                            //here u can get all field like this

                            String  area=jdata.getString("Area");

                            areasList.add(area);


                        }
                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(),"Sry No Area available",Toast.LENGTH_LONG).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                final ArrayAdapter<String> areas=new ArrayAdapter<String>(Test.this,android.R.layout.simple_list_item_1,areasList);
                s_area.setAdapter(areas);
                s_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String var=areas.getItem(position);
                        e_area.setText(var);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


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

                params.put("City", var);
                params.put("Bgroup",blood);
                return params;
            }

        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);



    }






    public void searchData(View view) {
        if(!TextUtils.isEmpty(e_city.getText()) && !TextUtils.isEmpty(e_area.getText()) && !e_group.getText().toString().equalsIgnoreCase("Blood Group") ){
            Intent intentSearch=new Intent(this,DisplayList.class);
            intentSearch.putExtra("Group",e_group.getText().toString());
            intentSearch.putExtra("City",e_city.getText().toString());
            intentSearch.putExtra("Area",e_area.getText().toString());
            startActivity(intentSearch);
        }
        else
            Toast.makeText(this, "Enter Missing Fields", Toast.LENGTH_SHORT).show();
    }

    public void openMaps(View view) {
        if(isLocationEnabled(getBaseContext())) {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + "hospitals");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        else {
            Toast.makeText(this, "Please enable GPS", Toast.LENGTH_SHORT).show();
        }
    }
    public static boolean isLocationEnabled(Context context) {
        int locationMode = 0;
        String locationProviders;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);

            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }

            return locationMode != Settings.Secure.LOCATION_MODE_OFF;

        }else{
            locationProviders = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            return !TextUtils.isEmpty(locationProviders);
        }


    }

}


