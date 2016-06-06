package com.pluralsight;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status;

@Path("activities") //http://localhost:8080/webapi/activities
public class ActivityResource {

    private ActivityRepository activityRepository = new ActivityRepositoryStub();

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Activity createActivity(Activity activity) {

        activityRepository.create(activity);
        return activity;
    }

    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Activity createActivity(MultivaluedMap<String, String> params) {

        Activity activity = new Activity();
        activity.setDescription(params.getFirst("description"));
        activity.setDuration(Integer.parseInt(params.getFirst("duration")));

        activityRepository.create(activity);
        return activity;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Activity> getAllActivities() {
        return activityRepository.findAllActivities();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}") //http://localhost:8080/webapi/activities/1234
    public Response getActivity(@PathParam("activityId") String activityId) {
        if (activityId == null || activityId.length() < 4) {
            return Response.status(Status.BAD_REQUEST).build();
        }
        Activity activity = activityRepository.findActivity(activityId);
        if (activity == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(activity).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{activityId}/user") //http://localhost:8080/webapi/activities/125/user
    public User getActivityUser(@PathParam("activityId") String activityId) {
        return activityRepository.findActivity(activityId).getUser();
    }

    @PUT
    @Path("{activityId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateActivity(@PathParam("activityId") String activityId, Activity activity) {
        return Response.ok(activityRepository.update(activity)).build();
    }

    @DELETE
    @Path("{activityId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("activityId") String activityId) {
        activityRepository.delete(activityId);
        return Response.ok().build();
    }
}
