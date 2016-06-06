package com.pluralsight.repository;

import com.pluralsight.model.Activity;

import javax.ws.rs.core.Response;
import java.util.List;

public interface ActivityRepository {
    List<Activity> findAllActivities();

    Activity findActivity(String activityId);

    void create(Activity activity);

    Activity update(Activity activity);

    void delete(String activityId);

    List<Activity> findByDescriptions(List<String> descriptions);

    List<Activity> findByDurationRange(int durationFrom, int durationTo);
}
