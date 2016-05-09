package com.taotao.service;

import com.taotao.pojo.EUDataGrid;
import com.taotao.reslut.TaotaoResult;

public interface ItemParmService {
	public EUDataGrid getItemParmList(int page, int rows);
	public TaotaoResult queryCatalogById(long id);


}
