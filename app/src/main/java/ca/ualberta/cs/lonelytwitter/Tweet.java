package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by J-ROC on 9/13/2016.
 */
public abstract class Tweet {
    private String message;
    private Date date;
    private ArrayList<CurrentMood> moodList = new ArrayList<CurrentMood>();


    public Tweet(String message){
        this.message = message;
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    public abstract Boolean isImportant();

    public void setMessage(String message) throws TweetTooLongException {
        if(message.length() > 140){
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void addMood(CurrentMood mood){
        moodList.add(mood);
    }
}
