package com.example.configurationtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.annotation.Validated;

@SpringBootTest
class ConfigurationTestApplicationTests {

    @Value("${datasource.password}")
    private String password;


    @Test
    void contextLoads() {
        System.out.println(password);
    }

}
