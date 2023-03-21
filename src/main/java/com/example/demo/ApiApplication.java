package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class ApiApplication {
    public static void main(String[] args){
        //스프링 빈 컨테이너
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringTourApplication.class,args);

        //application.properties 에 저장된 key-value 값을 확인하기 위해 Env객체를 가져온다.
        Environment env = ctx.getBean(Environment.class);
        String portValue = env.getProperty("server.port");
        log.info("Customized Port: {}" , portValue);

        String[] beanName = ctx.getBeanDefinitionNames();

        //ApplicationContext객체가 관리하고 있는 스프링 빈들의 이름을 가져와 출력한다.
        Arrays.stream(beanName).forEach(name -> log.info("Bean Name: {}",name));
    }
}
