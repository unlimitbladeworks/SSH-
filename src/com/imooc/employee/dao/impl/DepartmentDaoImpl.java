package com.imooc.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.imooc.employee.dao.DepartmentDao;
import com.imooc.employee.domain.Department;

/**
 *部门管理的DAO实现类
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public int findCount() {
		String hql = "select count(*)from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	/**
	 *分页查询部门 
	 */
	public List<Department> findByPage(int begin,int pageSize) {
		DetachedCriteria critertia = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(critertia, begin, pageSize);
		return list;
	}
	//DAO中保存部门的方法
	@Override
	public void save(Department department) {
		
		this.getHibernateTemplate().save(department);
	}

	
	//DAO中根据部门的ID查询部门的方法
	@Override
	public Department finById(int did) {
		
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	//DAO中修改部门的方法
	public void update(Department department) {
		
		this.getHibernateTemplate().update(department);
	}

	@Override
	//DAO中删除部门的方法
	public void delete(Department department) {

		this.getHibernateTemplate().delete(department);
	}

	//DAO中的查询所有部门的方法
	@Override
	public List<Department> findAll() {
		return this.getHibernateTemplate().find("from Department");
	}

	
	
}
