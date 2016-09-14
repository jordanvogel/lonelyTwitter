package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by J-ROC on 9/13/2016.
 */
public class HappyMood extends CurrentMood {

   public HappyMood(){
       super();
   }

    public HappyMood(Date date){
        super(date);
    }

    @Override
    public String moodType() {
        return ":)";
    }
}
