package com.example.customlistwithnavigation;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ServiceHandler {

    String mUrl;

    static String response = null;
    public ServiceHandler(String url){
        mUrl = url;
    };

    public String makeServiceCall(){
        BufferedReader bufferedReader = null;
        URLConnection urlConnection;
        try {
            URL urlObj = new URL(mUrl);
            urlConnection = urlObj.openConnection();
            bufferedReader = new BufferedReader((new InputStreamReader((urlConnection.getInputStream()))));
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            response = stringBuffer.toString();
            Log.i("JSON", response);
        }catch (Exception e){
            Log.e("APP", "something wrong", e);
        }finally {
            if(bufferedReader!=null){
                try{
                    bufferedReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return response;
    }


}
