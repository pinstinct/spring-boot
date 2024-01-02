package com.example.demo1;

import com.example.demo1.pojo.Droid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	/*컴퍼넌트를 스프링빈으로 인스턴스화
	* @Configuration 어노테이션이 달린 클래스 내에서 직접 또는 메타 어노테이션을 통해
	* (여러 메타 어노테이션 중에서 @Configuration을 포함하는 메타 어노테이션이 바로 @SpringBootApplication
	* 때문에 주로 빈 생성 메서드를 메인 클래스에 작성)
	* @Bean 어노테이션이 달린 메소드를 생성하는 방법이 가장 적합
	* */
	@Bean
	@ConfigurationProperties(prefix = "droid")
	Droid createDroid() {
		return new Droid();
	}
}
