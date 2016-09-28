package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J-ROC on 9/27/2016.
 */

public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();
    public void add(Tweet tweet) {
        tweets.add(tweet);
    }
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }
    public Tweet getTweet(int i){
        return tweets.get(i);
    }
    public void delete(Tweet a){
        tweets.remove(a);
    }

    public int getCount(){
        return tweets.size();
    }

    public TweetList getTweets(){
        TweetList list = new TweetList();
        for(int i = 0; i <= tweets.size(); i++){
            list.add(tweets.get(i));
        }
        return list;
    }
}
