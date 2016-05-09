package com.taotao.service;

import com.taotao.pojo.EUDataGrid;
import com.taotao.reslut.TaotaoResult;

public interface ItemParamService {
	public EUDataGrid getItemParmList(int page, int rows);
	public TaotaoResult queryCatalogByCatId(long id);
	public TaotaoResult saveItemParm(long id, String paramData);


}
