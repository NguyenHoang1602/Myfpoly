package com.example.asm_nguyenhnpk02250.Details;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.asm_nguyenhnpk02250.Model.NotificationAction;
import com.example.asm_nguyenhnpk02250.Model.NotificationTuition;
import com.example.asm_nguyenhnpk02250.R;

public class DetailsScreenTuition extends AppCompatActivity {

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
        NotificationTuition notificationTuition = (NotificationTuition) bundle.get("Details");
        details.setText(notificationTuition.getDetails());


    }
}