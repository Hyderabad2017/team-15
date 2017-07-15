package com.example.ranjith.united;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword,usercheck;
    Spinner s_check;
    String emailId,pwd;
    String var;
    private Button buttonSignIn;
    private TextView textViewSignUp;
    ArrayList<String> check;
    SharedPreferences.Editor editor;
    SharedPreferences shared;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        usercheck = (EditText) findViewById(R.id.usercheck);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSignIn = (Button) findViewById(R.id.buttonSignIn);
        textViewSignUp = (TextView) findViewById(R.id.textViewSignUp);
        s_check = (Spinner) findViewById(R.id.spinner);
        SharedPreferences sp = getSharedPreferences("loginData", Context.MODE_PRIVATE);
        String mail = sp.getString("UserName", "");
        String psd = sp.getString("Password", "");
        editTextEmail.setText(mail);
        editTextPassword.setText(psd);
        check = new ArrayList<String>();
        check.add("Select");
        check.add("Admin");
        check.add("Recipient");
        check.add("Donor");
        final ArrayAdapter<String> arrayBloodAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, check);
        s_check.setAdapter(arrayBloodAdapter);
          s_check.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               var=arrayBloodAdapter.getItem(position);
                usercheck.setText(var);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

          }
   });
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


        progressDialog = new ProgressDialog(Login.this);
        progressDialog.setTitle("Logging In");
        progressDialog.setMessage("Retreiving Data...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!TextUtils.isEmpty(emailId)) {
            if (!TextUtils.isEmpty(pwd)) {


                if(!var.equalsIgnoreCase("Select")){

                    if(var.equalsIgnoreCase("Admin"))
                    {
                         admins();

                    }
                    else if (var.equalsIgnoreCase("Recipient"))
                    {

                    }
                    else if(var.equalsIgnoreCase("Donor"))
                    {
                        validate();
                    }
                }



            }
        }
    }
    public void doRegister(View view){
        startActivity(new Intent(this,Donor.class));
    }



    private void validate() {
        String tag_string_req = "req_login";
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {



                try {
                    JSONObject det = new JSONObject(response);
                    boolean error = det.getBoolean("error");
                    if(!error)
                    {
                        Toast.makeText(Login.this,"Login Success",Toast.LENGTH_LONG).show();
                        editor.putString("mail",emailId);
                        editor.apply();
                        editor.commit();
                        progressDialog.cancel();
                        startActivity(new Intent(Login.this,NavSearch.class));

                    }
                    else
                    {

                        progressDialog.cancel();


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

                params.put("Email", emailId);
                params.put("Password",pwd);



                return params;}

        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);

    }


}
