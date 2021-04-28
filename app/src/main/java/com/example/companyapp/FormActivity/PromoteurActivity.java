package com.example.companyapp.FormActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.companyapp.R;

public class PromoteurActivity extends AppCompatActivity {
    Button promoteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promoteur);
        promoteur=findViewById(R.id.btn_promoteur);
        promoteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PromoteurActivity.this,DeSondossier.class);
                startActivity(intent);
            }
        });
    }
}