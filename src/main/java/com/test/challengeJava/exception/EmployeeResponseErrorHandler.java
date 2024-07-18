package com.test.challengeJava.exception;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class EmployeeResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError());
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if(response.getStatusCode().is5xxServerError()){
            throw new RuntimeException("Internal Server Error");
        }else if(response.getStatusCode().is4xxClientError()){
            throw new RuntimeException("Client Error |" + response.getStatusText());
        }
    }
}
