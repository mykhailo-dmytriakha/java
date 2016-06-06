package com.dmytriaha.client;

import com.dmytriaha.model.Calculation;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static com.dmytriaha.model.OperationType.*;

public class CalculatorClient {
    private final String URL = "http://localhost:8080/calculator/";
    private Client client;

    public CalculatorClient() {
        client = ClientBuilder.newClient();
    }

    public Calculation add(Integer a, Integer b, Integer c) {
        return getCalculation(ADD.toString(), a, b, c);
    }

    public Calculation add(Integer a, Integer b) {
        return getCalculation(ADD.toString(), a, b);
    }

    public Calculation subtract(Integer a, Integer b, Integer c) {
        return getCalculation(SUBTRACT.toString(), a, b, c);
    }

    public Calculation subtract(Integer a, Integer b) {
        return getCalculation(SUBTRACT.toString(), a, b);
    }

    public Calculation multiply(Integer a, Integer b, Integer c) {
        return getCalculation(MULTIPLY.toString(), a, b, c);
    }

    public Calculation multiply(Integer a, Integer b) {
        return getCalculation(MULTIPLY.toString(), a, b);
    }

    public Calculation divide(Integer a, Integer b, Integer c) {
        return getCalculation(DIVIDE.toString(), a, b, c);
    }

    public Calculation divide(Integer a, Integer b) {
        return getCalculation(DIVIDE.toString(), a, b);
    }

    private Calculation getCalculation(String operation, Integer a, Integer b, Integer c) {
        return getWebTarget().path(operation + "/" + a + "/" + b + "/" + c)
                .request()
                .get(Calculation.class);
    }


    private Calculation getCalculation(String operation, Integer a, Integer b) {
        return getWebTarget().path(operation + "/" + a + "/" + b)
                .request()
                .get(Calculation.class);
    }

    private WebTarget getWebTarget() {
        return client.target(URL);
    }
}
