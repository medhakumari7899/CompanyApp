package com.example.companyapp.RegisterActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.companyapp.Activity.MainActivity;
import com.example.companyapp.R;

public class RegisterActivity extends AppCompatActivity {
    Button R_button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        R_button = findViewById(R.id.R_Sinscrire_maintenant);
    }
}
//        textView=findViewById(R.id.text_login);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(RegisterActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//}