package com.orbismobile.testingforandroid;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.orbismobile.testingforandroid.view.pet.PetSectionsActivity;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagKey;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 8/30/17.
 */
@RunWith(AndroidJUnit4.class)
public class PetSectionsInstrumentedTest {

    @Rule
    public ActivityTestRule<PetSectionsActivity> petSectionsActivityTestRule =
            new ActivityTestRule<PetSectionsActivity>(PetSectionsActivity.class);

    @Test
    public void clickOnAnyItem(){
        onView(withId(R.id.rcvPetSections)).perform(RecyclerViewActions.actionOnItemAtPosition(10, clickChildViewWithId()));

    }

    public static ViewAction clickChildViewWithId() {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                RecyclerView rcvHorizontal = view.findViewById(R.id.rcvHorizontal);
                rcvHorizontal.findViewHolderForAdapterPosition(2).itemView.performClick();
            }
        };
    }
}
