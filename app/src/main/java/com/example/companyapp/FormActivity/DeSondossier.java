package com.example.companyapp.FormActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.companyapp.Activity.MainActivity;
import com.example.companyapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class DeSondossier extends AppCompatActivity {
    Button button;
    TextInputEditText nombredemployeesprevus,transport,btp,commerce,scrm,autresapreciser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_sondossier);
        button=findViewById(R.id.submite);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DeSondossier.this, MainActivity.class);
                startActivity(intent);
            }
        });
        nombredemployeesprevus=findViewById(R.id.Nombred_employees_prevus);
        transport=findViewById(R.id.Transport);
        btp=findViewById(R.id.btp);
        commerce=findViewById(R.id.Commerce);
        scrm=findViewById(R.id.Scrm);
        autresapreciser=findViewById(R.id.Autresa_preciser);
    }
}



