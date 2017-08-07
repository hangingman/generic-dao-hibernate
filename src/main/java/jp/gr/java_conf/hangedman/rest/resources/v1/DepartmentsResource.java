package jp.gr.java_conf.hangedman.rest.resources.v1;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.gr.java_conf.hangedman.dao.DepartmentsDao;
import jp.gr.java_conf.hangedman.models.Departments;
import jp.gr.java_conf.hangedman.util.SpringApplicationContext;

@Path("/department")
public class DepartmentsResource {

	static Logger log = LoggerFactory.getLogger(DepartmentsResource.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Departments> index(@BeanParam Departments paramBean) {
		DepartmentsDao dao = (DepartmentsDao) SpringApplicationContext.getBean("departmentsDao");
		List<Departments> result = dao.read();
		System.out.println("Get all Departments: size = " + result.size());
		return result;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Departments show(@PathParam("id") Integer id) {
		DepartmentsDao dao = (DepartmentsDao) SpringApplicationContext.getBean("departmentsDao");
		System.out.println("Get Departments -> id = " + id);
		return dao.read(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Integer create(Departments obj) {
		DepartmentsDao dao = (DepartmentsDao) SpringApplicationContext.getBean("departmentsDao");
		return dao.create(obj);
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Departments obj, @PathParam("id") String id) {
		DepartmentsDao dao = (DepartmentsDao) SpringApplicationContext.getBean("departmentsDao");
		dao.update(obj);
	}

	@DELETE
	@Path("{id}")
	public void destroy(@PathParam("id") Integer id) throws Exception {
		DepartmentsDao dao = (DepartmentsDao) SpringApplicationContext.getBean("departmentsDao");
		dao.delete(id);
	}
}
