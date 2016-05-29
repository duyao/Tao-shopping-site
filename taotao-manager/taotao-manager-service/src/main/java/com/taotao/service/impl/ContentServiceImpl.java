package com.taotao.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.EUDataGrid;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public EUDataGrid getContentList(int page, int rows) {
		TbContentExample example = new TbContentExample();
		PageHelper.startPage(page, rows);
		List<TbContent> list = contentMapper.selectByExample(example);
		EUDataGrid result = new EUDataGrid();
		result.setRows(list);
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	

}
