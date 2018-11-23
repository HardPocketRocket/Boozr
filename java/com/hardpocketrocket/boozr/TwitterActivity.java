package com.hardpocketrocket.boozr;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterActivity extends AppCompatActivity {
    private Twitter twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("EYj4wO0Jb9jSIqH03vvSxSiHe")
                .setOAuthConsumerSecret("MPultqSupxLmnlM7kjfkYduH7f2oNlALMR2FRGdEBswDKBOZ5R")
                .setOAuthAccessToken("1065936988853944323-BuLwqPSPWCHWVyBa6qj2TAS1qpXTrU")
                .setOAuthAccessTokenSecret("aQnStqAt3Tee8eVnrKYCbaiJUkAcv9B26DaEsvDorqXuS");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();

        new PostTwitterAsync().execute("Boozr: Hello Twitter");
    }

    public class PostTwitterAsync extends AsyncTask<String, Void, String>{
        String result = "";

        @Override
        protected String doInBackground(String... tweet) {
            try {
                twitter.updateStatus(tweet[0]);
            } catch (TwitterException e) {
                e.printStackTrace();
            }
            return result;
        }
    }
}
