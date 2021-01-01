package com.weddingplanner.server.messaging.services;

import com.google.firebase.messaging.*;
import com.weddingplanner.server.messaging.model.NotificationParameter;
import com.weddingplanner.server.messaging.model.PushNotificationRequest;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class FCMService {
    Logger logger = LoggerFactory.getLogger(FCMService.class);
    public void sendMessage(Map<String, String> data, PushNotificationRequest request)
            throws InterruptedException, ExecutionException {
        Message message = getPreconfiguredMessageBuilder(request);
        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
        logger.info("Sent Notification. Title: " + request.getTitle() + ", " + response);
    }

    private String sendAndGetResponse(Message message) throws InterruptedException, ExecutionException {
        return FirebaseMessaging.getInstance().sendAsync(message).get();
    }

    private AndroidConfig getAndroidConfig() {
        return AndroidConfig.builder()
                .setTtl(Duration.ofMinutes(60).toMillis())
                .setPriority(AndroidConfig.Priority.HIGH)
                .setNotification(AndroidNotification.builder().setSound("default").setColor("#FFFF00").build())
                .build();
    }

    private ApnsConfig getApnsConfig() {
        return ApnsConfig.builder().setAps(Aps.builder().setSound("default").build()).build();
    }

//    private Message getPreconfiguredMessageWithData(Map<String, String> data, PushNotificationRequest request) {
//        return getPreconfiguredMessageBuilder(request).putAllData(data).setToken(request.getToken()).build();
//    }

    private Message getPreconfiguredMessageBuilder(PushNotificationRequest request) {
        AndroidConfig androidConfig = getAndroidConfig();
        ApnsConfig apnsConfig = getApnsConfig();
        return Message.builder()
                .setToken(request.getToken())
                .setNotification(new Notification(request.getTitle(),request.getMessage()))
                .build();
    }
}
