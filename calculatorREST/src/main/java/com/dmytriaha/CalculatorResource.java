package com.dmytriaha;

import com.dmytriaha.model.Calculation;
import com.dmytriaha.repository.Calculator;
import com.dmytriaha.repository.CalculatorStub;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("calculator")
public class CalculatorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("add/{a}/{b}/{c}")
    public Calculation add(@PathParam("a") Integer a,
                           @PathParam("b") Integer b,
                           @PathParam("c") Integer c) {
        Calculator calculator = new CalculatorStub();
        return calculator.add(a, b, c);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("add/{a}/{b}")
    public Calculation add(@PathParam("a") Integer a,
                           @PathParam("b") Integer b) {
        Calculator calculator = new CalculatorStub();
        return calculator.add(a, b);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("subtract/{a}/{b}/{c}")
    public Calculation subtract(@PathParam("a") Integer a,
                                @PathParam("b") Integer b,
                                @PathParam("c") Integer c) {
        Calculator calculator = new CalculatorStub();
        return calculator.subtract(a, b, c);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("subtract/{a}/{b}")
    public Calculation subtract(@PathParam("a") Integer a,
                                @PathParam("b") Integer b) {
        Calculator calculator = new CalculatorStub();
        return calculator.subtract(a, b);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("multiply/{a}/{b}/{c}")
    public Calculation multiply(@PathParam("a") Integer a,
                                @PathParam("b") Integer b,
                                @PathParam("c") Integer c) {
        Calculator calculator = new CalculatorStub();
        return calculator.multiply(a, b, c);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("multiply/{a}/{b}")
    public Calculation multiply(@PathParam("a") Integer a,
                                @PathParam("b") Integer b) {
        Calculator calculator = new CalculatorStub();
        return calculator.multiply(a, b);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("divide/{a}/{b}/{c}")
    public Calculation divide(@PathParam("a") Integer a,
                              @PathParam("b") Integer b,
                              @PathParam("c") Integer c) {
        Calculator calculator = new CalculatorStub();
        return calculator.divide(a, b, c);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("divide/{a}/{b}")
    public Calculation divide(@PathParam("a") Integer a,
                              @PathParam("b") Integer b) {
        Calculator calculator = new CalculatorStub();
        return calculator.divide(a, b);
    }


}
