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
                .setOAuthConsumerKey(getString(R.string.consumer_key))
                .setOAuthConsumerSecret(getString(R.string.consumer_secret_key))
                .setOAuthAccessToken(getString(R.string.access_key))
                .setOAuthAccessTokenSecret(getString(R.string.access_secret_key));
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
