package jp.gr.java_conf.hangedman.dao;

import java.util.List;

import jp.gr.java_conf.hangedman.models.Employees;

public interface EmployeesDao extends GenericDao<Employees, Integer> {
	List<Employees> find();
}
