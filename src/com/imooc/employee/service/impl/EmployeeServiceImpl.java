package com.imooc.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imooc.employee.dao.EmployeeDao;
import com.imooc.employee.domain.Employee;
import com.imooc.employee.domain.PageBean;
import com.imooc.employee.service.EmployeeService;

/**
 *员工管理的业务层的实现类
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	//注入DAO
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	/**
	 * 业务层登录的方法
	 */
	public Employee login(Employee employee) {
		
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		
		return existEmployee;
	}

	/**
	 * 业务层的分页查询员工的方法
	 */
	@Override
	public PageBean<Employee> finByPage(int currPage) {
		
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	//业务层保存员工的方法
	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	//业务层根据员工的ID查询员工的方法
	@Override
	public Employee findById(int eid) {
		
		return employeeDao.findById(eid);
	}

	//业务层修改员工的方法
	@Override
	public void update(Employee employee) {
		
		employeeDao.update(employee);
	}

	//业务层删除员工的方法
	@Override
	public void delete(Employee employee) {
		
		employeeDao.delete(employee);
	}
	
}
