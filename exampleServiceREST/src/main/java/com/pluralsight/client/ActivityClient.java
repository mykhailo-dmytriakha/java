package com.pluralsight.client;

import com.pluralsight.model.Activity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status;

public class ActivityClient {
    private final String HTTP_LOCALHOST_8080_WEBAPI = "http://localhost:8080/webapi/";
    private Client client;

    public ActivityClient() {
        client = ClientBuilder.newClient();
    }

    public Activity get(String id) {
        WebTarget target = client.target(HTTP_LOCALHOST_8080_WEBAPI);
        Response response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Response.class);
        if (response.getStatus() != Status.OK.getStatusCode()) {
            throw new RuntimeException(response.getStatus() + " " + response.getStatusInfo() + ": there was an error on the server");
        }
        return response.readEntity(Activity.class);
    }

    public List<Activity> get() {
        WebTarget target = client.target(HTTP_LOCALHOST_8080_WEBAPI);
        List<Activity> response = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {
        });
        return response;
    }

    public Activity create(Activity activity) {
        WebTarget target = client.target(HTTP_LOCALHOST_8080_WEBAPI);
        Response response = target.path("activities/activity").request(MediaType.APPLICATION_JSON).
                post(Entity.entity(activity, MediaType.APPLICATION_JSON));
        if (response.getStatus() != Status.OK.getStatusCode()) {
            throw new RuntimeException(response.getStatus() + " " + response.getStatusInfo() + ": there was an error on the server");
        }
        return response.readEntity(Activity.class);
    }

    public Activity update(Activity activity) {
        WebTarget target = client.target(HTTP_LOCALHOST_8080_WEBAPI);
        Response response = target.path("activities/" + activity.getId()).request(MediaType.APPLICATION_JSON).
                put(Entity.entity(activity, MediaType.APPLICATION_JSON));
        if (response.getStatus() != Status.OK.getStatusCode()) {
            throw new RuntimeException(response.getStatus() + " " + response.getStatusInfo() + ": there was an error on the server");
        }
        return response.readEntity(Activity.class);
    }

    public void delete(String id) {
        WebTarget target = client.target(HTTP_LOCALHOST_8080_WEBAPI);
        Response response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).
                delete();
        if (response.getStatus() != Status.OK.getStatusCode()) {
            throw new RuntimeException(response.getStatus() + " " + response.getStatusInfo() + ": there was an error on the server");
        }
    }
}
