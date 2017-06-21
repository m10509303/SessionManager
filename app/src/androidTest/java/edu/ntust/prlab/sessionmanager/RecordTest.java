package edu.ntust.prlab.sessionmanager;


import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.GeneralSwipeAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Swipe;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.nio.charset.StandardCharsets;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RecordTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        onView(allOf(withId(R.id.button_add), isDisplayed()))
                .perform(click());

        onView(allOf(withId(R.id.input_name), isDisplayed()))
                .perform(replaceText("s1"), closeSoftKeyboard());

        onView(allOf(withId(R.id.input_age), isDisplayed()))
                .perform(replaceText("87"), closeSoftKeyboard());

        onView(allOf(withId(android.R.id.button1), withText("OK")))
                .perform(scrollTo(), click());

        onView(allOf(withId(R.id.button_add), isDisplayed()))
                .perform(click());

        onView(allOf(withId(R.id.input_name), isDisplayed()))
                .perform(replaceText("s2"), closeSoftKeyboard());

        onView(allOf(withId(R.id.input_age), isDisplayed()))
                .perform(replaceText("36"), closeSoftKeyboard());

        onView(allOf(withId(R.id.radio_female),
                withParent(withId(R.id.radio_gender)),
                isDisplayed()))
                .perform(click());

        onView(allOf(withId(android.R.id.button1), withText("OK")))
                .perform(scrollTo(), click());

        onView(allOf(withId(R.id.button_add), isDisplayed()))
                .perform(click());

        onView(allOf(withId(R.id.input_name), isDisplayed()))
                .perform(replaceText("s0"), closeSoftKeyboard());

        onView(allOf(withId(R.id.input_age), isDisplayed()))
                .perform(replaceText("44"), closeSoftKeyboard());

        onView(allOf(withId(android.R.id.button1), withText("OK")))
                .perform(scrollTo(), click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        onView(allOf(withId(R.id.title), withText("Sort by Name"), isDisplayed()))
                .perform(click());

        onView(allOf(withId(R.id.item_name),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                0),
                        1),
                isDisplayed()))
                .check(matches(withText("s0")));

        onView(allOf(withId(R.id.item_gender),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                0),
                        2),
                isDisplayed()))
                .check(matches(withText("\u2642")));

        onView(allOf(withId(R.id.item_age),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                0),
                        3),
                isDisplayed()))
                .check(matches(withText("44")));

        onView(allOf(withId(R.id.item_name),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                1),
                        1),
                isDisplayed()))
                .check(matches(withText("s1")));

        onView(allOf(withId(R.id.item_gender),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                1),
                        2),
                isDisplayed()))
                .check(matches(withText("\u2642")));

        onView(allOf(withId(R.id.item_age),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                1),
                        3),
                isDisplayed()))
                .check(matches(withText("87")));

        onView(allOf(withId(R.id.item_name),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                2),
                        1),
                isDisplayed()))
                .check(matches(withText("s2")));

        onView(allOf(withId(R.id.item_gender),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                2),
                        2),
                isDisplayed()))
                .check(matches(withText("\u2640")));

        onView(allOf(withId(R.id.item_age),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                2),
                        3),
                isDisplayed()))
                .check(matches(withText("36")));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        onView(allOf(withId(R.id.title), withText("Sort by Gender"), isDisplayed()))
                .perform(click());


        onView(allOf(withId(R.id.item_name),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                0),
                        1),
                isDisplayed()))
                .check(matches(withText("s2")));

        onView(allOf(withId(R.id.item_gender),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                0),
                        2),
                isDisplayed()))
                .check(matches(withText("\u2640")));

        onView(allOf(withId(R.id.item_age),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                0),
                        3),
                isDisplayed()))
                .check(matches(withText("36")));

        onView(allOf(withId(R.id.item_name),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                1),
                        1),
                isDisplayed()))
                .check(matches(withText("s1")));

        onView(allOf(withId(R.id.item_gender),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                1),
                        2),
                isDisplayed()))
                .check(matches(withText("\u2642")));

        onView(allOf(withId(R.id.item_age),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                1),
                        3),
                isDisplayed()))
                .check(matches(withText("87")));

        onView(allOf(withId(R.id.item_name),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                2),
                        1),
                isDisplayed()))
                .check(matches(withText("s0")));

        onView(allOf(withId(R.id.item_gender),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                2),
                        2),
                isDisplayed()))
                .check(matches(withText("\u2642")));

        onView(allOf(withId(R.id.item_age),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                2),
                        3),
                isDisplayed()))
                .check(matches(withText("44")));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        onView(allOf(withId(R.id.title), withText("Sort by Age"), isDisplayed()))
                .perform(click());

        onView(allOf(withId(R.id.item_name),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                0),
                        1),
                isDisplayed()))
                .check(matches(withText("s2")));

        onView(allOf(withId(R.id.item_gender),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                0),
                        2),
                isDisplayed()))
                .check(matches(withText("\u2640")));

        onView(allOf(withId(R.id.item_age),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                0),
                        3),
                isDisplayed()))
                .check(matches(withText("36")));

        onView(allOf(withId(R.id.item_name),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                1),
                        1),
                isDisplayed()))
                .check(matches(withText("s0")));

        onView(allOf(withId(R.id.item_gender),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                1),
                        2),
                isDisplayed()))
                .check(matches(withText("\u2642")));

        onView(allOf(withId(R.id.item_age),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                1),
                        3),
                isDisplayed()))
                .check(matches(withText("44")));

        onView(allOf(withId(R.id.item_name),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                2),
                        1),
                isDisplayed()))
                .check(matches(withText("s1")));

        onView(allOf(withId(R.id.item_gender),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                2),
                        2),
                isDisplayed()))
                .check(matches(withText("\u2642")));

        onView(allOf(withId(R.id.item_age),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                2),
                        3),
                isDisplayed()))
                .check(matches(withText("87")));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        onView(allOf(withId(R.id.title), withText("Sort by ID"), isDisplayed()))
                .perform(click());


        onView(allOf(withId(R.id.item_name),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                0),
                        1),
                isDisplayed()))
                .check(matches(withText("s1")));

        onView(allOf(withId(R.id.item_gender),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                0),
                        2),
                isDisplayed()))
                .check(matches(withText("\u2642")));

        onView(allOf(withId(R.id.item_age),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                0),
                        3),
                isDisplayed()))
                .check(matches(withText("87")));

        onView(allOf(withId(R.id.item_name),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                1),
                        1),
                isDisplayed()))
                .check(matches(withText("s2")));

        onView(allOf(withId(R.id.item_gender),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                1),
                        2),
                isDisplayed()))
                .check(matches(withText("\u2640")));

        onView(allOf(withId(R.id.item_age),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                1),
                        3),
                isDisplayed()))
                .check(matches(withText("36")));

        onView(allOf(withId(R.id.item_name),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                2),
                        1),
                isDisplayed()))
                .check(matches(withText("s0")));

        onView(allOf(withId(R.id.item_gender),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                2),
                        2),
                isDisplayed()))
                .check(matches(withText("\u2642")));

        onView(allOf(withId(R.id.item_age),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.recycler_view_member),
                                2),
                        3),
                isDisplayed()))
                .check(matches(withText("44")));

        onView(withId(R.id.recycler_view_member))
                .perform(swipeRight())
                .perform(swipeRight())
                .perform(swipeRight());

        onView(withId(R.id.recycler_view_member)).check(new RecyclerViewItemCountAssertion(0));
    }

    public class RecyclerViewItemCountAssertion implements ViewAssertion {
        private final int expectedCount;

        RecyclerViewItemCountAssertion(int expectedCount) {
            this.expectedCount = expectedCount;
        }

        @Override
        public void check(View view, NoMatchingViewException noViewFoundException) {
            if (noViewFoundException != null) {
                throw noViewFoundException;
            }
            RecyclerView recyclerView = (RecyclerView) view;
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            assertThat(adapter.getItemCount(), is(expectedCount));
        }
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
