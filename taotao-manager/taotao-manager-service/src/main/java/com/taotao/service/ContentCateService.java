package com.taotao.service;

import java.util.List;

import com.taotao.pojo.EUTreeNode;
import com.taotao.reslut.TaotaoResult;

public interface ContentCateService {
	public List<EUTreeNode> getContentCateList(long parentId);

}