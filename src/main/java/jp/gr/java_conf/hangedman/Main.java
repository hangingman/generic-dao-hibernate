package jp.gr.java_conf.hangedman;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import jp.gr.java_conf.hangedman.rest.RestContextV1;

@SpringBootApplication(exclude = FlywayAutoConfiguration.class)
public class Main {

	@Bean
	public ServletRegistrationBean jerseyServlet() {
		// previously, we have wrtten web.xml to set this kind of configuration...
		// it looks #jerseyServlet() is called by another library process
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/v1/*");
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, RestContextV1.class.getName());
		return registration;
	}

	//
	// Spring-boot will start from here !
	//
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
