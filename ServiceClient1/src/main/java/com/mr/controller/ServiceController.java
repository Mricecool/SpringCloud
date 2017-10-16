package com.mr.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mr on 2017/8/17.
 */
@RestController
public class ServiceController {

    private final Logger logger=Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/service1",method = RequestMethod.GET)
    public String index(){
        ServiceInstance serviceInstance=discoveryClient.getLocalServiceInstance();
        logger.info("/service1 host:"+serviceInstance.getHost()+",service ID:"+serviceInstance.getServiceId());
        return "This is Service1";
    }

}
