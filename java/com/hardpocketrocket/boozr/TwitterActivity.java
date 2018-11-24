package com.hardpocketrocket.boozr;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hardpocketrocket.boozr.Model.User;

import io.realm.Realm;
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

        Button postButton = findViewById(R.id.post_button);
        EditText tweet = findViewById(R.id.tweet_edit);

        User user = Realm.getDefaultInstance().where(User.class).findFirst();
        String tweetText = user.getFirstName() + " " + user.getLastName() + ": Has drunk a total of "
                + user.getDays().get(user.getDays().size() - 1).getNumberOfDrinks() + " drinks and spent a total of "
                + user.getDays().get(user.getDays().size() - 1).getTotalCostOfDrinks() + " dollars on drinks on "
                + user.getDays().get(user.getDays().size() - 1).getDate().toString();

        tweet.setText(tweetText);

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(getString(R.string.consumer_key))
                .setOAuthConsumerSecret(getString(R.string.consumer_secret_key))
                .setOAuthAccessToken(getString(R.string.access_key))
                .setOAuthAccessTokenSecret(getString(R.string.access_secret_key));
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostTwitterAsync().execute(tweet.getText().toString());
            }
        });
    }

    public class PostTwitterAsync extends AsyncTask<String, Void, String> {
        String result = "";

        @Override
        protected String doInBackground(String... tweet) {
            try {
                twitter.updateStatus(tweet[0]);
                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Successfully Posted To Twitter", Toast.LENGTH_LONG).show();
                    }
                });
            } catch (TwitterException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Failed Posting To Twitter", Toast.LENGTH_LONG).show();
                    }
                });
            }
            return result;
        }
    }
}
