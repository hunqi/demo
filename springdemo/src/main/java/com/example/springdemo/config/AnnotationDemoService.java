package com.example.springdemo.config;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AnnotationDemoService {

    @PostConstruct
    public void init(){
        System.out.printf("%s: do custom initialization work\n", this.getClass());
    }

    @PreDestroy
    public void destroy(){
        System.out.printf("%s: do customer destruction work\n", this.getClass());
    }

}
