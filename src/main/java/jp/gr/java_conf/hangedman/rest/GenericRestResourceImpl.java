package jp.gr.java_conf.hangedman.rest;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jp.gr.java_conf.hangedman.dao.GenericDao;
import jp.gr.java_conf.hangedman.util.SpringApplicationContext;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("hiding")
@Log
public class GenericRestResourceImpl<T, PK extends Serializable, D extends GenericDao<T,PK>> implements GenericRestResource <T, PK, D> {

	private Class<T> modelType;
	private String modelClassString;
	
	public GenericRestResourceImpl(Class<T> mType) {
		this.modelType = mType;
		this.modelClassString = this.modelType.getClass().getSimpleName();
	}
	
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<T> index(T paramBean) {
		D dao = (D) SpringApplicationContext.getBean("hoge");
		List<T> result = dao.read();
		return result;
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public T show(PK id) {
		D dao = (D) SpringApplicationContext.getBean("hoge");
		T result = dao.read(id);
		return result;		
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public PK create(T obj) {
		D dao = (D) SpringApplicationContext.getBean("departmentsDao");
		return dao.create(obj);		
	}

	@Override
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(T obj, PK id) {
		D dao = (D) SpringApplicationContext.getBean("departmentsDao");
		dao.update(obj);
	}

	@Override
	@DELETE
	public void destroy(PK id) throws Exception {
		D dao = (D) SpringApplicationContext.getBean("departmentsDao");
		dao.delete(id);
	}

}
