package com.techdecode.test;


import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    Button button;
    EditText dob,tob;
    Calendar mcurrentdate;
    Spinner spinner,spinner1;
    int day,month,year;


    List<PersonUtils> personUtilsList;
    List<PersonUtils>shawon;
    RequestQueue rq;

    String request_url = "http://192.168.7.41/startech_Hrm/test.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button3);


        dob=findViewById(R.id.edittext);
        tob=findViewById(R.id.edittext1);
        mcurrentdate= Calendar.getInstance();
        day=mcurrentdate.get(Calendar.DAY_OF_MONTH);
        month=mcurrentdate.get(Calendar.MONTH);
        year=mcurrentdate.get(Calendar.YEAR);

        rq = Volley.newRequestQueue(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycleViewContainer);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        personUtilsList = new ArrayList<>();
        shawon=new ArrayList<>();

        //sendRequest();

        //dob.setText(month+"/"+day+"/"+year);
        dob.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        dob.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });


        tob.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        tob.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });


/*

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, request_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                      //  Toast.makeText(getBaseContext(), "True!", Toast.LENGTH_LONG).show();

                        try {
                            JSONArray array = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> parms = new HashMap<String, String>();

                        parms.put("leave_from", dob.getText().toString());
                        parms.put("leave_to", tob.getText().toString());



                        //Log.e("Log", "Shawon" + lattitude.getText().toString() );ss

                        return parms;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);



            }
        });

*/

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringRequest stringRequest = new StringRequest(Request.Method.POST, request_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {



                        try {

                            JSONArray array = new JSONArray(response);

                            for(int i = 0; i < response.length(); i++) {
                                PersonUtils personUtils = new PersonUtils();
                                JSONObject jsonObject = array.getJSONObject(i);
                                personUtils.setEMPNAME(jsonObject.getString("EMPNAME"));
                                personUtils.setREASON(jsonObject.getString("REASON"));
                                personUtils.setNO_OF_DAYS(jsonObject.getString("NO_OF_DAYS"));
                                personUtils.setLEAVE_FROM(jsonObject.getString("LEAVE_FROM"));
                                personUtils.setLEAVE_TO(jsonObject.getString("LEAVE_TO"));
                                personUtils.setLeave_id(jsonObject.getString("LEAVE_ID"));


                                personUtilsList.add(personUtils);


                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
         
                        mAdapter = new CustomRecyclerAdapter(MainActivity.this, personUtilsList);
                        recyclerView.setAdapter(mAdapter);



                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Something went wrong",Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parameters = new HashMap<String, String>();

                        parameters.put("leave_from", dob.getText().toString());
                        parameters.put("leave_to", tob.getText().toString());
                        return parameters;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);


            }
        });



/*
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });

 */      //sendRequest();




    }

/*
    public void sendRequest(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i = 0; i < response.length(); i++){

                    PersonUtils personUtils = new PersonUtils();

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        personUtils.setEMPNAME(jsonObject.getString("EMPNAME"));
                        personUtils.setREASON(jsonObject.getString("REASON"));
                        personUtils.setNO_OF_DAYS(jsonObject.getString("NO_OF_DAYS"));
                     //   personUtils.set(jsonObject.getString("REASON"));
                     //   personUtils.setREASON(jsonObject.getString("REASON"));
                      //  personUtils.setREASON(jsonObject.getString("REASON"));




                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    personUtilsList.add(personUtils);

                }

                mAdapter = new CustomRecyclerAdapter(MainActivity.this, personUtilsList);

                recyclerView.setAdapter(mAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Volley Error: ", String.valueOf(error));
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parms = new HashMap<String, String>();

                parms.put("leave_from", dob.getText().toString());
                parms.put("leave_to", tob.getText().toString());



                //Log.e("Log", "Shawon" + lattitude.getText().toString() );ss

                return parms;
            }
        };

        rq.add(jsonArrayRequest);

    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }*/
}