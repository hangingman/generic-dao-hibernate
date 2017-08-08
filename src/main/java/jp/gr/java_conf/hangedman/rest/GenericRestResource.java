package jp.gr.java_conf.hangedman.rest;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.PathParam;

import org.slf4j.Logger;

/**
 * @author Hiroyuki.Nagata
 * @param <T>  A model class to inject
 * @param <PK> Primary Key for model classes (Integer/Long/String...)
 * @param <GenericDao> Dao class for <T> 
 * 
 * To reduce boilerplate code with using the same method of GenericDao
 */
public interface GenericRestResource<T, PK extends Serializable, GenericDao> {

	static Logger log = null;
	
	public List<T> index(@BeanParam T paramBean);
	public T show(@PathParam("id") PK id);
	public PK create(T obj);
	public void update(T obj, @PathParam("id") PK id);
	public void destroy(@PathParam("id") PK id) throws Exception;
}
