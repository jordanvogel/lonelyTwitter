package ca.ualberta.cs.lonelytwitter;

/**
 * Created by J-ROC on 9/27/2016.
 */
import android.test.ActivityInstrumentationTestCase2;
import java.util.List;

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>{
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hallo!");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testHasTweet(){
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hallo!");

        assertFalse(list.hasTweet(tweet));
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hallo!");
        Tweet b = new NormalTweet("Hey.");

        list.add(a);
        list.add(b);

        assertEquals(a, list.getTweet(0));
        assertEquals(b, list.getTweet(1));
    }

    public void testDeleteTweet(){
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hallo!");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
        list.delete(tweet);
        assertFalse(list.hasTweet(tweet));
    }
    public void testCountTweet(){
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hallo!");
        assertEquals(1, list.getCount());

    }

    public void testGetTweets() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hallo!");
        Tweet b = new NormalTweet("Hey.");

        list.add(a);
        list.add(b);

        assertEquals(2, list.getTweets().getCount());
        for (int i =0; i <= list.getCount(); i++){
            assertTrue(list.getTweets().hasTweet(list.getTweet(i)));
        }

    }
}
