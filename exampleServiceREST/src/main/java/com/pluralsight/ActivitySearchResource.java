package com.pluralsight;

import com.pluralsight.model.Activity;
import com.pluralsight.model.ActivitySearch;
import com.pluralsight.repository.ActivityRepositoryStub;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("search/activities")
public class ActivitySearchResource {
    private ActivityRepositoryStub activityRepository = new ActivityRepositoryStub();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response searchForActivities(@QueryParam(value = "description") List<String> descriptions) {

        List<Activity> activities = activityRepository.findByDescriptions(descriptions);

        if (activities == null || activities.size() <= 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {
        }).build();
    }

    @GET
    @Path("range")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response searchRange(@QueryParam("durationFrom") int durationFrom, @QueryParam("durationTo") int durationTo) {
        List<Activity> activities = activityRepository.findByDurationRange(durationFrom, durationTo);

        if (activities == null || activities.size() <= 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {
        }).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response searchForActivities(ActivitySearch search) {
        List<Activity> activities = activityRepository.findByDurationRange(search.getDurationFrom(), search.getDurationTo());

        if (activities == null || activities.size() <= 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {
        }).build();
    }
}
