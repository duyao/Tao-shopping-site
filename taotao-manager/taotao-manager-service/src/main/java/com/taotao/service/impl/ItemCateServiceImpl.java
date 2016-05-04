package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.EUTreeNode;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemCateService;

@Service
public class ItemCateServiceImpl implements ItemCateService {
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EUTreeNode> getItemCate(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List<EUTreeNode> result = new ArrayList<>();
		for (TbItemCat itemCat : list) {
			EUTreeNode treeNode = new EUTreeNode();
			treeNode.setId(itemCat.getId());
			treeNode.setText(itemCat.getName());
			//如果有子节点，该节点状态是关闭(点击时打开再查询)，否则是打开
			treeNode.setState(itemCat.getIsParent() ? "closed" : "open");
			result.add(treeNode);
		}

		return result;
	}

}
