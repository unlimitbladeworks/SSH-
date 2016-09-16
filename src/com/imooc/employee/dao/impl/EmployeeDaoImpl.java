package com.imooc.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.imooc.employee.dao.EmployeeDao;
import com.imooc.employee.domain.Employee;

/**
 *员工管理的DAO的实现类
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	/**
	 * DAO中根据用户名和密码查询用的方法
	 */
	public Employee findByUsernameAndPassword(Employee employee) {
		
		String hql = "from Employee where username = ? and password = ?";
		List<Employee> list = this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	public int findCount() {
		
		String hql = "select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
			
			return list.get(0).intValue();
		}
		
		return 0;
	}
	//DAO中保存员工的方法
	@Override
	public void save(Employee employee) {
		
		this.getHibernateTemplate().save(employee);
		
	}
	
	//DAO中根据员工ID查询员工的方法

	@Override
	public Employee findById(int eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	@Override
	public void update(Employee employee) {
		
		this.getHibernateTemplate().update(employee);
		
	}

	@Override
	public void delete(Employee employee) {
		
		this.getHibernateTemplate().delete(employee);
		
	}

}
