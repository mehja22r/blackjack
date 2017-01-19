package com.example.demouser.blackjack;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Blackjack blackjack = new Blackjack();

    private TextView playerTotalText;
    private TextView dealerTotalText;
    private EditText enterBetText;
    private TextView betText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blackjack = new Blackjack();
        playerTotalText = (TextView) findViewById(R.id.playerTotal);
        dealerTotalText = (TextView) findViewById(R.id.dealerTotal);
        enterBetText = (EditText) findViewById(R.id.enterBet);
        betText = (TextView) findViewById(R.id.bet);

        playerTotalText.setText("Player: " + String.valueOf(blackjack.playerScore()));
        dealerTotalText.setText("Dealer: ?");
        betText.setText("Bet: " + String.valueOf(blackjack.bet));

        ((Button)findViewById(R.id.dealButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBet();
                blackjack.startGame();
                paintCard();
                updateView();
            }
        });

        ((Button)findViewById(R.id.hitButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blackjack.hit();
                paintCard();
                updateView();
                dealerTotalText.setText("Dealer: ?");
            }
        });

        ((Button)findViewById(R.id.standButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blackjack.stand();
                updateView();
                dealerTotalText.setText("Dealer: " + String.valueOf(blackjack.dealerScore()));
                //add functionality to end the round
                //TextView result = (TextView) findViewById(R.id.resultMessage);
                //result.setText();

                //clear the deck
                blackjack.getPlayerCards().clear();
                blackjack.getDealerCards().clear();
                paintCard();
            }
        });

        ((Button)findViewById(R.id.doubleButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blackjack.doubleBet();
                betText.setText("Bet: " + String.valueOf(blackjack.bet));
            }
        });
    }

    public void getBet() {
        blackjack.currentBet = Integer.parseInt(enterBetText.getText().toString());
        //add functionality for max and min bet
    }

    public void updateView() {
        playerTotalText.setText("Player: " + String.valueOf(blackjack.playerScore()));
        betText.setText("Bet: " + String.valueOf(blackjack.bet));
    }

    public void paintCard() {
        ImageView p1 = ((ImageView) findViewById(R.id.p1));
        ImageView p2 = ((ImageView) findViewById(R.id.p2));
        ImageView p3 = ((ImageView) findViewById(R.id.p3));
        ImageView p4 = ((ImageView) findViewById(R.id.p4));
        ImageView p5 = ((ImageView) findViewById(R.id.p5));
        ImageView p6 = ((ImageView) findViewById(R.id.p6));

        ImageView d1 = ((ImageView) findViewById(R.id.d1));
        ImageView d2 = ((ImageView) findViewById(R.id.d2));
        ImageView d3 = ((ImageView) findViewById(R.id.d3));
        ImageView d4 = ((ImageView) findViewById(R.id.d4));
        ImageView d5 = ((ImageView) findViewById(R.id.d5));

        if (blackjack.getPlayerCards().isEmpty()) {
            p1.setImageResource(R.drawable.j);
            p2.setImageResource(R.drawable.j);
            p3.setImageResource(R.drawable.j);
            p4.setImageResource(R.drawable.j);
            p5.setImageResource(R.drawable.j);
            p6.setImageResource(R.drawable.j);
        }

        //for loop
        for (int i = 0; i < blackjack.getPlayerCards().size(); i++) {

            int cardValue = blackjack.getPlayerCards().get(i).getValue();
            int cardShape = blackjack.getPlayerCards().get(i).getShape();

            if (i==0)
                showCard(p1,cardValue,cardShape);
            else if (i ==1)
                showCard(p2, cardValue, cardShape);
            else if (i == 2)
                showCard(p3, cardValue, cardShape);
            else if (i == 3)
                showCard(p4, cardValue, cardShape);
            else if (i==4)
                showCard(p5, cardValue, cardShape);
            else if (i==5)
                showCard(p6, cardValue, cardShape);
        }

        if (blackjack.getDealerCards().isEmpty()) {
            d1.setImageResource(R.drawable.j);
            d2.setImageResource(R.drawable.j);
            d3.setImageResource(R.drawable.j);
            d4.setImageResource(R.drawable.j);
            d5.setImageResource(R.drawable.j);
        }

        for (int j = 0;j < blackjack.getDealerCards().size(); j++) {
            int cardValue = blackjack.getDealerCards().get(j).getValue();
            int cardShape = blackjack.getDealerCards().get(j).getShape();

            if (j==0)
                showCard(d1, cardValue, cardShape);
            else if (j==1)
                showCard(d2, cardValue, cardShape);
            else if (j==2)
                showCard(d3, cardValue, cardShape);
            else if (j==3)
                showCard(d4, cardValue, cardShape);
            else if (j==4)
                showCard(d5, cardValue, cardShape);
        }

        if (blackjack.revealDealerCards == true) {
            for (int j = 1; j < blackjack.getDealerCards().size(); j++) {

                int cardValue = blackjack.getDealerCards().get(j).getValue();
                int cardShape = blackjack.getDealerCards().get(j).getShape();

                if (j == 1)
                    showCard(d2, cardValue, cardShape);
                else if (j == 2)
                    showCard(d3, cardValue, cardShape);
                else if (j == 3)
                    showCard(d4, cardValue, cardShape);
                else if (j == 4)
                    showCard(d5, cardValue, cardShape);
            }
        }
    }

    public void showCard(ImageView p1, int cardValue, int cardShape) {
        if (cardValue == 0 && cardShape == 0)
            p1.setImageResource(R.drawable.c2);
        else if (cardValue==0 && cardShape==1)
            p1.setImageResource(R.drawable.d2);
        else if (cardValue==0 && cardShape==2)
            p1.setImageResource(R.drawable.h2);
        else if (cardValue==0 && cardShape==3)
            p1.setImageResource(R.drawable.s2);
        else if (cardValue==1 && cardShape==0)
            p1.setImageResource(R.drawable.c3);
        else if (cardValue==1 && cardShape==1)
            p1.setImageResource(R.drawable.d3);
        else if (cardValue==1 && cardShape==2)
            p1.setImageResource(R.drawable.h3);
        else if (cardValue==1 && cardShape==3)
            p1.setImageResource(R.drawable.s3);
        else if (cardValue==2 && cardShape==0)
            p1.setImageResource(R.drawable.c4);
        else if (cardValue==2 && cardShape==1)
            p1.setImageResource(R.drawable.d4);
        else if (cardValue==2 && cardShape==2)
            p1.setImageResource(R.drawable.h4);
        else if (cardValue==2 && cardShape==3)
            p1.setImageResource(R.drawable.s4);
        else if (cardValue==3 && cardShape==0)
            p1.setImageResource(R.drawable.c5);
        else if (cardValue==3 && cardShape==1)
            p1.setImageResource(R.drawable.d5);
        else if (cardValue==3 && cardShape==2)
            p1.setImageResource(R.drawable.h5);
        else if (cardValue==3 && cardShape==3)
            p1.setImageResource(R.drawable.s5);
        else if (cardValue==4 && cardShape==0)
            p1.setImageResource(R.drawable.c6);
        else if (cardValue==4 && cardShape==1)
            p1.setImageResource(R.drawable.d6);
        else if (cardValue==4 && cardShape==2)
            p1.setImageResource(R.drawable.h6);
        else if (cardValue==4 && cardShape==3)
            p1.setImageResource(R.drawable.s6);
        else if (cardValue==5 && cardShape==0)
            p1.setImageResource(R.drawable.c7);
        else if (cardValue==5 && cardShape==1)
            p1.setImageResource(R.drawable.d7);
        else if (cardValue==5 && cardShape==2)
            p1.setImageResource(R.drawable.h7);
        else if (cardValue==5 && cardShape==3)
            p1.setImageResource(R.drawable.s7);
        else if (cardValue==6 && cardShape==0)
            p1.setImageResource(R.drawable.c8);
        else if (cardValue==6 && cardShape==1)
            p1.setImageResource(R.drawable.d8);
        else if (cardValue==6 && cardShape==2)
            p1.setImageResource(R.drawable.h8);
        else if (cardValue==6 && cardShape==3)
            p1.setImageResource(R.drawable.s8);
        else if (cardValue==7 && cardShape==0)
            p1.setImageResource(R.drawable.c9);
        else if (cardValue==7 && cardShape==1)
            p1.setImageResource(R.drawable.d9);
        else if (cardValue==7 && cardShape==2)
            p1.setImageResource(R.drawable.h9);
        else if (cardValue==7 && cardShape==3)
            p1.setImageResource(R.drawable.s9);
        else if (cardValue==8 && cardShape==0)
            p1.setImageResource(R.drawable.c10);
        else if (cardValue==8 && cardShape==1)
            p1.setImageResource(R.drawable.d10);
        else if (cardValue==8 && cardShape==2)
            p1.setImageResource(R.drawable.h10);
        else if (cardValue==8 && cardShape==3)
            p1.setImageResource(R.drawable.s10);
        else if (cardValue==9 && cardShape==0)
            p1.setImageResource(R.drawable.jc);
        else if (cardValue==9 && cardShape==1)
            p1.setImageResource(R.drawable.jd);
        else if (cardValue==9 && cardShape==2)
            p1.setImageResource(R.drawable.jh);
        else if (cardValue==9 && cardShape==3)
            p1.setImageResource(R.drawable.js);
        else if (cardValue==10 && cardShape==0)
            p1.setImageResource(R.drawable.qc);
        else if (cardValue==10 && cardShape==1)
            p1.setImageResource(R.drawable.qd);
        else if (cardValue ==10 && cardShape==2)
            p1.setImageResource(R.drawable.qh);
        else if (cardValue==10 && cardShape==3)
            p1.setImageResource(R.drawable.qs);
        else if (cardValue==11 && cardShape==0)
            p1.setImageResource(R.drawable.kc);
        else if (cardValue==11 && cardShape==1)
            p1.setImageResource(R.drawable.kd);
        else if (cardValue==11 && cardShape==2)
            p1.setImageResource(R.drawable.kh);
        else if (cardValue==11 && cardShape==3)
            p1.setImageResource(R.drawable.ks);
        else if (cardValue==12 && cardShape==0)
            p1.setImageResource(R.drawable.ac);
        else if (cardValue==12 && cardShape==1)
            p1.setImageResource(R.drawable.ad);
        else if (cardValue==12 && cardShape==2)
            p1.setImageResource(R.drawable.ah);
        else if (cardValue==12 && cardShape==3)
            p1.setImageResource(R.drawable.as);
    }
}

