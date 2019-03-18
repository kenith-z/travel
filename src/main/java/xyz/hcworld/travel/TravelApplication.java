package xyz.hcworld.travel;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


/**
 * @author: 张红尘
 * @date: 2018/4/17 10:08
 * @Description:毕业设计启动类
 */
@SpringBootApplication
public class TravelApplication {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();}
    /**
     * 主方法
     *
     * @param args 入口
     */
    public static void main(String[] args) {
        SpringApplication.run(TravelApplication.class, args);
    }
}
