package com.khoa.bot.interceptor;

import com.khoa.bot.configuation.MessengerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

@Component
public class MessengerClientInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessengerClientInterceptor.class);

    private final MessengerProperties messengerProperties;

    public MessengerClientInterceptor(MessengerProperties messengerProperties) {
        this.messengerProperties = messengerProperties;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        this.logRequestDetails(httpRequest);
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }

    private void logRequestDetails(HttpRequest request) {
        LOGGER.info("Headers: {}", request.getHeaders());
        LOGGER.info("Request Method: {}", request.getMethod());
        LOGGER.info("Request URI: {}", request.getURI());

        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            try {
                LOGGER.info("Request URI: {}", httpServletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator())));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
