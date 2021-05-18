package com.example.companyapp.UserDetailsForm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.companyapp.Model.RegisterRequest;
import com.example.companyapp.R;
import com.example.companyapp.RegisterActivity.LoginActivity;
import com.example.companyapp.RegisterActivity.RegisterActivity;
import com.example.companyapp.RetrofitBuilder;
import com.example.companyapp.SessionManager;
import com.example.companyapp.network.ApiService;
import com.example.companyapp.sevice.ApiClient;
import com.example.companyapp.sevice.BusinessRelatedData1Request;
import com.example.companyapp.sevice.BusinessRelatedData1Response;
import com.example.companyapp.sevice.DataCollectFormsResponce;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusinessRelatedData1 extends AppCompatActivity {
    private static final String TAG = "BussinessRelatedData1 ";

    ProgressDialog loadingBar;
    ApiService service;
    SessionManager sessionManager;
    ApiClient apiClient;
    private String sendToken;
    private String retrivedToken;
    private SharedPreferences prefs;
    public static final String MyPREFERENCES = "myprefs";
    public static final  String value = "key";

    EditText companyname,commercialname,acronym,businessactivity,businessactivity2,businessactivity3
            ,businessactivity4;
    Button next1,previous1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_related_data1);
        companyname =findViewById(R.id.companyname);
        service = RetrofitBuilder.createService(ApiService.class);
        sessionManager = SessionManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));
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
        Call<BusinessRelatedData1Response> businessRelatedData1ResponseCall= ApiClient.getService().businessrelateddata1( sendToken,businessRelatedData1Request);
        businessRelatedData1ResponseCall.enqueue(new Callback<BusinessRelatedData1Response>() {
            @Override
            public void onResponse(Call<BusinessRelatedData1Response> call, Response<BusinessRelatedData1Response> response) {
                String token = response.headers().get("Token");
                if (response.isSuccessful()){
                    sendToken = token;
//                    sessionManager.fetchAuthToken(DataCollectFormsResponce.getAuthToken());
                    Log.w(TAG, "onResponse: " + response.body() );
                    String message=" Register Successful ,please verify your email..";
                    Toast.makeText(BusinessRelatedData1.this,message, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BusinessRelatedData1.this, BusinessRelatedData1.class));
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