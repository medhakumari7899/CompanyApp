package com.example.companyapp.RegisterActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.companyapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class SignupActivity extends AppCompatActivity {
    TextInputEditText se1,se2,se3;
    CardView sbtn;
    TextView stext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

       se1 =findViewById(R.id.S_Nom_d_utilisateur);
       se2=findViewById(R.id.S_Email);
       se3=findViewById(R.id.S_Mot_de_passe);
       sbtn=findViewById(R.id.S_cardView);
       stext=findViewById(R.id.S_Connexion);
    }
}