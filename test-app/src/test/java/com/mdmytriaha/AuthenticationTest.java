package com.mdmytriaha;

import com.mdmytriaha.controllet.HomeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebIntegrationTest
public class AuthenticationTest {

    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new TestRestTemplate();
    }

    @Test
    public void testHello() {
        HomeController hc = new HomeController();
        String result = hc.home();
        assertEquals(result, "Hello to test application");
    }

    @Test
    public void testAuthorized() throws URISyntaxException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("token", "user");

        ResponseEntity result = restTemplate.exchange(
                new RequestEntity(httpHeaders, HttpMethod.GET, new URI("http://localhost:8080/api")),
                String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Hello, user!", result.getBody());
    }

    @Test
    public void testUnauthorizedWithoutHeader() {
        ResponseEntity<String> result = restTemplate.getForEntity("http://localhost:8080/api", String.class);
        assertEquals(HttpStatus.FORBIDDEN, result.getStatusCode());
    }

    @Test
    public void testUnauthorizedWithWrongHeaderValue() throws URISyntaxException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("token", "otheruser");

        ResponseEntity result = restTemplate.exchange(
                new RequestEntity(httpHeaders, HttpMethod.GET, new URI("http://localhost:8080/api")),
                String.class);
        assertEquals(HttpStatus.FORBIDDEN, result.getStatusCode());
    }
}
