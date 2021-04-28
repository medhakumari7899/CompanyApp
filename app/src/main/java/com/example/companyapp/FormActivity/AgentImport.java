package com.example.companyapp.FormActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.companyapp.R;

public class AgentImport extends AppCompatActivity {
    Button agentimport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_import);
        agentimport=findViewById(R.id.btn_agentimport);
        agentimport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AgentImport.this,PromoteurActivity.class);
                startActivity(intent);
            }
        });
    }
}