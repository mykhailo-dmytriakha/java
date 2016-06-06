package com.pluralsigth.client;

import com.pluralsight.client.ActivityClient;
import com.pluralsight.client.ActivitySearchClient;
import com.pluralsight.model.Activity;
import com.pluralsight.model.ActivitySearch;
import com.pluralsight.model.ActivitySearchType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ActivityClientTest {

    @Test
    public void testPut() {
        Activity activity = new Activity();
        activity.setId("3456");
        activity.setDescription("Yoga");
        activity.setDuration(90);

        ActivityClient client = new ActivityClient();
        assertNotNull(client.update(activity));
    }

    @Test
    public void testGet() throws Exception {
        ActivityClient client = new ActivityClient();
        Activity activity = client.get("1234");
        assertNotNull(activity);
    }

    @Test
    public void testGetList() throws Exception {
        ActivityClient client = new ActivityClient();
        List<Activity> activities = client.get();
        assertNotNull(activities);
    }

    @Test(expected = RuntimeException.class)
    public void testGetWithBadRequest() {
        ActivityClient client = new ActivityClient();
        client.get("123");
    }

    @Test(expected = RuntimeException.class)
    public void testGetWithNotFound() {
        ActivityClient client = new ActivityClient();
        client.get("7777");
    }

    @Test
    public void testCreate() {
        ActivityClient client = new ActivityClient();
        Activity activity = new Activity();
        activity.setDescription("Swimming");
        activity.setDuration(33);

        assertNotNull(client.create(activity));
    }

    @Test()
    public void testDelete() {
        ActivityClient client = new ActivityClient();
        client.delete("1234");
    }

    @Test
    public void search() {
        ActivitySearchClient client = new ActivitySearchClient();
        String param = "description";
        List<String> searchValues = new ArrayList<String>();
        searchValues.add("Swimming");
        searchValues.add("Running");

        assertNotNull(client.search(param, searchValues));
    }

    @Test
    public void searchRange() {
        ActivitySearchClient client = new ActivitySearchClient();

        String firstParam = "durationFrom";
        int durationFrom = 20;
        String secondParam = "durationTo";
        int durationTo = 95;
        assertNotNull(client.searchRange(firstParam, durationFrom, secondParam, durationTo));
    }

    @Test
    public void testSearchObject() {
        ActivitySearchClient client = new ActivitySearchClient();
        List<String> searchValues = new ArrayList<String>();
        searchValues.add("biking");
        searchValues.add("running");

        ActivitySearch search = new ActivitySearch();
        search.setDurationFrom(30);
        search.setDurationTo(90);
        search.setDescriptions(searchValues);
        search.setSearchType(ActivitySearchType.SEARCH_BY_DURATION_RANGE);

        assertNotNull(client.search(search));
    }
}