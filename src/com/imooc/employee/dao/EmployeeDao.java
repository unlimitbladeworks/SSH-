package com.imooc.employee.dao;

import java.util.List;

import com.imooc.employee.domain.Employee;

/**
 *员工管理的DAO的接口
 */
public interface EmployeeDao {
	
	Employee findByUsernameAndPassword(Employee employee);

	List<Employee> findByPage(int begin, int pageSize);

	int findCount();

	void save(Employee employee);

	Employee findById(int eid);

	void update(Employee employee);

	void delete(Employee employee);

}
