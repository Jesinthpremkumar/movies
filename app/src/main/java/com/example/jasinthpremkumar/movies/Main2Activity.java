package com.example.jasinthpremkumar.movies;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {
public conn con;
    private ListView li;
    private TextView txt;
    private String[] res;
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        li= findViewById(R.id.listView);
        con=new conn();

        try{
            JSONObject job=new JSONObject(String.valueOf((JSONObject) con.getjson()));
            JSONArray arr=job.getJSONArray("file");
            res=new String[arr.length()];
            for (int i=0;i<arr.length();i++){
                res[i]=arr.getString(i);

            }
            if(res[0]==""){
                Toast.makeText(this,"Connectino isn't Available!", Toast.LENGTH_SHORT);
            }

            ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.list,res);
            li.setAdapter(adapter);
            li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i=new Intent(Main2Activity.this,VideoAcitvity.class);
                    i.putExtra("URL",String.valueOf(((TextView) view).getText()));
                    startActivity(i);
                }
            });




        } catch (Exception e) {
            e.printStackTrace();
        }




    }


}
