package com.example.companyapp.FormActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.companyapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class AgentImport extends AppCompatActivity {
    Button step2;
    TextInputEditText date,nomcommercialdeienterprise,single,activitiesmenees,principle,secondaire,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_import);
        step2=findViewById(R.id.step2);
        step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AgentImport.this,PromoteurActivity.class);
                startActivity(intent);
            }
        });
        date=findViewById(R.id.Date);
        nomcommercialdeienterprise=findViewById(R.id.Nom_commercial_de_i_enterprise);
        single=findViewById(R.id.Single_facultatif);
        activitiesmenees=findViewById(R.id.Activities_menees);
        principle=findViewById(R.id.principle);
        secondaire=findViewById(R.id.secondaire_facultatif);
        address=findViewById(R.id.Address);
    }
}