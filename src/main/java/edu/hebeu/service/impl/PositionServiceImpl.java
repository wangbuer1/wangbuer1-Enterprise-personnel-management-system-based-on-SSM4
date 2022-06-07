package edu.hebeu.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import edu.hebeu.entity.Position;
import edu.hebeu.mapper.PositionMapper;
import edu.hebeu.service.PositionService;

@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position>
	implements PositionService{

	@Override
	public Position selectByNumber(Integer positionNumber) {
		return baseMapper.selectByNumber(positionNumber);
	}

	@Override
	public Page<Position> selectListByPage(int pageNo) {
		Page<Position> page = new Page<Position>(pageNo, 5, "id");
		page.setAsc(false);
		page.setRecords(baseMapper.selectPage(page, null));
		return page;
	}

}
