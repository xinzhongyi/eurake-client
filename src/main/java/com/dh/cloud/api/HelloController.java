package com.dh.cloud.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by dh on 2018/10/31.
 */
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger("HelloController") ;

    @Autowired
    private DiscoveryClient client ;

    @RequestMapping(value="hello",method= RequestMethod.GET)
    public String hello() throws InterruptedException {
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:" + sleepTime);
        Thread.sleep(sleepTime);
        return "Hello World" ;
    }
}
