package com.example.saarc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class Details extends AppCompatActivity {
    private ImageButton wiki,map,video;
    private String url,url1,url2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        wiki = findViewById(R.id.wiki);
        map=findViewById(R.id.map);
        video=findViewById(R.id.video);
        String data = getIntent().getStringExtra("Number");

        if (data != null) {
            //int position = Integer.parseInt(data);
            //switch (position) {
                if(data.equals("Afghanistan")){
                    url = "https://en.wikipedia.org/wiki/Afghanistan";
                    url1="https://www.google.com/maps/d/u/0/viewer?mid=1JUKZukou8jqBKA7rnBb3KXyzR1I&hl=en&ll=35.64550363867426%2C65.37266299999999&z=6";
                    url2="https://www.youtube.com/watch?v=VMUx7s6mgH8";}

            if(data.equals("Bangladesh")){
                    url = "https://en.wikipedia.org/wiki/Bangladesh";
                    url1="https://www.google.com/maps/d/u/0/viewer?mid=1uqIMEpQ95Gk-80-q9CMiU-qtjuw&hl=en_US&ll=23.19543800302618%2C90.46331517068454&z=7";
                    url2="https://www.youtube.com/watch?v=puDBmnIXe_k";}
            if(data.equals("Bhutan")){
                    url = "https://en.wikipedia.org/wiki/Bhutan";
                    url1="https://www.google.com/maps/d/u/0/viewer?mid=1isCswHnAFw4e6PZES2goIXicqrs&hl=en&ll=27.497594265941977%2C89.95719349999997&z=10";
                    url2="https://www.youtube.com/watch?v=ptWlPV6at38";}
                if(data.equals("India")){
                    url = "https://en.wikipedia.org/wiki/India";
                    url1="https://www.google.com/maps/d/u/0/viewer?mid=1DBhwGb5W_2Vu5gPLMN_IsT7_thE&hl=en&ll=23.543844826108998%2C84.22668450000003&z=4";
                    url2="https://www.youtube.com/watch?v=35npVaFGHMY";}
                    if(data.equals("Maldives")){
                    url = "https://en.wikipedia.org/wiki/Maldives";
                    url1="https://www.google.com/maps/d/u/0/viewer?mid=1zXvAJDl7KeI1csE4eKHd27SpsxA&hl=en&ll=2.8985631968056023%2C73.31811350000002&z=7";
                    url2="https://www.youtube.com/watch?v=zFYLu8NhVdw";}
                        if(data.equals("Nepal")){
                    url = "https://en.wikipedia.org/wiki/Nepal";
                    url1="google.com/maps/d/u/0/viewer?mid=1fiDrlgL0LekeAa5nn0QPARpzyic&hl=en&ll=0%2C0&z=9";
                    url2="https://www.youtube.com/watch?v=3QWatKc-8JE";}
                            if(data.equals("Pakistan")){
                    url = "https://en.wikipedia.org/wiki/Pakistan";
                    url1="https://www.google.com/maps/d/u/0/viewer?mid=10UWiXaI2-LObzSQz5qglq_Znnao&hl=en&ll=36.75593946710967%2C74.51336999999998&z=6";
                    url2="https://www.youtube.com/watch?v=qvkLRdz8tR8";}
                                if(data.equals("SriLanka")){
                    url = "https://en.wikipedia.org/wiki/SriLanka";
                    url1="https://www.google.com/maps/d/u/0/viewer?mid=1aOI5Cmpp6WDhy10mDHCQPryi1Bw&hl=en_US&ll=7.053540882023482%2C79.863846&z=11";
                    url2="https://www.youtube.com/watch?v=OxFOuZCokLk";}

            }


        wiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Details.this, wikipedia.class);
                intent.putExtra("url", url);

                startActivity(intent);
            }
        });


        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Details.this, map.class);
                intent.putExtra("url1", url1);

                startActivity(intent);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Details.this, video.class);
                intent.putExtra("url2", url2);

                startActivity(intent);
            }
        });
    }
}
