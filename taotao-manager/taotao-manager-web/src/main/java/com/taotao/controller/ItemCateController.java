package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.EUTreeNode;
import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCateService;

@Controller
@RequestMapping("/item/cat")
public class ItemCateController {
	@Autowired
	ItemCateService itemCateService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getItemCate(@RequestParam(value="id",defaultValue="0")Long parentId){
		return itemCateService.getItemCate(parentId);
	}

}
