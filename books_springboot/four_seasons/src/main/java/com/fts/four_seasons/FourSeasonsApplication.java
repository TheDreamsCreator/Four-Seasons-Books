package com.fts.four_seasons;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fts.four_seasons.mapper")
public class FourSeasonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FourSeasonsApplication.class, args);
	}

}
