package com.coolnimesh43.discovery;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import ch.qos.logback.core.util.EnvUtil;

/**
 * Runner class for Euraka Discovery Server.
 * 
 * @author coolnimesh43
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class Application {

    public static void main(String[] args) throws UnknownHostException {
        System.out.println(EnvUtil.isWindows());
        Properties systemProperties = new Properties();
        systemProperties.setProperty("spring.config.name", "registration-server");
        System.setProperty("spring.config.name", "registration-server");
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
        Environment env = configurableApplicationContext.getEnvironment();
        System.out.println("Starting Discovery Server at \n \n");
        System.out.println("Localhost http://localhost:" + env.getProperty("server.port"));
        System.out.println("External http://" + InetAddress.getLocalHost().getHostAddress() + ":" + env.getProperty("server.port"));
    }
}
