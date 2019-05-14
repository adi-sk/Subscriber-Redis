package com.zycus.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class SubscriberApplication {

	public static final Logger logger = LoggerFactory.getLogger(SubscriberApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SubscriberApplication.class, args);

		final String channelName= "demo";
		final Jedis jedis = new Jedis("localhost");
		final SubsciberImp subsciberImp = new SubsciberImp();
		new Thread(new Runnable() {
			@Override
			public void run() {

				while (true){

					try {
						logger.info("subscribe to channel : " + channelName);
						jedis.subscribe(subsciberImp,channelName);
						logger.info("Subscription Ended");
					}
					catch (Exception e){
						logger.error("Subsciption Failed :"+ e);
					}
				}

			}
		}).start();
	}

}
