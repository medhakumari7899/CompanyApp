package com.example.companyapp.FormActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.example.companyapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class PromoteurActivity extends AppCompatActivity {
    Button step3;
    TextInputEditText nouveau,boitepostale,telephone,chiffredaffairesannuelprevisionael;
    CheckBox rccmoui,non1,ifuoui,non2,cnssoui,non3,cpcoui,non4;
    RadioButton personnephysique,personnemoral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promoteur);
        step3=findViewById(R.id.step3);
        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PromoteurActivity.this,DeSondossier.class);
                startActivity(intent);
            }
        });
        nouveau=findViewById(R.id.Nouveau);
        boitepostale=findViewById(R.id.Boite_postale);
        telephone=findViewById(R.id.telephone);
        chiffredaffairesannuelprevisionael=findViewById(R.id.Chiffredaffairesannuelprevisionnel);
        rccmoui=findViewById(R.id.Rccmoui);
        non1=findViewById(R.id.non);
        ifuoui=findViewById(R.id.ifuoui);
        non2=findViewById(R.id.non2);
        cnssoui=findViewById(R.id.cnssoui);
        non3=findViewById(R.id.non3);
        cpcoui=findViewById(R.id.cpcoui);
        non4=findViewById(R.id.non4);
        personnephysique=findViewById(R.id.personnephysique);
        personnemoral=findViewById(R.id.personnemoral);

    }
}