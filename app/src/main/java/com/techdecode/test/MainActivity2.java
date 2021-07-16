package com.techdecode.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {
TextView t1,t2,t3,t4,t5,t6;
EditText e1,e2,e3,e4;
Button  b1,b2,b3,b4;
private String showUrl="http://192.168.7.41/startech_Hrm/approval_update.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.text);
        t2=findViewById(R.id.id);
        t3=findViewById(R.id.id2);
        t4=findViewById(R.id.id3);
        t5=findViewById(R.id.id4);
        t6=findViewById(R.id.id5);
        e1=findViewById(R.id.goal_weight);
        e2=findViewById(R.id.leave_form);
        e3=findViewById(R.id.days);
        e4=findViewById(R.id.leave_to);
        t1.setText(getIntent().getStringExtra("title"));
        t2.setText(getIntent().getStringExtra("leaveid"));
        e1.setText(getIntent().getStringExtra("reason"));
        e2.setText(getIntent().getStringExtra("leaveform"));
        e4.setText(getIntent().getStringExtra("leaveto"));
        e3.setText(getIntent().getStringExtra("nodays"));

        b1=findViewById(R.id.Lp);
        b2=findViewById(R.id.LWP);
        b3=findViewById(R.id.UN);
        b4=findViewById(R.id.con);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, showUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                            t3.setText("LP");
                            Toast.makeText(getBaseContext(), "Data Insert Sucessfully!", Toast.LENGTH_LONG).show();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> parms = new HashMap<String, String>();
                        parms.put("leaveid", t2.getText().toString());
                        parms.put("LP",t3.getText().toString());
                        //Log.e("Log", "Shawon" + lattitude.getText().toString() );ss


                        return parms;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);

            }
        });

        /*leave without pay*/

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, showUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        t4.setText("LWP");
                        Toast.makeText(getBaseContext(), "Data Insert Sucessfully!", Toast.LENGTH_LONG).show();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> parms = new HashMap<String, String>();
                        parms.put("leaveid", t2.getText().toString());
                        parms.put("LWP",t4.getText().toString());
                        //Log.e("Log", "Shawon" + lattitude.getText().toString() );ss


                        return parms;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);

            }
        });


        /*Unapproven*/


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, showUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        t5.setText("C");
                        Toast.makeText(getBaseContext(), "Data Insert Sucessfully!", Toast.LENGTH_LONG).show();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> parms = new HashMap<String, String>();
                        parms.put("leaveid", t2.getText().toString());
                        parms.put("C",t5.getText().toString());
                        //Log.e("Log", "Shawon" + lattitude.getText().toString() );ss


                        return parms;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, showUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        t6.setText("CON");
                        Toast.makeText(getBaseContext(), "Data Insert Sucessfully!", Toast.LENGTH_LONG).show();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> parms = new HashMap<String, String>();
                        parms.put("leaveid", t2.getText().toString());
                        parms.put("CON",t6.getText().toString());
                        //Log.e("Log", "Shawon" + lattitude.getText().toString() );ss


                        return parms;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);

            }
        });

    }
}