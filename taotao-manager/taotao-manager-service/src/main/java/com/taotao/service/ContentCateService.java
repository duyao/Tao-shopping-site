package com.taotao.service;

import java.util.List;

import com.taotao.pojo.EUTreeNode;
import com.taotao.reslut.TaotaoResult;

public interface ContentCateService {
	public List<EUTreeNode> getContentCateList(long parentId);
	public TaotaoResult addNode(long parentId,String name);
	public TaotaoResult updateNode(long id,String name);
	public TaotaoResult deleteNode(long parentId,long id);

}
