package com.taotao.service;

import com.taotao.pojo.EUDataGrid;
import com.taotao.pojo.TbItem;
import com.taotao.reslut.TaotaoResult;

public interface ItemService {
	public TbItem getItemById(Long id);
	public EUDataGrid getItemList(int page, int rows);
	public TaotaoResult saveItem(TbItem item, String desc, String dataParam) throws Exception;
	

}
