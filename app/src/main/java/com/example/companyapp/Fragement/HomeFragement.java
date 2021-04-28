package com.example.companyapp.Fragement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.companyapp.FormActivity.AgentImport;
import com.example.companyapp.R;

public class HomeFragement extends Fragment {
    Button agentcafore;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_fragement, container, false);

        agentcafore=view.findViewById(R.id.btn_agentcafore);
        agentcafore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), AgentImport.class);
                startActivity(intent);
            }
        });


        return view;
    }
}