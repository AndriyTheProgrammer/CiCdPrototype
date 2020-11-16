package com.orbismobile.testingforandroid2;

import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.orbismobile.testingforandroid2.view.login.LoginActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginInstrumentedTest {

    private String email;
    private String password;

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void initValidString() {
        email = "carlos@gmail.com";
        password = "password";
    }

    @Test
    public void clickLoginButton() {
        //type in email
        onView(withId(R.id.txtEmail)).perform(typeText(email), closeSoftKeyboard());

        //type in password
        onView(withId(R.id.txtPassword)).perform(typeText(password), closeSoftKeyboard());

        //click on login button
        onView(withId(R.id.btnLogin)).perform(click());

        //verify that succes screen shows
        String successString = "You're welcome! carlos@gmail.com";
        onView(withText(successString)).check(matches(isDisplayed()));
    }

    @Test
    public void normalClick() {
        String message = "login";
        onView(withId(R.id.btnLogin)).check(matches(withText(message)));
    }

    @Test
    public void usingHamcrest() {
        onView(allOf(withId(R.id.btnLogin), withText("login"))).perform(click());
    }

}
