package edu.hebeu.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import edu.hebeu.entity.Move;

public interface MoveService extends IService<Move>{

	/**
	 * 查询所有的调动记录
	 * @return
	 */
	List<Move> selectList();
}
