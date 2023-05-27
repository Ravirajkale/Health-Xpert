package com.example.a24health;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthArticleDetailsActivity extends AppCompatActivity {

    TextView txt;
    ImageView img;
    Button btback;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article_details);
        getSupportActionBar().hide();

        btback=findViewById(R.id.buttonHADBack);
        txt=findViewById(R.id.textViewHADDialogue);
        img=findViewById(R.id.imageView);

        Intent intent=getIntent();
        txt.setText(intent.getStringExtra("text1"));
        Bundle bundle=getIntent().getExtras();
        if (bundle !=null){
            int resId=bundle.getInt("text2");
            img.setImageResource(resId);
        }
        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticleDetailsActivity.this,healthArticlesActivity.class));
            }
        });
    }
}