package com.mr.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * Created by mr on 2017/8/18.
 */
@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "myFallback")
    public String getInfo(){
        return restTemplate.getForEntity("http://SERVICECLIENT/service1",String.class).getBody();
    }

    @HystrixCommand
    public Future<String> getInfoAsync(){
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForEntity("http://SERVICECLIENT/service1",String.class).getBody();
            }
        };
    }

    private String myFallback(){
        return "sorry,the service is not enable";
    }
}
