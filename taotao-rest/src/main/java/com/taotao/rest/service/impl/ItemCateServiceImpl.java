package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.rest.pojo.CateNodeList;
import com.taotao.rest.pojo.CateResult;
import com.taotao.rest.service.ItemCateService;
@Service
public class ItemCateServiceImpl implements ItemCateService {
	
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public CateResult getItemCateList() {
		CateResult cateResult = new CateResult();
		cateResult.setData(getItemData(0));
		return cateResult;
	}
	/**
	 * 实现取出所有的树形结构
	 * @param parentId
	 * @return
	 */
	//需要用递归而不是循环，因为不能确定有多少层
	private List<?> getItemData(long parentId){
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		
		List<Object> result = new ArrayList<>();
		int cnt = 0;
		for (TbItemCat tbItemCat : list) {
			if(tbItemCat.getParentId() == 0){
				CateNodeList cateNodeList = new CateNodeList();
				cateNodeList.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
				cateNodeList.setUrl("/products/"+tbItemCat.getId()+".html");
				cateNodeList.setData(getItemData(tbItemCat.getId()));
				result.add(cateNodeList);
				cnt++;
				if(cnt == 14){
					break;
				}
			}else{
				if(tbItemCat.getIsParent()){
					CateNodeList cateNodeList = new CateNodeList();
					cateNodeList.setName(tbItemCat.getName());
					cateNodeList.setUrl("/products/"+tbItemCat.getId()+".html");
					cateNodeList.setData(getItemData(tbItemCat.getId()));
					result.add(cateNodeList);
				}else{
					String s = "/products/"+tbItemCat.getId()+".html|"+tbItemCat.getName();
					result.add(s);
				}
			}
			
		}
		return result;
	}

}
