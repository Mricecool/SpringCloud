package com.mr;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by mr on 2017/8/17.
 */
@EnableEurekaServer
@SpringBootApplication
public class EureKaApplication {

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(EureKaApplication.class).web(true).run(args);
    }

}
