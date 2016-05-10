package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.EUDataGrid;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.reslut.TaotaoResult;
import com.taotao.service.ItemService;
import com.taotao.utils.IDUtils;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
	@Autowired 
	private TbItemParamItemMapper itemParamItemMapper;
	

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


	@Override
	public TaotaoResult saveItem(TbItem item, String desc, String dataParam) throws Exception {
		//添加item
		item.setId(IDUtils.genItemId());
		//商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		item.setUpdated(new Date());
		item.setCreated(new Date());
		itemMapper.insert(item);
		
		//添加itemDesc
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		itemDescMapper.insert(itemDesc);
		
		
		//添加itemParam
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setItemId(item.getId());
		itemParamItem.setParamData(dataParam);
		itemParamItem.setUpdated(new Date());
		itemParamItem.setCreated(new Date());
		itemParamItemMapper.insert(itemParamItem);
		
		
		TaotaoResult result = TaotaoResult.ok();
		if(result.getStatus()!=200){
			throw new Exception();
		}
		
		return result;
	}

}
