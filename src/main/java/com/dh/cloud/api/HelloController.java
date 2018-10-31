package com.dh.cloud.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public String hello(){
        client.getServices().forEach(id -> {
            client.getInstances(id).forEach(instance -> {
                logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
            });
        });
        return "Hello World" ;
    }
}
