

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

public class recepient extends AppCompatActivity {

    private EditText username;
    
   
    private EditText useremail;
    private EditText userpassword;
    
    String m_name,  m_email, m_password;
    String var;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepient);
        username = (EditText) findViewById(R.id.username);
      
        useremail = (EditText) findViewById(R.id.useremail);
        userpassword = (EditText) findViewById(R.id.userpassword);
        
    }

    public void doRegister(View view) {


        m_name = username.getText().toString();
       
        
        m_email = useremail.getText().toString();
      
        m_password = userpassword.getText().toString();
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(m_email);

        if (matcher.find()) {
            //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            
                    if (m_password.length() >= 6) {

                        store();
                        Intent intent=new Intent(this,Login.class);
                        startActivity(intent);
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
               


                return params;}

        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);

    }



}
