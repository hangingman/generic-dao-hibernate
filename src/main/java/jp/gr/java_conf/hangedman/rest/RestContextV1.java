package jp.gr.java_conf.hangedman.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestContextV1 extends ResourceConfig {

	// @see http://stackoverflow.com/a/17324460/2565527
	//@Context
	//ServletContext context;
	//private String log4jLocation = "WEB-INF/log4j.properties";

	public RestContextV1() {
		// log4j settings =>
		// http://www.avajava.com/tutorials/lessons/how-do-i-initialize-log4j-in-a-web-application.html
		//System.out.println(this.getClass().toString() + " is initializing log4j");

		/**
		if (context == null) {
			System.err.println("*** Initializing log4j with BasicConfigurator");
			// BasicConfigurator.configure();
		} else {
			String webAppPath = context.getRealPath("/");
			String log4jProp = webAppPath + log4jLocation;
			// what's yoMama ?
			File yoMamaYesThisSaysYoMama = new File(log4jProp);
			if (yoMamaYesThisSaysYoMama.exists()) {
				System.out.println("Initializing log4j with: " + log4jProp);
				// PropertyConfigurator.configure(log4jProp);
			} else {
				System.err
						.println("*** " + log4jProp + " file not found, so initializing log4j with BasicConfigurator");
				// BasicConfigurator.configure();
			}
		}
		*/

		// Add CORS headers
		register(jp.gr.java_conf.hangedman.rest.CORSFilter.class);
		// You need to register some resource classes here
		//packages("jp.gr.java_conf.hangedman.rest.resources.ts");

		System.out.println("*** END ***");
	}
}
