package com.example.companyapp.RegisterActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.companyapp.Activity.MainActivity;
import com.example.companyapp.Model.usermodel;
import com.example.companyapp.R;
import com.example.companyapp.Retrofitutil.ApiClient;
import com.example.companyapp.Retrofitutil.ApiInterface;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
//     implements GoogleApiClient.OnConnectionFailedListener
    CardView cardView;
    TextView LtextView,LtextForward;
    private GoogleSignInClient mGoogleSignInClient;
    ImageView imageView;
    private  static final int RC_SIGN_IN=100;
    CallbackManager c;
    TextInputEditText lemail,lpassword;



    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LtextForward=findViewById(R.id.Mot_de_passe_oublié);
        cardView=findViewById(R.id.L_connexion);
        LtextView=findViewById(R.id.txt_Sinscrire);
        lemail=findViewById(R.id.L_Email);
        lpassword=findViewById(R.id.L_Mot_de_passe);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                performLogin();
            }
        });


//        c = CallbackManager.Factory.create();
//        LoginButton loginButton = (LoginButton)findViewById(R.id.flogin_button);
//        loginButton.setPermissions(Arrays.asList("email","user_birthday"));
//        loginButton.registerCallback(c, new FacebookCallback<LoginResult>() {
//
//                }
//            @Override
//            public void onSuccess(LoginResult loginResult) {
////
//            }
//            @Override
//            public void onCancel() {
//                // App code
//            }
//            @Override
//            public void onError(FacebookException exception) {
//                // App code
//            }
//        });
//
//
//
//        LtextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(intent);
//            }
//        });
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(intent);
//            }
//        });

//        //Login google
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestEmail()
//                .build();
//        // Build a GoogleSignInClient with the options specified by gso.
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
//        // Check for existing Google Sign In account, if the user is already signed in
//// the GoogleSignInAccount will be non-null.
//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//        // Set the dimensions of the sign-in button.
//         imageView = findViewById(R.id.sign_in_button);
//         imageView.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View view) {
//                 signIn();
//             }
//         });
//    }
//
//
//
//
//        private void signIn() {
//            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//            startActivityForResult(signInIntent, RC_SIGN_IN);
//        }
//
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//
//    }
//
//
//
//
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        c.onActivityResult(requestCode, resultCode, data);
//
//
//        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            // The Task returned from this call is always completed, no need to attach
//            // a listener.
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            handleSignInResult(task);
//        }
//
//
//    }
//
//    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
//        try {
//            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
//            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
//            if (acct != null) {
//                String personName = acct.getDisplayName();
//                String personGivenName = acct.getGivenName();
//                String personFamilyName = acct.getFamilyName();
//                String personEmail = acct.getEmail();
//                String personId = acct.getId();
//                Uri personPhoto = acct.getPhotoUrl();
//
//            }
//          startActivity(new Intent(LoginActivity.this,MainActivity.class));
//            Toast.makeText(this, "Sign in success", Toast.LENGTH_SHORT).show();
//
//            // Signed in successfully, show authenticated UI.
//
//        } catch (ApiException e) {
//            // The ApiException status code indicates the detailed failure reason.
//            // Please refer to the GoogleSignInStatusCodes class reference for more information.
//            Log.d("message",e.toString());
//        }
//    }
//
//    AccessTokenTracker t =new AccessTokenTracker() {
//        @Override
//        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
//          if (currentAccessToken==null){
////              le.setText("");
//              Toast.makeText(LoginActivity.this, "Logout", Toast.LENGTH_SHORT).show();
//          }
//          else {
//              loaduserProfile(currentAccessToken);
//          }
//        }
//    };
//
//    private void loaduserProfile(AccessToken newAccessToken) {
//        GraphRequest request=GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
//            @Override
//            public void onCompleted(JSONObject object, GraphResponse response) {
//                if (object !=null){
//                    try {
//                        String email=object.getString("email");
//                        String id=object.getString("id");
////                        le.setText(email);
//                    }
//                    catch (JSONException ex){
//                        ex.printStackTrace();
//                    }
//                }
//
//
//            }
//        });
//        Bundle parameters=new Bundle();
//        parameters.putString("fields","email,id");
//        request.setParameters(parameters);
//        request.executeAsync();



    }
     private void performLogin(){
        String email=lemail.getText().toString();
        String password=lpassword.getText().toString();
        Call<usermodel> call= ApiClient.getApiClient().create(ApiInterface.class).loginuserPerform(email,password);
        call.enqueue(new Callback<usermodel>() {
            @Override
            public void onResponse(Call<usermodel> call, Response<usermodel> response) {
                if (response.code()==200){
                    if (response.body().getStatus().equals("ok")){
                        if (response.body().getResultCode()==1){
                          String name=response.body().getName();
                          Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                          intent.putExtra("name",name);
                          startActivity(intent);
                            Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                          finish();

                        }else {
                            displayUserInformation("Login Failed...");
                            lpassword.setText("");

                        }

                    }else {
                        displayUserInformation("somthing want wrong...");
                        lpassword.setText("");
                    }

                }else
                {
                    displayUserInformation("somthing want wrong...");
                    lpassword.setText("");
                }
            }

            @Override
            public void onFailure(Call<usermodel> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.toString(),Toast.LENGTH_LONG).show();

            }
        });
     }
     private  void displayUserInformation(String message){

     }

}