package com.mr5.eurekacustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class EurekacustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekacustomerApplication.class, args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/haha", method = RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForEntity("http://EUREKACLIENT/hello",String.class).getBody();
    }
}
