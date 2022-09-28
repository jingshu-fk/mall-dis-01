package com.mall.dis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shujingping
 */
@SpringBootApplication
@MapperScan("com.mall.dis.mapper")
public class MallDis01Application {

    public static void main(String[] args) {
//        SpringApplication.run(MallDis01Application.class, args);
        SpringApplication springApplication = new SpringApplication(MallDis01Application.class);
        springApplication.setAllowCircularReferences(Boolean.TRUE);
        springApplication.run(args);
    }

}
