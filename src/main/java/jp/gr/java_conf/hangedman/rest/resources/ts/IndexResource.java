package jp.gr.java_conf.hangedman.rest.resources.ts;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/xxx")
public class IndexResource {

	// JSONで結果を返す設定
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/hello")
	public String hello() {
		return "Hello!!";
	}
}