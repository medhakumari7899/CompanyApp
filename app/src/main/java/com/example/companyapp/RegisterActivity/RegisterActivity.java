package com.example.companyapp.RegisterActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.companyapp.Activity.MainActivity;
import com.example.companyapp.ApiError;
import com.example.companyapp.Model.RegisterRequest;
import com.example.companyapp.Model.RegisterResponse;
import com.example.companyapp.R;
import com.example.companyapp.RetrofitBuilder;
import com.example.companyapp.SessionManager;
import com.example.companyapp.Utils;
import com.example.companyapp.entities.AccessToken;
import com.example.companyapp.network.ApiService;
import com.example.companyapp.network.TokenManager;
import com.example.companyapp.sevice.ApiClient;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;


public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";

    ProgressDialog loadingBar;
    Button button;
    EditText etfirstname,etlastname,etemail,etpassword,etphone,etdob,etplaceofbirth,etcitizenship,etaddress;
//    Call<AccessToken> call;
    ApiService service;
    SessionManager sessionManager;
    String sendToken;
//    TokenManager tokenManager;
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etfirstname=findViewById(R.id.R_Prénom);
        etlastname=findViewById(R.id.R_nom_de_famille);
        etemail=findViewById(R.id.R_Adresse_email);
        etpassword=findViewById(R.id.R_Mot_de_passe);
        etphone=findViewById(R.id.R_Numéro_de_téléphone);
        etdob=findViewById(R.id.R_Date_de_naissance);
        etplaceofbirth=findViewById(R.id.R_lieu_de_naissance);
        etcitizenship=findViewById(R.id.R_Citoyenneté);
        etaddress=findViewById(R.id.R_Adresse);
        loadingBar = new ProgressDialog(RegisterActivity.this);
        button = findViewById(R.id.R_Sinscrire_maintenant);
        service = RetrofitBuilder.createService(ApiService.class);
        sessionManager = SessionManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));

//        if(tokenManager.getToken().getAccessToken() != null){
//            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
//            finish();
//        }



       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(TextUtils.isEmpty(etfirstname.getText().toString()) ||
                       TextUtils.isEmpty(etlastname.getText().toString()) ||
                       TextUtils.isEmpty(etemail.getText().toString()) ||
                       TextUtils.isEmpty(etpassword.getText().toString())||
                       TextUtils.isEmpty(etphone.getText().toString()) ||
                       TextUtils.isEmpty(etdob.getText().toString()) ||
                       TextUtils.isEmpty(etplaceofbirth.getText().toString()) ||
                       TextUtils.isEmpty(etcitizenship.getText().toString()) ||
                       TextUtils.isEmpty(etaddress.getText().toString())){

                   String message = "All inputs required ..";
                   Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_LONG).show();
               }else {
                   RegisterRequest registerRequest = new RegisterRequest();
                   RegisterResponse registerResponse=new RegisterResponse();
                   registerRequest.setFirstname(etfirstname.getText().toString());
                   registerRequest.setLastname(etlastname.getText().toString());
                   registerRequest.setEmail(etemail.getText().toString());
                   registerRequest.setPassword(etpassword.getText().toString());
                   registerRequest.setPhone(etphone.getText().toString());
                   registerRequest.setDob(etdob.getText().toString());
                   registerRequest.setPlaceofbirth(etplaceofbirth.getText().toString());
                   registerRequest.setCitizenship(etcitizenship.getText().toString());
                   registerRequest.setAddress(etaddress.getText().toString());
                   registerUsers(registerRequest,registerResponse);


               }
           }

       });
    }

    private void registerUsers(RegisterRequest registerRequest,RegisterResponse registerResponse) {


        Call<RegisterResponse> registerResponseCall= ApiClient.getService().registerUser( sendToken,registerRequest);
        registerResponseCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
//                Log.w(TAG, "onResponse: " + response);
                if (response.isSuccessful()){
                    sessionManager.saveAuthToken(registerResponse.getAuthToken());
                    Log.w(TAG, "onResponse: " + response.body() );
                    String message=" Register Successful ,please verify your email..";
                    Toast.makeText(RegisterActivity.this,message, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                    finish();
                }
                else {
                    String message = "An error occurred please try again later ...";
                    Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_LONG).show();

            }
        });


    }


}




