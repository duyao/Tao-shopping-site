package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.EUDataGrid;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private TbItemMapper itemMapper;
	

	@Override
	public TbItem getItemById(Long id) {
		//1.
//		TbItem item = tbItemMapper.selectByPrimaryKey(id);
		//2.
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}


	@Override
	public EUDataGrid getItemList(int page, int rows) {
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		EUDataGrid dataGrid = new EUDataGrid();
		dataGrid.setRows(list);
		//总记录数，是数据库中的总个数
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		dataGrid.setTotal(pageInfo.getTotal());
		return dataGrid;
	}

}
