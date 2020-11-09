package com.keqi.apihu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.keqi.**.mapper")
@EnableTransactionManagement
public class ApiHuApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiHuApplication.class, args);
    }

}
