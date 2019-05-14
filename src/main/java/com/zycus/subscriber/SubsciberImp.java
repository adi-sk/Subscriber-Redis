package com.zycus.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPubSub;

public class SubsciberImp extends JedisPubSub {

    private static final Logger logger = LoggerFactory.getLogger(SubsciberImp.class);
    @Override
    public void onMessage(String channel, String message) {
        logger.info("Event Received on channel : "+ channel + " || message : "+message);
    }
}
