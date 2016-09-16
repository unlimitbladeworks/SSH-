package com.imooc.employee.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门实体
 */
public class Department {
	
	private int did;
	private String dname;
	private String ddesc;
	
	//员工的集合
	private Set<Employee> Employees = new HashSet<Employee>() ;
	
	
	public Set<Employee> getEmployees() {
		return Employees;
	}
	public void setEmployees(Set<Employee> employees) {
		Employees = employees;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDdesc() {
		return ddesc;
	}
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
	
	
}
