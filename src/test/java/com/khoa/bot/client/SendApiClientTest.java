package com.khoa.bot.client;

import com.khoa.bot.enums.MessagingType;
import com.khoa.bot.model.MessageRequest;
import com.khoa.bot.model.Recipient;
import com.khoa.bot.model.TextMessage;
import com.khoa.bot.model.response.SendApiResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("local")
class SendApiClientTest {

    @Autowired
    private SendApiClient sendApiClient;


    @Test
    void sendApi() {
        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setMessagingType(MessagingType.RESPONSE);
        messageRequest.setRecipient(Recipient.of("3218387314851103"));
        messageRequest.setMessage(new TextMessage("Do you need help? Test from Application test"));

        SendApiResponse response = sendApiClient.sendApi(messageRequest);

        assertThat(response.getRecipientId().equals("106917847720264"));
    }
}