package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"myspring.di.annot"})
@PropertySource("classpath:values.properties")
public class HelloBeanConfig {

	public HelloBeanConfig() {
		System.out.println(this.getClass().getName() + " Congif 클래스 기본 생성자 호출됨!");
	}
}
