package com.pluralsight.client;

import com.pluralsight.model.Activity;
import com.pluralsight.model.ActivitySearch;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

public class ActivitySearchClient {
    private final String HTTP_LOCALHOST_8080_WEBAPI = "http://localhost:8080/webapi/";
    private Client client;

    public ActivitySearchClient() {
        client = ClientBuilder.newClient();
    }

    public List<Activity> search(String param, List<String> searchValues) {

        URI uri = UriBuilder.fromPath(HTTP_LOCALHOST_8080_WEBAPI)
                .path("search/activities")
                .queryParam(param, searchValues)
                .build();

        WebTarget target = client.target(uri);
        List<Activity> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {
        });

        return response;
    }

    public List<Activity> searchRange(String firstParam, int durationFrom, String secondParam, int durationTo) {
        URI uri = UriBuilder.fromPath(HTTP_LOCALHOST_8080_WEBAPI)
                .path("search/activities")
                .path("range")
                .queryParam(firstParam, durationFrom)
                .queryParam(secondParam, durationTo)
                .build();
        WebTarget target = client.target(uri);
        List<Activity> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {
        });
        return response;
    }

    public List<Activity> search(ActivitySearch search) {
        URI uri = UriBuilder.fromPath(HTTP_LOCALHOST_8080_WEBAPI)
                .path("search/activities")
                .build();

        WebTarget target = client.target(uri);
        Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(search, MediaType.APPLICATION_JSON));
        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new RuntimeException(response.getStatus() + " " + response.getStatusInfo() + ": there was an error on the server");
        }

        return response.readEntity(new GenericType<List<Activity>>() {
        });
    }
}
