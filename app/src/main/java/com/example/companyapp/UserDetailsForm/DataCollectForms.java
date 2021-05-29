package com.example.companyapp.UserDetailsForm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.companyapp.MyApiConnect.MySessionManager;
import com.example.companyapp.R;
import com.example.companyapp.RetrofitBuilder;
import com.example.companyapp.SessionManager;
import com.example.companyapp.network.ApiService;
import com.example.companyapp.sevice.DataCollectFormsRequest;
import com.example.companyapp.sevice.DataCollectFormsResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataCollectForms extends AppCompatActivity {
    ApiService service;
   SessionManager sessionManager;

    private static final String TAG = "DataCollectForms";
    EditText etnametitle,etfirstname,etmiddlename,etlastname,etfathername,
             etmothername,etdob,etplaceofbirth,etcitizenship;
    Button btnnext;
    String authtoken,token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_collect_forms);
        Intent intent=getIntent();
        token=intent.getStringExtra("token");
//        if(sessionManager.getToken().getAccessToken() != null){
//            startActivity(new Intent(DataCollectForms.this, DataCollectForms1.class));
//            finish();
//        }


        sessionManager= sessionManager.getInstance(getSharedPreferences("prefs",MODE_PRIVATE));
        service = RetrofitBuilder.createServiceWithAuth(ApiService.class,sessionManager);

        etnametitle=findViewById(R.id.nametitle);
        etfirstname=findViewById(R.id.firstname);
        etmiddlename=findViewById(R.id.middlename);
        etlastname=findViewById(R.id.lastname);
        etfathername=findViewById(R.id.fathername);
        etmothername=findViewById(R.id.mothername);
        etdob=findViewById(R.id.dob);
        etplaceofbirth=findViewById(R.id.placeofbirth);
        etcitizenship=findViewById(R.id.citizenship);
        btnnext=findViewById(R.id.step2);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(etnametitle.getText().toString()) ||
                        TextUtils.isEmpty(etfirstname.getText().toString()) ||
                        TextUtils.isEmpty(etmiddlename.getText().toString()) ||
                        TextUtils.isEmpty(etlastname.getText().toString())||
                        TextUtils.isEmpty(etfathername.getText().toString()) ||
                        TextUtils.isEmpty(etmothername.getText().toString()) ||
                        TextUtils.isEmpty(etdob.getText().toString()) ||
                        TextUtils.isEmpty(etplaceofbirth.getText().toString()) ||
                        TextUtils.isEmpty(etcitizenship.getText().toString())){

                    String message = "All inputs required ..";
                    Toast.makeText(DataCollectForms.this,message,Toast.LENGTH_LONG).show();
                }else {
                    DataCollectFormsRequest dataCollectFormsRequest = new DataCollectFormsRequest();
                    dataCollectFormsRequest.setNametitle(etnametitle.getText().toString());
                    dataCollectFormsRequest.setFirstname(etfirstname.getText().toString());
                    dataCollectFormsRequest.setMiddlename(etmiddlename.getText().toString());
//                    dataCollectFormsRequest.setLastname(etlastname.getText().toString());
                    dataCollectFormsRequest.setFathername(etfathername.getText().toString());
                    dataCollectFormsRequest.setMothername(etmothername.getText().toString());
                    dataCollectFormsRequest.setDob(etdob.getText().toString());
                    dataCollectFormsRequest.setPlaceofbith(etplaceofbirth.getText().toString());
                    dataCollectFormsRequest.setCitizenship(etcitizenship.getText().toString());
                    dataformsUsers(dataCollectFormsRequest);
                }
            }
        });
    }

    boolean isFIrstTIme=false;

    private void dataformsUsers(DataCollectFormsRequest dataCollectFormsRequest) {
        if (isFIrstTIme){
            return;
        }
        isFIrstTIme=true;
        sessionManager.fetchAuthToken(DataCollectFormsResponce.getAuthToken());

        Call<DataCollectFormsResponce> dataCollectFormsResponceCall= service.datacollectform(dataCollectFormsRequest);
        dataCollectFormsResponceCall.enqueue(new Callback<DataCollectFormsResponce>() {
            @Override
            public void onResponse(Call<DataCollectFormsResponce> call, Response<DataCollectFormsResponce> response) {
                Log.w(TAG, "onResponse: " + response);
                authtoken = response.headers().get("Authtoken");

                if (response.isSuccessful()){

//                    tokenManager.saveToken(DataCollectFormsResponce.getAuthToken());
                    Log.w(TAG, "onResponse: " + response.body() );
                    String message=" Register Successful ,please verify your email..";
                    Toast.makeText(DataCollectForms.this,message, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DataCollectForms.this, DataCollectForms1.class));
                    finish();
                }
                else {
                    String message = "An error occurred please try again later ...";
                    Toast.makeText(DataCollectForms.this,message,Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<DataCollectFormsResponce> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(DataCollectForms.this,message,Toast.LENGTH_LONG).show();

            }
        });
    }


}