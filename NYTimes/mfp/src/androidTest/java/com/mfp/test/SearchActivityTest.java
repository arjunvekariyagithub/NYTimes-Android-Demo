package com.mfp.test;

import android.support.test.filters.SmallTest;
import android.support.v7.widget.RecyclerView;
import android.test.ActivityInstrumentationTestCase2;


import com.mfp.test.ui.search.SearchActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class SearchActivityTest extends ActivityInstrumentationTestCase2<SearchActivity> {

    SearchActivity activity;

    public SearchActivityTest() {
        super(SearchActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    @SmallTest
    public void testRecyclerViewNotNull() {
        RecyclerView recyclerView = (RecyclerView) activity.findViewById(R.id.recycler_view);
        assertNotNull(recyclerView);
    }

    /*
        test RecyclerView item count
     */
    @SmallTest
    public void testRecyclerViewItemsCount() {
        RecyclerView recyclerView = (RecyclerView) activity.findViewById(R.id.recycler_view);
        assertEquals(150, recyclerView.getAdapter().getItemCount());
    }

    /*
        test RecyclerView item content
     */
    @SmallTest
    public void testRecyclerViewContent() {
        onView(withText("football")).check(matches(isDisplayed()));
    }
}
