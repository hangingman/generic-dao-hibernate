package jp.gr.java_conf.hangedman.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @see https://www.mkyong.com/webservices/jax-rs/resteasy-spring-integration-example/
 * @author Hiroyuki.Nagata
 * This class will provide Spring bean classes for Jersey's service classes
 */
public class SpringApplicationContext implements ApplicationContextAware {

	private static ApplicationContext appContext;

	// Private constructor prevents instantiation from other classes
	private SpringApplicationContext() {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appContext = applicationContext;
	}

	public static Object getBean(String beanName) {
		return appContext.getBean(beanName);
	}

	public static String[] getBeanDefinitionNames() {
		return appContext.getBeanDefinitionNames();
	}
}
