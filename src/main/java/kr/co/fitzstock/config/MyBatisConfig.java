package kr.co.fitzstock.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("kr.co.fitzstock.mapper")
public class MyBatisConfig {
}