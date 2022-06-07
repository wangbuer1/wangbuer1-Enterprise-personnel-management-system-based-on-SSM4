package edu.hebeu.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import edu.hebeu.entity.Employee;
import edu.hebeu.service.EmployeeService;

public class EmployeeTest {

	@SuppressWarnings("resource")
	@Test
	public void lognTest(){
		String xmlPath="spring/spring.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		EmployeeService eService = (EmployeeService) context.getBean("employeeService");
		Employee employee = eService.checkLogin(1001, "1001");
		System.out.println(employee.toString());
	}
	
	@SuppressWarnings("resource")
	@Test
	public void selectListTest(){
		String xmlPath="spring/spring.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		EmployeeService eService = (EmployeeService) context.getBean("employeeService");
		List<Employee> eList = eService.selectList(new EntityWrapper<Employee>());
		for(Employee e : eList){
			System.out.println(e.toString());
		}
	}
	
	@SuppressWarnings("resource")
	@Test
	public void selectById(){
		String xmlPath="spring/spring.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		EmployeeService eService = (EmployeeService) context.getBean("employeeService");
		Employee employee = eService.selectEmployee(1);
		System.out.println(employee.getDepartment());
	}
	
	@SuppressWarnings("resource")
	@Test
	public void selectListPageTest(){
		String xmlPath="spring/spring.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		EmployeeService eService = (EmployeeService) context.getBean("employeeService");
		Page<Employee> page = eService.selectListByPage(1);
		List<Employee> eList = page.getRecords();
		for(Employee e : eList){
			System.out.println(e.toString());
		}
	}
	
	@SuppressWarnings("resource")
	@Test
	public void update(){
		String xmlPath="spring/spring.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		EmployeeService eService = (EmployeeService) context.getBean("employeeService");
		Employee employee = new Employee();
		employee.setId(5);
		employee.setName("杨姐姐");
		if (eService.updateById(employee)) {
			System.out.println("成功");
		}
	}
	
	@SuppressWarnings("resource")
	@Test
	public void select(){
		String xmlPath="spring/spring.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		EmployeeService eService = (EmployeeService) context.getBean("employeeService");
		List<Employee> list = eService.select(1002, "1002");
		for(Employee employee : list){
			System.out.println(employee.toString());
		}
	}
	
/*	@SuppressWarnings("resource")
	@Test
	public void add(){
		String xmlPath="spring/spring.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		EmployeeService eService = (EmployeeService) context.getBean("employeeService");
		Employee employee = new Employee();
		employee.setEmployeeNumber(1005);
		employee.setName("杨杰");
		employee.setGender("男");
		employee.setPassword("1005");
		if (eService.addEmployee(employee)) {
			System.out.println("成功");
		}
	}*/
	
	@SuppressWarnings("resource")
	@Test
	public void delete(){
		String xmlPath="spring/spring.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		EmployeeService eService = (EmployeeService) context.getBean("employeeService");
		if (eService.deleteById(5)) {
			System.out.println("成功");
		}
	}
	
	@SuppressWarnings("resource")
	@Test
	public void test(){
		String xmlPath="spring/spring.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		EmployeeService eService = (EmployeeService) context.getBean("employeeService");
		eService.deleteEmployee(19);
	}
}
