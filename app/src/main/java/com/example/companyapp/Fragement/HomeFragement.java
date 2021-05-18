package com.example.companyapp.Fragement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.companyapp.FormActivity.AgentImport;
import com.example.companyapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class HomeFragement extends Fragment {
    Button step1;
    TextInputEditText directiongeneraldeimpots,directionderattacheent,nometprenomsdupromoyeur,nomdepentreprise,nderue,ndeporte;
    CheckBox commune,section,lot,secteur,parcelle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_fragement, container, false);

//        step1=view.findViewById(R.id.step1);
//        step1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getContext(), AgentImport.class);
//                startActivity(intent);
//            }
//        });
//        directiongeneraldeimpots=view.findViewById(R.id.Direction_generaldes_imports);
//        directionderattacheent=view.findViewById(R.id.Directi_de_rattachement);
//        nometprenomsdupromoyeur=view.findViewById(R.id.Nom_et_prenoms_du_Promoteur);
//        nomdepentreprise=view.findViewById(R.id.Nom_de_Pentreprise);
//        nderue=view.findViewById(R.id.N_de_rue);
//        ndeporte=view.findViewById(R.id.N_de_porte);
//        commune=view.findViewById(R.id.commue);
//        section=view.findViewById(R.id.section);
//        lot=view.findViewById(R.id.lot);
//        secteur=view.findViewById(R.id.secteur);
//        parcelle=view.findViewById(R.id.parcelle);
//



        return view;
    }
}