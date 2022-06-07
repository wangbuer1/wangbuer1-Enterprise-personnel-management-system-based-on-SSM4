package edu.hebeu.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import edu.hebeu.entity.Department;

public interface DepartmentService extends IService<Department>{

	/**
	 * 根据DepartmentNumber查询信息
	 * @param departmentNumber
	 * @return
	 */
	Department selectByNumber(Integer departmentNumber);
	
	/**
	 * 分页查询所有部门（倒序）
	 * @param pageNo
	 * @return
	 */
	Page<Department> selectListByPage(int pageNo);
	
}
