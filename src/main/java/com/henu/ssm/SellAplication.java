package com.henu.ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shkstart
 * @create 2019-09-26 13:37
 */
@SpringBootApplication
//扫描dao层接口
@MapperScan("com.henu.ssm.dao")
public class SellAplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SellAplication.class);
        //关闭banner
        /*application.setBannerMode(Banner.Mode.OFF);*/
        application.run(args);
    }
}

