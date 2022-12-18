package com.fed.commerce.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

@Slf4j
public class ApiClientRequestInterceptor implements ClientHttpRequestInterceptor {
    /**
     * @param request   the request, containing method, URI, and headers
     * @param body      the body of the request
     * @param execution the request execution
     * @return
     * @throws IOException
     */
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        return null;
    }
/*
    protected void setAdditionalHeaders(HttpRequest request) {
        // Intentionally left blank. Inheriting classes may implement this method if required.
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
        throws IOException {
        request.getHeaders().setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        setAdditionalHeaders(request);
        log.info("Request URL - " + request.getURI().getRawPath());
        return execution.execute(request, body);
    }*/
}
