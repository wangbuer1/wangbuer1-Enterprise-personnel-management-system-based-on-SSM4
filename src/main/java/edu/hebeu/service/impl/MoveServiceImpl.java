package edu.hebeu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import edu.hebeu.entity.Department;
import edu.hebeu.entity.Employee;
import edu.hebeu.entity.Move;
import edu.hebeu.entity.Overtime;
import edu.hebeu.mapper.DepartmentMapper;
import edu.hebeu.mapper.EmployeeMapper;
import edu.hebeu.mapper.MoveMapper;
import edu.hebeu.service.MoveService;

@Service("moveService")
public class MoveServiceImpl extends ServiceImpl<MoveMapper, Move> 
	implements MoveService{
	
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	
	/**
	 * 为overtime对象setDepartment setPosition
	 * @param overtime
	 * @return
	 */
	public Overtime setObject(Overtime overtime){
		Integer departmentNumber = overtime.getDepartmentNumber();
		Department  department = departmentMapper.selectByNumber(departmentNumber);
		overtime.setDepartment(department);
		
		Integer employeeNumber = overtime.getEmployeeNumber();
		Employee employee = employeeMapper.selectByNumber(employeeNumber);
		overtime.setEmployee(employee);
		return overtime;
	}

	@Override
	public List<Move> selectList() {
		//查询所有记录，根据id倒序排序
		List<Move> list = baseMapper.selectList(new EntityWrapper<Move>().
				orderBy("id", false));
		for(Move move : list){
			Employee employee = employeeMapper.selectByNumber(move.getEmployeeNumber());
			move.setEmployee(employee);
			Department department = departmentMapper.selectByNumber(move.getBefore());
			move.setDepartment(department);
			Department department2 = departmentMapper.selectByNumber(move.getAfter());
			move.setDepartment2(department2);
		}
		return list;
	}

}
