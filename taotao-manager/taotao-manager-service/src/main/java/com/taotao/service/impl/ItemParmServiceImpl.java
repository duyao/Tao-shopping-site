package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.EUDataGrid;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamExample.Criteria;
import com.taotao.reslut.TaotaoResult;
import com.taotao.service.ItemParmService;
@Service
public class ItemParmServiceImpl implements ItemParmService {
	@Autowired
	TbItemParamMapper mapper;

	@Override
	public EUDataGrid getItemParmList(int page, int rows) {
		TbItemParamExample example = new TbItemParamExample();
		PageHelper.startPage(page, rows);
		List<TbItemParam> list = mapper.selectByExample(example);
		EUDataGrid dataGrid = new EUDataGrid();
		dataGrid.setRows(list);
		PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
		dataGrid.setTotal(pageInfo.getTotal());
		return dataGrid;
	}

	@Override
	public TaotaoResult queryCatalogById(long id) {
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<TbItemParam> list = mapper.selectByExample(example);
		TaotaoResult result = TaotaoResult.ok();
		if(list != null && list.size() > 0){
			result.setData(list.get(0));
		}
		return result;
	}

}
