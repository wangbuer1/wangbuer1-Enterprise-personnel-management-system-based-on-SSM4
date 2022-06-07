package edu.hebeu.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import edu.hebeu.entity.Overtime;

public interface OvertimeService extends IService<Overtime>{

	/**
	 * 分页查询所有的加班记录
	 * @param pageNo
	 * @return
	 */
	Page<Overtime> selectListByPage(int pageNo);
	
	/**
	 * 查询一个员工的加班记录
	 * @return
	 */
	Page<Overtime> selectByEmployee(int pageNo, Integer employeeNumber);

}
