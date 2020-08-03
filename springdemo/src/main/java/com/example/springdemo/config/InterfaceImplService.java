package com.example.springdemo.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

//@Service
public class InterfaceImplService implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.printf("%s: do destruction work by implementing DisposableBean\n", this.getClass());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.printf("%s: do initialization work by implementing InitializingBean", this.getClass());
    }
}
