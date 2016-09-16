package com.imooc.employee.action;

import java.util.List;

import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.Employee;
import com.imooc.employee.domain.PageBean;
import com.imooc.employee.service.DepartmentService;
import com.imooc.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *员工管理的Action类
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	private static final long serialVersionUID = 1L;
	
	//模型驱动使用的对象，通过登录执行的方法将用户名和密码封装在employee对象里.
	private Employee employee = new Employee();
	
	@Override
	public Employee getModel() {
		return employee;
	}
	
	
	//注入业务层类
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}


	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//接收当前页数
	private int currPage = 1;

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}


	/**
	 * 登录执行的方法
	 * @return
	 */
	public String login(){
		
		System.out.println("login方法被执行了......");
		
		//调用业务层的类
		Employee existEmployee =  employeeService.login(employee);
		if(existEmployee == null){
			//用户名不存在
			this.addActionError("您输入的用户名或者密码错误!");
			return INPUT;
		}else{
			//用户名存在
			
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
		
		
		
	}
	
	
	/**
	 * 分页查询员工的执行的方法
	 */
	public String findAll(){
		PageBean<Employee> pageBean= employeeService.finByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * 跳转到添加员工页面的执行方法
	 */
	public String saveUI(){
		//查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	/**
	 * 保存员工的执行方法
	 */
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	/**
	 * 编辑员工的执行方法
	 */
	public String edit(){
		
		//根据员工ID查询员工
		employee = employeeService.findById(employee.getEid());
		//查询所有的部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	
	/**
	 * 修改员工的执行方法
	 */
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	/**
	 * 删除员工执行方法
	 */
	public String delete(){
		//查询员工id
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
