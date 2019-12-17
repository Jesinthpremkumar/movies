package com.example.jasinthpremkumar.movies;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Jasinthpremkumar on 7/14/2018.
 */

public class conn {
    public String url = "http://192.168.1.110";
    public static String page="http://192.168.1.110:8081/json.php";

    public conn() {

    }

    public int check() {
        try {
            URL myUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
            int timeout = 1000;
            connection.setConnectTimeout(timeout);
            connection.connect();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public  JSONObject getjson(){
     try{
        String line;
        StringBuilder sb = new StringBuilder();

        URL url=new URL("http://192.168.1.110:8081/json.php");
        HttpURLConnection conn;
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        InputStream is=conn.getInputStream();
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(is));
        while(null!=(line=br.readLine())){
            sb.append(line);
        }
        is.close();
        return new JSONObject(sb.toString());
    }

        catch(Exception e)
    {
        e.printStackTrace();
    }
    return null;
    }
}