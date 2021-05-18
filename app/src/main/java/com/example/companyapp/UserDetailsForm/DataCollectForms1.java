package com.example.companyapp.UserDetailsForm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.companyapp.R;

public class DataCollectForms1 extends AppCompatActivity {
    EditText etresidencesector,etplaceofresidence,etcountryofresidence,
            etprofession,etidpassportno,etissuedate,etissueauthority;
    Button datacollectprev,datacollectnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_collect_forms2);
        etresidencesector=findViewById(R.id.residencesector);
        etplaceofresidence=findViewById(R.id.placeofresidence);
        etcountryofresidence=findViewById(R.id.countryofresidence);
        etprofession=findViewById(R.id.profession);
        etidpassportno=findViewById(R.id.idpassportno);
        etissuedate=findViewById(R.id.issuedate);
        etissueauthority=findViewById(R.id.issueauthority);
        datacollectprev=findViewById(R.id.datacollect_pevious);
        datacollectnext=findViewById(R.id.datacollect_next);

        
    }
}