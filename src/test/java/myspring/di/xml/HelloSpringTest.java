package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:hello-di.xml")
public class HelloSpringTest {

	@Autowired
	Hello hello;
	
	@Autowired
	@Qualifier("strPrinter")
	Printer strPrinter;
	
	@Resource(name = "hello")
	Hello helloBean;
	
	@Test
	void helloSpringBean() {
		assertEquals("Hello  스프링", hello.sayHello());
		hello.print();
		
		assertEquals("Hello  스프링", strPrinter.toString());

	}
}
