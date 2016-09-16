package com.imooc.employee.service;

import java.util.List;

import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.PageBean;

/**
 *部门管理的业务层的接口
 */
public interface DepartmentService {
	

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(int did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();


}
