package com.example.companyapp.UserDetailsForm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.companyapp.MyApiConnect.AuthenticationInterceptor;
import com.example.companyapp.MyApiConnect.MyApiClient;
import com.example.companyapp.MyApiConnect.MySessionManager;
import com.example.companyapp.R;
import com.example.companyapp.RegisterActivity.LoginActivity;
import com.example.companyapp.RetrofitBuilder;
import com.example.companyapp.SessionManager;
import com.example.companyapp.network.ApiService;
import com.example.companyapp.sevice.ApiClient;
import com.example.companyapp.sevice.BusinessRelatedData1Request;
import com.example.companyapp.sevice.BusinessRelatedData1Response;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusinessRelatedData1 extends AppCompatActivity {
    private static final String TAG = "BussinessRelatedData1 ";

    ProgressDialog loadingBar;
    ApiService service;
    Call<BusinessRelatedData1Response> call;

    SessionManager sessionManager;
    ApiClient apiClient;
    private String authtoken;
    TokenManager tokenManager;
    EditText companyname,commercialname,acronym,businessactivity,businessactivity2,businessactivity3
            ,businessactivity4;
    Button next1,previous1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_related_data1);
        companyname =findViewById(R.id.companyname);
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));

        if(tokenManager.getToken() == null){
            startActivity(new Intent(BusinessRelatedData1.this, LoginActivity.class));
            finish();
        }

        service = RetrofitBuilder.createServiceWithAuth(ApiService.class, sessionManager);


//        if(tokenManager.getToken() == null){
//           startActivity(new Intent(getApplicationContext(), DataCollectForms1.class));
//            finish();
//        }
//        service = RetrofitBuilder.createServiceWithAuth(ApiService.class,tokenManager);
//
//        tokenManager =tokenManager.getInstance(getSharedPreferences("prefs",MODE_PRIVATE));
////        sessionManager = SessionManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));
        commercialname=findViewById(R.id.commercialname);
        acronym=findViewById(R.id.acronym);
        businessactivity=findViewById(R.id.businessactivity);
        businessactivity2=findViewById(R.id.businessactivity2);
        businessactivity3=findViewById(R.id.businessactivity3);
        businessactivity4=findViewById(R.id.businessactivity4);
        next1=findViewById(R.id.next1);
        previous1=findViewById(R.id.previous1);
        loadingBar = new ProgressDialog(BusinessRelatedData1.this);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if
                       (TextUtils.isEmpty(companyname.getText().toString()) ||
                        TextUtils.isEmpty(commercialname.getText().toString()) ||
                        TextUtils.isEmpty(acronym.getText().toString()) ||
                        TextUtils.isEmpty(businessactivity.getText().toString())||
                        TextUtils.isEmpty(businessactivity2.getText().toString()) ||
                        TextUtils.isEmpty(businessactivity3.getText().toString()) ||
                        TextUtils.isEmpty(businessactivity4.getText().toString())){

                    String message = "All inputs required ..";
                    Toast.makeText(BusinessRelatedData1.this,message,Toast.LENGTH_LONG).show();
                }else {
                    BusinessRelatedData1Request businessRelatedData1Request = new BusinessRelatedData1Request();
                    businessRelatedData1Request.setCompanyname(companyname.getText().toString());
                    businessRelatedData1Request.setCommercialname(commercialname.getText().toString());
                    businessRelatedData1Request.setAcronym(acronym.getText().toString());
                    businessRelatedData1Request.setBusinessactivity(businessactivity.getText().toString());
                    businessRelatedData1Request.setBusinessactivity2(businessactivity2.getText().toString());
                    businessRelatedData1Request.setBusinessactivity3(businessactivity3.getText().toString());
                    businessRelatedData1Request.setBusinessactivity4(businessactivity4.getText().toString());
                    businessrelateddata1(businessRelatedData1Request);
                }
            }

        });

    }

    public void businessrelateddata1(BusinessRelatedData1Request businessRelatedData1Request) {
        call=service.businessrelateddata1(businessRelatedData1Request);
////        Call<BusinessRelatedData1Request> businessRelatedData1RequestCall= service.businessrelateddata1( authtoken,businessRelatedData1Request);
//        businessRelatedData1RequestCall.enqueue(new Callback<BusinessRelatedData1Request>() {
//            @Override
//            public void onResponse(Call<BusinessRelatedData1Request> call, Response<BusinessRelatedData1Request> response) {
//                String token = response.headers().get("Token");
//                Log.w(TAG, "onResponse: " + response.body() );
//
//                if (response.isSuccessful()){
//                    token = authtoken;
////                    sessionManager.fetchAuthToken(DataCollectFormsResponce.getAuthToken());
//                    Log.w(TAG, "onResponse: " + response.body() );
//                    String message=" Register Successful ,please verify your email..";
//                    Toast.makeText(BusinessRelatedData1.this,message, Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(BusinessRelatedData1.this, DataCollectForms.class));
//                    finish();
//                }
//                else {
//                    String message = "An error occurred please try again later ...";
//                    Toast.makeText(BusinessRelatedData1.this,message,Toast.LENGTH_LONG).show();
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BusinessRelatedData1Request> call, Throwable t) {
//                String message = t.getLocalizedMessage();
//                Toast.makeText(BusinessRelatedData1.this,message,Toast.LENGTH_LONG).show();
//
//
//            }
//        });
     call.enqueue(new Callback<BusinessRelatedData1Response>() {
         @Override
         public void onResponse(Call<BusinessRelatedData1Response> call, Response<BusinessRelatedData1Response> response) {
                             if (response.isSuccessful()){
                                 String token = authtoken;
//                   TokenManager.fetchAuthToken(DataCollectFormsResponce.getAuthToken());
                    Log.w(TAG, "onResponse: " + response.body() );
                    String message=" Register Successful ,please verify your email..";
                    Toast.makeText(BusinessRelatedData1.this,message, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BusinessRelatedData1.this, DataCollectForms.class));
                    finish();
                }
                else {

                    String message = "An error occurred please try again later ...";
                    Toast.makeText(BusinessRelatedData1.this,message,Toast.LENGTH_LONG).show();

                }
            }



         @Override
         public void onFailure(Call<BusinessRelatedData1Response> call, Throwable t) {
                            String message = t.getLocalizedMessage();
              Toast.makeText(BusinessRelatedData1.this,message,Toast.LENGTH_LONG).show();



         }
     });


    }

}