package com.example.ranjith.united;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DisplayDetails extends AppCompatActivity {

    String name, phone, gender, email, age;
    TextView name_m, age_m, gender_m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);
        Intent i = getIntent();
        name = i.getStringExtra("Name");
        phone = i.getStringExtra("Phone");
        gender = i.getStringExtra("Gender");
        display();
        name_m = (TextView) findViewById(R.id.name);
        age_m = (TextView) findViewById(R.id.age);
        gender_m = (TextView) findViewById(R.id.gender);

    }

    public void doCall(View view) {
//        Intent callIntent = new Intent(Intent.ACTION_CALL);
//        callIntent.setData(Uri.parse("tel:9441457149"));
//
//        if (ActivityCompat.checkSelfPermission(this,
//                android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }
//
//        //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
//        startActivity(callIntent);
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:04023155056"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(callIntent);
    }
    public void sendEmail(View view){
        Log.i("Send email", "");
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Request For Blood...");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email.", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void sendMessage(View view) {
        // The number on which you want to send SMS
        // startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
        Intent sms=new Intent();
        sms.setAction(android.content.Intent.ACTION_VIEW);
        sms.setData(Uri.parse("smsto:"+phone));
        startActivity(sms);
    }


    public void display() {
        String tag_string_req = "req_display_details";
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_DISPLAY_DETAILS, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {


                try {
                    JSONObject det = new JSONObject(response);
                    boolean error = det.getBoolean("error");
                    if (!error) {
                        JSONObject jobj = new JSONObject(response);
                        JSONArray arrData = jobj.getJSONArray("Details");

                        for (int i = 0; i < arrData.length(); i++) {

                            JSONObject jdata = arrData.getJSONObject(i);

                            //here u can get all field like this

                            age = jdata.getString("Age");
                            email = jdata.getString("Email");



                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                name_m.setText(name);
                age_m.setText(age);
                gender_m.setText(gender);
            }
        }
                , new Response.ErrorListener() {


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

                params.put("Name", name);
                params.put("Mobile", phone);
                params.put("Gender", gender);


                return params;
            }

        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);


    }


}
