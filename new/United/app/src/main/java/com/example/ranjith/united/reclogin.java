package com.example.ranjith.united;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class reclogin extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    String emailId,pwd;
    private Button buttonSignIn;
    private TextView textViewSignUp;

    SharedPreferences.Editor editor;
    SharedPreferences shared;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail=(EditText)findViewById(R.id.editTextEmail);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        buttonSignIn=(Button)findViewById(R.id.buttonSignIn);
        textViewSignUp=(TextView)findViewById(R.id.textViewSignUp);
        SharedPreferences sp=getSharedPreferences("loginData", Context.MODE_PRIVATE);
        String mail=sp.getString("UserName","");
        String psd=sp.getString("Password","");
        editTextEmail.setText(mail);
        editTextPassword.setText(psd);

    }
    public void doLogin(View view) {
        emailId = editTextEmail.getText().toString();
        pwd = editTextPassword.getText().toString();
        CheckBox checkBox = (CheckBox) findViewById(R.id.rememberMe);
        if (checkBox.isChecked()) {
            shared = getSharedPreferences("loginData", Context.MODE_PRIVATE);
            editor = shared.edit();
            editor.putString("UserName", emailId);
            editor.putString("Password", pwd);
            editor.commit();
        }


        progressDialog = new ProgressDialog(reclogin.this);
        progressDialog.setTitle("Logging In");
        progressDialog.setMessage("Retreiving Data...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!TextUtils.isEmpty(emailId)) {
            if (!TextUtils.isEmpty(pwd)) {

                validate();

            }
        }
    }
    public void doRegister(View view){
        startActivity(new Intent(this,recregister.class));
    }



    private void validate() {
        String tag_string_req = "req_login";
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_RECLOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {



                try {
                    JSONObject det = new JSONObject(response);
                    boolean error = det.getBoolean("error");
                    if(!error)
                    {
                        Toast.makeText(reclogin.this,"Login Success",Toast.LENGTH_LONG).show();
                        editor.putString("mail",emailId);
                        editor.apply();
                        editor.commit();
                        progressDialog.cancel();
                        startActivity(new Intent(reclogin.this,Test.class));

                    }
                    else
                    {

                        progressDialog.cancel();
                        //startActivity(new Intent(reclogin.this,NavSearch.class));
                        Toast.makeText(reclogin.this, "Check the credentials", Toast.LENGTH_SHORT).show();
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

                params.put("email", emailId);
                params.put("pwd",pwd);



                return params;}

        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);

    }


}


