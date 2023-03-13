package com.example.customlistwithnavigation.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customlistwithnavigation.R;
import com.example.customlistwithnavigation.RequestPersonData;
import com.example.customlistwithnavigation.UserListAdapter;
import com.example.customlistwithnavigation.models.Person;

import java.util.ArrayList;

public class AdvancedJsonFragment extends Fragment {

    View view;

    private ProgressDialog progressDialog;
    UserListAdapter listAdapter;
    RecyclerView recyclerView;
    ArrayList<Person> personArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_advanced, container, false);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait while data is beeing downloaded");
        progressDialog.setCancelable(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new RequestPersonData(progressDialog, new RequestPersonData.OnPersonListDataReceived() {
            @Override
            public void onDataReceived(ArrayList<Person> list) {
                setAdapter(view, list);
            }

        }).execute();

    }

    private void setAdapter(View view, ArrayList<Person> list) {
       recyclerView = view.findViewById(R.id.rv_list);
        listAdapter = new UserListAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getContext(),
                RecyclerView.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listAdapter);
    }
}
