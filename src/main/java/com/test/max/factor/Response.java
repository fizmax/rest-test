package com.test.max.factor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {

    private String result;
    private String error;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static Response getOkInstance(Object obj) {
        Response response = new Response();
        response.setResult(obj.toString());

        return response;
    }

    public static Response getErrorInstance(Object obj) {
        Response response = new Response();
        response.setError(obj.toString());

        return response;
    }
}
