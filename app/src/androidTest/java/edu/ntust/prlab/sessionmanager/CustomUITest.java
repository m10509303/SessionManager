package edu.ntust.prlab.sessionmanager;


import android.content.res.Resources;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.GeneralSwipeAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Swipe;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CustomUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void addAndSortTest() {
        onView(allOf(withId(R.id.button_add), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.input_name), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.input_name), isDisplayed())).perform(replaceText("s1"), closeSoftKeyboard());

        onView(allOf(withId(R.id.input_age), isDisplayed())).perform(replaceText("87"), closeSoftKeyboard());

        onView(allOf(withId(android.R.id.button1), withText("OK"))).perform(scrollTo(), click());

        onView(allOf(withId(R.id.button_add), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.input_name), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.input_name), isDisplayed())).perform(replaceText("s2"), closeSoftKeyboard());

        onView(allOf(withId(R.id.input_age), isDisplayed())).perform(replaceText("36"), closeSoftKeyboard());

        onView(allOf(withId(R.id.radio_female), withParent(withId(R.id.radio_gender)), isDisplayed())).perform(click());

        onView(allOf(withId(android.R.id.button1), withText("OK"))).perform(scrollTo(), click());

        onView(allOf(withId(R.id.button_add), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.input_name), isDisplayed())).perform(click());

        onView(allOf(withId(R.id.input_name), isDisplayed())).perform(replaceText("s0"), closeSoftKeyboard());

        onView(allOf(withId(R.id.input_age), isDisplayed())).perform(replaceText("44"), closeSoftKeyboard());

        onView(allOf(withId(android.R.id.button1), withText("OK"))).perform(scrollTo(), click());

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        onView(allOf(withId(R.id.title), withText("Sort by Name"), isDisplayed())).perform(click());

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(0))
                .check(matches(hasDescendant(withText("s0"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(0))
                .check(matches(hasDescendant(withText("44"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(0))
                .check(matches(hasDescendant(withText("\u2642"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(1))
                .check(matches(hasDescendant(withText("s1"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(1))
                .check(matches(hasDescendant(withText("87"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(1))
                .check(matches(hasDescendant(withText("\u2642"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(2))
                .check(matches(hasDescendant(withText("s2"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(2))
                .check(matches(hasDescendant(withText("36"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(2))
                .check(matches(hasDescendant(withText("\u2640"))));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        onView(allOf(withId(R.id.title), withText("Sort by Gender"), isDisplayed()))
                .perform(click());

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(0))
                .check(matches(hasDescendant(withText("s2"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(0))
                .check(matches(hasDescendant(withText("36"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(0))
                .check(matches(hasDescendant(withText("\u2640"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(1))
                .check(matches(hasDescendant(withText("s1"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(1))
                .check(matches(hasDescendant(withText("87"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(1))
                .check(matches(hasDescendant(withText("\u2642"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(2))
                .check(matches(hasDescendant(withText("s0"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(2))
                .check(matches(hasDescendant(withText("44"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(2))
                .check(matches(hasDescendant(withText("\u2642"))));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        onView(allOf(withId(R.id.title), withText("Sort by Age"), isDisplayed())).perform(click());

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(0))
                .check(matches(hasDescendant(withText("s2"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(0))
                .check(matches(hasDescendant(withText("36"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(0))
                .check(matches(hasDescendant(withText("\u2640"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(1))
                .check(matches(hasDescendant(withText("s0"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(1))
                .check(matches(hasDescendant(withText("44"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(1))
                .check(matches(hasDescendant(withText("\u2642"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(2))
                .check(matches(hasDescendant(withText("s1"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(2))
                .check(matches(hasDescendant(withText("87"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(2))
                .check(matches(hasDescendant(withText("\u2642"))));

        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        onView(allOf(withId(R.id.title), withText("Sort by ID"), isDisplayed())).perform(click());

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(0))
                .check(matches(hasDescendant(withText("s1"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(0))
                .check(matches(hasDescendant(withText("87"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(0))
                .check(matches(hasDescendant(withText("\u2642"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(1))
                .check(matches(hasDescendant(withText("s2"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(1))
                .check(matches(hasDescendant(withText("36"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(1))
                .check(matches(hasDescendant(withText("\u2640"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(2))
                .check(matches(hasDescendant(withText("s0"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(2))
                .check(matches(hasDescendant(withText("44"))));

        onView(withRecyclerView(R.id.recycler_view_member).atPosition(2))
                .check(matches(hasDescendant(withText("\u2642"))));

        onView(withId(R.id.recycler_view_member))
                .perform(swipeEnd())
                .perform(swipeEnd())
                .perform(swipeEnd());

        onView(withId(R.id.recycler_view_member)).check(new RecyclerViewItemCountAssertion(0));
    }

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

    static class RecyclerViewMatcher {
        private final int recyclerViewId;

        RecyclerViewMatcher(int recyclerViewId) {
            this.recyclerViewId = recyclerViewId;
        }

        Matcher<View> atPosition(final int position) {
            return atPositionOnView(position, -1);
        }

        Matcher<View> atPositionOnView(final int position, final int targetViewId) {

            return new TypeSafeMatcher<View>() {
                Resources resources = null;
                View childView;

                public void describeTo(Description description) {
                    String idDescription = Integer.toString(recyclerViewId);
                    if (this.resources != null) {
                        try {
                            idDescription = this.resources.getResourceName(recyclerViewId);
                        } catch (Resources.NotFoundException var4) {
                            idDescription = String.format("%s (resource name not found)", recyclerViewId);
                        }
                    }

                    description.appendText("with id: " + idDescription);
                }

                public boolean matchesSafely(View view) {
                    this.resources = view.getResources();

                    if (childView == null) {
                        RecyclerView recyclerView =
                                (RecyclerView) view.getRootView().findViewById(recyclerViewId);
                        if (recyclerView != null && recyclerView.getId() == recyclerViewId) {
                            RecyclerView.ViewHolder viewHolder =
                                    recyclerView.findViewHolderForAdapterPosition(position);
                            if (viewHolder != null) {
                                childView = viewHolder.itemView;
                            }
                        } else {
                            return false;
                        }
                    }

                    if (targetViewId == -1) {
                        return view == childView;
                    } else {
                        View targetView = childView.findViewById(targetViewId);
                        return view == targetView;
                    }
                }
            };
        }
    }

    public static ViewAction swipeEnd() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.TOP_LEFT,
                GeneralLocation.BOTTOM_RIGHT, Press.FINGER);
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

}
