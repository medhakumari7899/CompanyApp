package com.example.companyapp.RegisterActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.companyapp.Model.LoginRequest;
import com.example.companyapp.Model.LoginResponce;
import com.example.companyapp.R;
import com.example.companyapp.RetrofitBuilder;
import com.example.companyapp.SessionManager;
import com.example.companyapp.UserDetailsForm.DataCollectForms;
import com.example.companyapp.network.ApiService;
import com.example.companyapp.sevice.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    CardView login;
    EditText etemail, etpassword;
    TextView textLogin;
    ApiService service;
    SessionManager sessionManager;
    ApiClient apiClient;
    private String sendToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etemail = findViewById(R.id.L_Email);
        etpassword = findViewById(R.id.L_Mot_de_passe);
        login = findViewById(R.id.L_connexion);
        service = RetrofitBuilder.createService(ApiService.class);
        sessionManager = sessionManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));

        textLogin = findViewById(R.id.txt_Sinscrire);
            textLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
            });

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (TextUtils.isEmpty(etemail.getText().toString()) ||
                            TextUtils.isEmpty(etpassword.getText().toString())) {
                        String message = "All inputs required ..";
                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();

                    } else {
                        LoginRequest loginRequest = new LoginRequest();
                        loginRequest.setEmail(etemail.getText().toString());
                        loginRequest.setPassword(etpassword.getText().toString());
                        logiUsers(loginRequest);



                    }

                }


            });



    }

    private void logiUsers(LoginRequest loginRequest) {
        Call<LoginResponce> loginResponceCall=ApiClient.getService().loginUser(loginRequest);
        loginResponceCall.enqueue(new Callback<LoginResponce>() {
            @Override
            public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response) {
                String token = response.headers().get("Token");
                if (response.isSuccessful()){
                    sessionManager.saveAuthToken(response.body().getAuthToken());
                    String message=" Login Successful..";
                    Toast.makeText(LoginActivity.this,message, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this,DataCollectForms.class);
                    intent.putExtra("token",token);
                    startActivity(intent);

//                    startActivity(new Intent(LoginActivity.this, BusinessRelatedData1.class));
                    finish();
                }
                else {
                    String message = "An error occurred please try again later ...";
                    Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<LoginResponce> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(LoginActivity.this,message,Toast.LENGTH_LONG).show();



            }
        });

    }
}







