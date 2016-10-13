package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EditTweetActivity extends Activity implements Serializable{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        Bundle extras = getIntent().getExtras();
        String editTweet = extras.getString("EditTweet");

        TextView tv = (TextView) findViewById(R.id.editTweetList);
        tv.setText(editTweet);


    }
}
