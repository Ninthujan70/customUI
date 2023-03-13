package com.example.customlistwithnavigation;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.example.customlistwithnavigation.models.Person;
import com.example.customlistwithnavigation.models.Phone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RequestPersonData extends AsyncTask<Void, Void, Void> {

    ProgressDialog progressDialog;
    OnPersonListDataReceived listener;
    ArrayList<Person> personList;

    public RequestPersonData(ProgressDialog progressDialog, OnPersonListDataReceived listener) {

        this.progressDialog = progressDialog;
        this.listener = listener;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        ServiceHandler sh = new ServiceHandler(MainActivity.url);
        String jsonString = sh.makeServiceCall();

        if(jsonString != null) {
            jsonString = jsonString.replace("<pre>", "").replace("</pre>", "");
            personList = new ArrayList<>();
            JSONObject jsonObject = null;

            try {
                jsonObject = new JSONObject(jsonString);
                JSONArray contacts = jsonObject.getJSONArray("contacts");

                for(int i=0; i<contacts.length(); i++) {
                    JSONObject c = contacts.getJSONObject(i);
                    String name = c.getString("name");
                    String id = c.getString("id");
                    Phone phone = new Phone(c.getJSONObject("phone").getString("mobile"),
                            c.getJSONObject("phone").getString("home"),
                            c.getJSONObject("phone").getString("office"));

                    Log.d("TAG1213", phone.toString());

                    ArrayList<String> song = new ArrayList<>();
                    JSONArray songJson = c.getJSONObject("song_play_list").getJSONArray("song");
                    for(int j = 0; j<songJson.length(); j++) {
                        song.add(songJson.getString(j));
                    }

                    Person person = new Person.Builder()
                            .withName(name)
                            .withPhoneList(phone)
                            .withSongPlayList(song)
                            .withId(id)
                            .build();

                    Log.d("TAG123", person.toString());

                    personList.add(person);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);

        if(progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

        listener.onDataReceived(personList);

    }

    public interface OnPersonListDataReceived {
        void onDataReceived(ArrayList<Person> list);
    }

}
