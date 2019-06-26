package com.example.onoderat.benefitcontents;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView textView = findViewById(R.id.sub_activity_text);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra(getString(R.string.intent_cell_text)));
    }
}
