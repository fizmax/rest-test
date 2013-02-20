package com.test.max.factor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

import static com.test.max.validation.Validator.isPositive;
import static com.test.max.validation.Validator.isValid;

@Component
@Path("/factor")
public class FactorResource {

    @Autowired
    CalculationService calculationService;

    @GET
    @Path("/{v1}")
    @Produces(MediaType.APPLICATION_XML)
    public Response get(@PathParam("v1") Integer v1) throws IOException {
        isPositive(v1);
        double factor = calculationService.getFactor(v1);

        return Response.getOkInstance(factor);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response post(Request request) throws IOException {
        isValid(request);
        int result = calculationService.calculateResult(request.getV2(), request.getV3(), request.getV4());

        return Response.getOkInstance(result);
    }
}
