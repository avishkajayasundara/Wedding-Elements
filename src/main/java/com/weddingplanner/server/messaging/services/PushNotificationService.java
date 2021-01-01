package com.weddingplanner.server.messaging.services;

import com.weddingplanner.server.messaging.model.PushNotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PushNotificationService {
    private Logger logger = LoggerFactory.getLogger(PushNotificationService.class);
    private FCMService fcmService;
    public PushNotificationService(FCMService fcmService) {
        this.fcmService = fcmService;
    }
    public void sendPushNotification(PushNotificationRequest request) {
        Map<String, String> appData= new HashMap<>();
        appData.put("name", "PushNotification");
        try {
            fcmService.sendMessage(appData, request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
