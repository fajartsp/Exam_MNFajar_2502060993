package com.example.fajar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
public class DetailActivity extends AppCompatActivity {
    TextView detailDesc, detailTitle;
    ImageView detailImage, detailMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detailDesc = findViewById(R.id.detailDesc);
        detailTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.detailImage);
       //detailMap = findViewById(R.id.detailMap);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailDesc.setText(bundle.getInt("Desc"));
            detailImage.setImageResource(bundle.getInt("Image"));
            detailTitle.setText(bundle.getString("Title"));
           // detailMap.setImageResource(bundle.getInt("Map"));
        }
    }
}