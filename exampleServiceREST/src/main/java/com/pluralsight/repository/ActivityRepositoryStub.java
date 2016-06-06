package com.pluralsight.repository;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

import java.util.ArrayList;
import java.util.List;

public class ActivityRepositoryStub implements ActivityRepository {

    @Override
    public List<Activity> findAllActivities() {
        List<Activity> activities = new ArrayList<Activity>();

        Activity activity1 = new Activity();
        activity1.setDescription("Swimming");
        activity1.setDuration(55);

        activities.add(activity1);

        Activity activity2 = new Activity();
        activity2.setDescription("Cycling");
        activity2.setDuration(120);

        activities.add(activity2);

        return activities;
    }

    @Override
    public Activity findActivity(String activityId) {
        if (activityId.equals("7777")) {
            return null;
        }

        Activity activity = new Activity();
        activity.setId(activityId);
        activity.setDescription("Running");
        activity.setDuration(45);

        User user = new User();
        user.setId(activityId);
        user.setName("Bob");

        activity.setUser(user);
        return activity;
    }

    @Override
    public void create(Activity activity) {
        // TASK: add activity to repository
    }

    @Override
    public Activity update(Activity activity) {
        // TASK: update activity in repository
        return activity;
    }

    @Override
    public void delete(String activityId) {
        // TASK; delete an activity by activityId from repository
    }

    @Override
    public List<Activity> findByDescriptions(List<String> descriptions) {
        // TASK: find activities in repository

        List<Activity> activities = new ArrayList<Activity>();

        Activity activity = new Activity();
        activity.setId("1234");
        activity.setDescription("Swimming");
        activity.setDuration(44);

        activities.add(activity);
        return activities;
    }

    @Override
    public List<Activity> findByDurationRange(int durationFrom, int durationTo) {
        // TASK: find activities in repository

        List<Activity> activities = new ArrayList<Activity>();

        Activity activity1 = new Activity();
        activity1.setId("1234");
        activity1.setDescription("Swimming");
        activity1.setDuration(44);

        Activity activity2 = new Activity();
        activity2.setId("23456");
        activity2.setDescription("Running");
        activity2.setDuration(60);

        activities.add(activity1);
        activities.add(activity2);
        return activities;
    }
}
