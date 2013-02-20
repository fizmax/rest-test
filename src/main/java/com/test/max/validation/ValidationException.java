package com.test.max.validation;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ValidationException extends WebApplicationException {

    public ValidationException(String message) {
        super(Response
                .status(400)
                .entity(
                        com.test.max.factor.Response.getErrorInstance(message)
                )
                .type(MediaType.APPLICATION_XML)
                .build());
    }
}
