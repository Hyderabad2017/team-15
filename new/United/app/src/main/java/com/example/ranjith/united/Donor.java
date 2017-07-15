package com.example.ranjith.united;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Donor extends AppCompatActivity {

    private EditText username;
    private TextView userbgroup;
    private Spinner spinner;
    private EditText userage;
    private EditText usermobile;
    private EditText userarea;
    private EditText usercity;
    private EditText useremail;
    private EditText userpassword;
    private EditText userpassword1,Weight;
    String m_name, m_age, m_mobile, m_area, m_city, m_email, m_password, m_retype, m_blood,m_weight;
    String var;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);
        username = (EditText) findViewById(R.id.username);
        userage = (EditText) findViewById(R.id.userage);
        usermobile = (EditText) findViewById(R.id.usermobile);
        userarea = (EditText) findViewById(R.id.userarea);
        usercity = (EditText) findViewById(R.id.usercity);
        useremail = (EditText) findViewById(R.id.useremail);
        userpassword = (EditText) findViewById(R.id.userpassword);
        userpassword1 = (EditText) findViewById(R.id.userpassword1);
        Weight = (EditText) findViewById(R.id.mweight);
        userbgroup = (TextView) findViewById(R.id.userbgroup);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Select\t\t");
        arrayList.add("A plus");
        arrayList.add("A minus");
        arrayList.add("B plus");
        arrayList.add("B minus");
        arrayList.add("O plus");
        arrayList.add("O minus");
        arrayList.add("AB plus");
        arrayList.add("AB minus");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, arrayList);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                var = adapter.getItem(i);
                userbgroup.setText(var);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void doRegister(View view) {


        m_name = username.getText().toString();
        m_age = userage.getText().toString();
        if (m_age == null) {
            m_age = 0 + "";
        }
        m_mobile = usermobile.getText().toString();
        m_area = userarea.getText().toString();
        m_city = usercity.getText().toString();
        m_blood = userbgroup.getText().toString();
        m_email = useremail.getText().toString();
        m_weight = Weight.getText().toString();
        m_password = userpassword.getText().toString();
        m_retype = userpassword1.getText().toString();
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(m_email);

        if (matcher.find()) {
            //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            if (Integer.parseInt(m_age) > 18) {
                if (m_password.equals(m_retype)) {
                    if (m_password.length() >= 6) {

                        store();
                        Intent intent=new Intent(this,Login.class);
                        startActivity(intent);
                    }
                    else
                    {

                        Toast.makeText(getApplicationContext(),"Check Your Password",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Re-enter Your Password",Toast.LENGTH_LONG).show();

                }
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Check Your Mail",Toast.LENGTH_LONG).show();
        }
    }

    public void store()
    {
        String tag_string_req = "req_register";
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_REGISTER, new Response.Listener<String>() {

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

        {



            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("Name", m_name);
                params.put("Email", m_email);
                params.put("Password", m_password);
                params.put("Age", m_age);
                params.put("Bgroup", m_blood);
                params.put("Phone", m_mobile);
                RadioGroup radio = (RadioGroup) findViewById(R.id.usergender);
                RadioButton rb = (RadioButton) findViewById(radio.getCheckedRadioButtonId());
                String gender = rb.getText().toString();
                params.put("Gender",gender);
                params.put("City", m_city);
                params.put("Area", m_area);
                params.put("Weight",m_weight);



                return params;}

        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);

    }



}

