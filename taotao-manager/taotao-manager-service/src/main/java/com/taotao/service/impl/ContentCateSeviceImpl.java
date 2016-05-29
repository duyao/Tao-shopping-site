package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.EUTreeNode;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.reslut.TaotaoResult;
import com.taotao.service.ContentCateService;
@Service
public class ContentCateSeviceImpl implements ContentCateService {

	@Autowired
	private TbContentCategoryMapper mapper;
	@Override
	public List<EUTreeNode> getContentCateList(long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list = mapper.selectByExample(example);
		List<EUTreeNode> result = new ArrayList<>();
		for (TbContentCategory category : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(category.getId());
			node.setText(category.getName());
			node.setState(category.getIsParent() ? "closed" : "open");
			result.add(node);
		}
		return result;
	}
	@Override
	public TaotaoResult addNode(long parentId, String name) {
		//1.添加当前结点
		TbContentCategory category = new TbContentCategory();
		category.setParentId(parentId);
		category.setName(name);
		category.setCreated(new Date());
		category.setUpdated(new Date());
		category.setIsParent(false);
		category.setSortOrder(1);
		category.setStatus(1);
		//如何获取添加节点的id？
		//在mybatis中加入<selectKey>
		
		//2.修改父节点
		TbContentCategory parent = mapper.selectByPrimaryKey(parentId);
		if(!parent.getIsParent()){
			parent.setIsParent(true);
		}
		
		mapper.insert(category);
		return TaotaoResult.ok(category);
	}
	
	@Override
	public TaotaoResult updateNode(long id, String name) {
		TbContentCategory category = mapper.selectByPrimaryKey(id);
		category.setName(name);
		mapper.updateByPrimaryKey(category);
		return TaotaoResult.ok(category);
	}
	@Override
	public TaotaoResult deleteNode(long parentId, long id) {
		mapper.deleteByPrimaryKey(id);
		TbContentCategory parent = mapper.selectByPrimaryKey(parentId);
		if(parent.getIsParent()){
			parent.setIsParent(false);
		}
		mapper.updateByPrimaryKey(parent);
		return TaotaoResult.ok(parent);
	}
	

}
