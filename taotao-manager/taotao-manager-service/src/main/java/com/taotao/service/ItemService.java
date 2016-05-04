package com.taotao.service;

import com.taotao.pojo.EUDataGrid;
import com.taotao.pojo.TbItem;

public interface ItemService {
	public TbItem getItemById(Long id);
	public EUDataGrid getItemList(int page, int rows);
	

}
