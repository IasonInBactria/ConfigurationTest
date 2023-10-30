package com.example.configurationtest;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(ServerConfig.class)
public class ConfigurationTestApplication {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource druidDataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        return ds;
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(ConfigurationTestApplication.class, args);
        ServerConfig serverConfig = configurableApplicationContext.getBean(ServerConfig.class);
        System.out.println(serverConfig);
        DruidDataSource ds1 = configurableApplicationContext.getBean(DruidDataSource.class);
        System.out.println(ds1.getDriverClassName());
    }

}
