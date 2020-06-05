package com.khoa.bot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WebHook {
    private final Logger LOGGER = LoggerFactory.getLogger(WebHook.class);

    private final String verifyToken;
    private final ObjectMapper objectMapper;

    public WebHook(@Value("${verifyToken}") String verifyToken, ObjectMapper objectMapper) {
        this.verifyToken = verifyToken;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public String webHook(@RequestBody Object request) {
        try {
            LOGGER.info(objectMapper.writeValueAsString(request));

            return objectMapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public String webHook(@RequestParam("hub.mode") String mode,
                          @RequestParam("hub.verify_token") String verifyToken,
                          @RequestParam("hub.challenge") String challenge) {

        if (verifyToken.equals(this.verifyToken)) {
            LOGGER.info(verifyToken);
        }
        return challenge;
    }

}
