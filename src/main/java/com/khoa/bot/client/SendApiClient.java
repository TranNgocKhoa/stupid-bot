package com.khoa.bot.client;

import com.khoa.bot.configuation.MessengerProperties;
import com.khoa.bot.model.MessageRequest;
import com.khoa.bot.model.response.SendApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class SendApiClient {
    private final static Logger LOGGER = LoggerFactory.getLogger(SendApiClient.class);
    private final RestTemplate restTemplate;
    private final MessengerProperties messengerProperties;

    public SendApiClient(RestTemplate restTemplate, MessengerProperties messengerProperties) {
        this.restTemplate = restTemplate;
        this.messengerProperties = messengerProperties;
    }

    public SendApiResponse sendApi(MessageRequest messageRequest) {
        String url = messengerProperties.getBaseUrl() + "/messages?access_token=" + messengerProperties.getAppAccessToken();
        ResponseEntity<SendApiResponse> entity = restTemplate.postForEntity(url, messageRequest, SendApiResponse.class);

        LOGGER.info(Objects.requireNonNull(entity.getBody()).toString());

        return entity.getBody();
    }
}
