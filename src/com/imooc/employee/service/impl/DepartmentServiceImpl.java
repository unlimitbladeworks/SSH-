package com.imooc.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imooc.employee.dao.DepartmentDao;
import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.PageBean;
import com.imooc.employee.service.DepartmentService;

/**
 *部门管理的业务层的实现类
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	//注入部门管理的DAO
	
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}



	//分页查询部分的方法
	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin = (currPage -1)* pageSize;
		List<Department> list = departmentDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		
		
		return pageBean;
	}


	//业务层保存部门的方法
	@Override
	public void save(Department department) {
		
		departmentDao.save(department);
		
	}


	//业务层根据部门的ID查询部门的方法
	@Override
	public Department findById(int did) {
		
		
		return departmentDao.finById(did);
	}


	//业务层添加部门
	@Override
	public void update(Department department) {
		
		departmentDao.update(department);
		
	}


	//业务层调用Dao删除部门
	@Override
	public void delete(Department department) {

		departmentDao.delete(department);
	}


	//查询所有部门的方法
	@Override
	public List<Department> findAll() {
		
		return departmentDao.findAll();
	}
	

}
