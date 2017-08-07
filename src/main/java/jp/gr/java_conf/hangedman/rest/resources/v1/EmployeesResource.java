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

import jp.gr.java_conf.hangedman.dao.EmployeesDao;
import jp.gr.java_conf.hangedman.models.Employees;
import jp.gr.java_conf.hangedman.util.SpringApplicationContext;

@Path("/employee")
public class EmployeesResource {

	static Logger log = LoggerFactory.getLogger(EmployeesResource.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employees> index(@BeanParam Employees paramBean) {
		EmployeesDao dao = (EmployeesDao) SpringApplicationContext.getBean("employeesDao");
		List<Employees> result = dao.read();
		System.out.println("Get all employees: size = " + result.size());
		return result;
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employees show(@PathParam("id") Integer id) {
		EmployeesDao dao = (EmployeesDao) SpringApplicationContext.getBean("employeesDao");
		System.out.println("Get employees -> id = " + id);
		return dao.read(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Integer create(Employees obj) {
		EmployeesDao dao = (EmployeesDao) SpringApplicationContext.getBean("employeesDao");
		return dao.create(obj);
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Employees obj, @PathParam("id") String id) {
		EmployeesDao dao = (EmployeesDao) SpringApplicationContext.getBean("employeesDao");
		dao.update(obj);
	}

	@DELETE
	@Path("{id}")
	public void destroy(@PathParam("id") Integer id) throws Exception {
		EmployeesDao dao = (EmployeesDao) SpringApplicationContext.getBean("EmployeesDao");
		dao.delete(id);
	}
}
