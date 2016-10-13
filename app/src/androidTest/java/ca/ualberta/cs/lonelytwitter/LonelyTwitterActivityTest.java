import static junit.framework.Assert.assertEquals;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

import ca.ualberta.cs.lonelytwitter.EditTweetActivity;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.R;
import ca.ualberta.cs.lonelytwitter.Tweet;

/**
 * Unit tests for LonelyTwitter
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void setUp() throws Exception {
        Log.d("TAG1","setUp()");
        solo = new Solo(getInstrumentation(),getActivity());

    }

    public void testTweet() {
        solo.assertCurrentActivity("wrong Activity", LonelyTwitterActivity.class);

        solo.enterText((EditText) solo.getView(R.id.body),"Test Tweet");
        solo.clickOnButton("Save");

        assertTrue(solo.waitForText("Test Tweet"));

        solo.clickOnButton("Clear");
        assertFalse(solo.waitForText("Test Tweet",1, 1000));
    }

    public void testClickTweetList() {
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();

        solo.assertCurrentActivity("wrong Activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body),"Test Tweet");
        solo.clickOnButton("Save");
        solo.waitForText("Test Tweet");

        final ListView oldTweetList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetList.getItemAtPosition(0);
        assertEquals("Test Tweet", tweet.getMessage());

        solo.clickInList(0);

        solo.assertCurrentActivity("Wrong activity", EditTweetActivity.class);

    }

    public void testEditTweet() {
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();

        solo.assertCurrentActivity("wrong Activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body),"Test Tweet");
        solo.clickOnButton("Save");
        solo.waitForText("Test Tweet");

        final ListView oldTweetList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetList.getItemAtPosition(0);
        assertEquals("Test Tweet", tweet.getMessage());

        solo.clickInList(0);

        solo.assertCurrentActivity("Wrong activity", EditTweetActivity.class);

        TextView tv = (TextView) solo.getView(R.id.textView);
        String contents = tv.getText().toString();

        assertEquals("Test Tweet", contents);

        solo.searchText("Test Tweet", Boolean.TRUE);

        solo.goBack();

        solo.assertCurrentActivity("Wrong activity", LonelyTwitterActivity.class);
    }

    @Override
    public void tearDown() throws  Exception {
        solo.finishOpenedActivities();
    }
}