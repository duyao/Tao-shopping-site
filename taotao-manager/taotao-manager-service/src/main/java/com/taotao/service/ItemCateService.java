package com.taotao.service;

import java.util.List;

import com.taotao.pojo.EUTreeNode;

public interface ItemCateService {
	public List<EUTreeNode> getItemCate(long parentId);

}
