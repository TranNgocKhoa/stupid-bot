package com.khoa.bot.client;

import com.khoa.bot.configuation.MessengerProperties;

public class AbstractApiClient {
    private final MessengerProperties messengerProperties;

    public AbstractApiClient(MessengerProperties messengerProperties) {
        this.messengerProperties = messengerProperties;
    }


}
