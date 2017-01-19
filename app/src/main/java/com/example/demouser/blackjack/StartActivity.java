package com.example.demouser.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ((ImageView) findViewById(R.id.blackjackImage)).setImageResource(R.drawable.blackjack_display);
        ((TextView)findViewById(R.id.blackjackText)).setText("BLACKJACK");

        ((Button) findViewById(R.id.playButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                play();
            }
        });
    }

    public void play() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
