package com.example.demouser.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Blackjack blackjack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void paintCard() {

        int cardValue = blackjack.getPlayerCards().get(0).getValue();
        int cardShape = blackjack.getPlayerCards().get(0).getShape();

        ImageView p1 = ((ImageView) findViewById(R.id.p1));
        if (cardValue == 0 && cardShape == 0) {
            p1.setImageResource(R.drawable.c2);
        }
    }
}
