package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by J-ROC on 9/13/2016.
 */
public abstract class CurrentMood {
    public abstract String moodType();
    private Date date;

    public CurrentMood(Date date){
        this.date = date;
    }

    public CurrentMood(){
        this.date = new Date();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMood() {
        return this.moodType();
    }

    public Date getDate() {
        return date;
    }




}
