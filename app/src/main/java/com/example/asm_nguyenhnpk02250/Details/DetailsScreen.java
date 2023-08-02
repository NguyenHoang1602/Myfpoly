package com.example.asm_nguyenhnpk02250.Details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.asm_nguyenhnpk02250.Model.NotificationStudy;
import com.example.asm_nguyenhnpk02250.R;

public class DetailsScreen extends AppCompatActivity {

    private TextView details;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);

        details = findViewById(R.id.tv_details);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        NotificationStudy notificationStudy = (NotificationStudy) bundle.get("Details");
        details.setText(notificationStudy.getDetails());


    }
}