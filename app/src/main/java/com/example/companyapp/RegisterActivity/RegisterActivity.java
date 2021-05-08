package com.example.companyapp.RegisterActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.companyapp.Activity.MainActivity;
import com.example.companyapp.Model.usermodel;
import com.example.companyapp.R;
import com.example.companyapp.Retrofitutil.ApiClient;
import com.example.companyapp.Retrofitutil.ApiInterface;
import com.example.companyapp.databinding.ActivityLoginBinding;
import com.google.android.material.textfield.TextInputEditText;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    Button R_button;
    ImageView image;
    TextView R_textView;
    TextInputEditText rfirstname,rlastname,remail,rpassword,rphone,rdob,rplaceofbirth,rcitizenship,raddress;
    private ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        image=findViewById(R.id.R_Profileimage);
        rfirstname=findViewById(R.id.R_Prénom);
        rlastname=findViewById(R.id.R_nom_de_famille);
        remail=findViewById(R.id.R_Adresse_email);
        rpassword=findViewById(R.id.R_Mot_de_passe);
        rphone=findViewById(R.id.R_Numéro_de_téléphone);
        rdob=findViewById(R.id.R_Date_de_naissance);
        rplaceofbirth=findViewById(R.id.R_lieu_de_naissance);
        rcitizenship=findViewById(R.id.R_Citoyenneté);
        raddress=findViewById(R.id.R_adresse);
        R_button=findViewById(R.id.R_Sinscrire_maintenant);
        R_textView=findViewById(R.id.R_Connexion);

        R_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performRegister();

            }
        });


    }

    public void performRegister(){
        String firstname=rfirstname.getText().toString();
        String lastname=rlastname.getText().toString();
        String email=remail.getText().toString();
        String password=rpassword.getText().toString();
        String phone=rphone.getText().toString();
        String dob=rdob.getText().toString();
        String placeofbirth=rplaceofbirth.getText().toString();
        String citizenship=rcitizenship.getText().toString();
        String address=raddress.getText().toString();
        Call<usermodel> call= ApiClient.getApiClient().create(ApiInterface.class).registeruserPerform(email,password
        ,firstname,lastname,phone,dob,placeofbirth,citizenship,address);
        call.enqueue(new Callback<usermodel>() {
            @Override
            public void onResponse(Call<usermodel> call, Response<usermodel> response) {

                remail.setText("");
                rpassword.setText("");
                raddress.setText("");
                rcitizenship.setText("");
                rfirstname.setText("");
                rlastname.setText("");
                rplaceofbirth.setText("");
                rdob.setText("");;
                rphone.setText("");
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
//                if (response.code()==200){
//                    if (response.body().getStatus().equals("ok"))
//                    {
//                        if (response.body().getResultCode()==1){
//                     //register success
//                            Toast.makeText(RegisterActivity.this,"Register success.Now you can login",
//                                    Toast.LENGTH_SHORT).show();
//                             onBackPressed();
//                             finish();
//                        }
//                        else
//                        {
//                            displayUserInfo("User already exists...");
//                            rpassword.setText("");
//                            remail.setText("");
//                        }
//
//                    }
//                    else
//                    {
//                        displayUserInfo("something wont wrong...");
//                        rpassword.setText("");
//                        remail.setText("");
//                    }
//
//                }else {
//                    displayUserInfo("something wont wrong...");
//                    rpassword.setText("");
//                    remail.setText("");
//                }
            }

            @Override
            public void onFailure(Call<usermodel> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });



    }

//    private void displayUserInfo(String message){
//       rpassword.setText("");
//
//    }
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }
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