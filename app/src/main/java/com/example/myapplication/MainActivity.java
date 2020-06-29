package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
   LinearLayoutManager layoutManager;
    List<ListItem> listItems;
    String request_url="https://mysqlconnectdb.000webhostapp.com/heena/json.php";
   // String request_url=" http://192.168.43.196/Volley/data.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // rq= Volley.newRequestQueue(this);
        recyclerView=(RecyclerView)findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        listItems=new ArrayList<>();
        mAdapter=new DeveloperAdapter(getApplicationContext(),listItems);
        recyclerView.setAdapter(mAdapter);
        sendrequest();

    }
    public  void sendrequest()
    {
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++)
                {

                    try {
                        ListItem listItem=new ListItem();
                        JSONObject jsonObject=response.getJSONObject(i);
                        listItem.setName(jsonObject.getString("name"));
                        listItem.setTitle(jsonObject.getString("title"));
                        listItem.setDescription(jsonObject.getString("description"));
                        listItem.setImage(jsonObject.getString("image"));
                        listItems.add(listItem);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }mAdapter.notifyDataSetChanged();
                /*mAdapter=new DeveloperAdapter(MainActivity.this,listItems);
                recyclerView.setAdapter(mAdapter);*/
            }
        }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.i("Volley Error: ", String.valueOf(error));

        }
    });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}