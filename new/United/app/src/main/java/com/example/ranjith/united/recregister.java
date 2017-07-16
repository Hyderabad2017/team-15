package com.example.ranjith.united;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class recregister extends AppCompatActivity {
    EditText user,email,reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recregister);

    }
    public void emails(View v)
    {
        String tag_string_req = "req_editdetails";
        user=(EditText)findViewById(R.id.eusername);
        email=(EditText)findViewById(R.id.eemail);
        reg=(EditText)findViewById(R.id.ereg);
        final String muser=user.getText().toString();
        final String memail=email.getText().toString();
        final String mreg=reg.getText().toString();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_TEMP, new Response.Listener<String>() {

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

            params.put("email",memail);
            params.put("name",muser);
            params.put("reg",mreg);
            params.put("Active","NO");
            params.put("Status","NO");
            params.put("pwd","");
            return params;
        }

        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
        Log.i("Send email", "");
        String[] TO = {"xyz@gmail.com"};
        String[] CC = {"xyz@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"My user name is"+muser+"My email is"+memail+"My reg id is"+mreg);
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email.", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }



    }
}
