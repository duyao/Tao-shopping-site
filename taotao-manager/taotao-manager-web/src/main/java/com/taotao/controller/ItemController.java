package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.EUDataGrid;
import com.taotao.pojo.TbItem;
import com.taotao.reslut.TaotaoResult;
import com.taotao.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem geTbItemById(@PathVariable Long itemId){
		return itemService.getItemById(itemId);
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGrid getItemList(Integer page, Integer rows){
		return itemService.getItemList(page, rows);
	}

	@RequestMapping("/item/save")
	@ResponseBody
	public TaotaoResult getItemList(TbItem item,String desc,String itemParams) throws Exception{
		
		return itemService.saveItem(item, desc,itemParams);
		
	}

}
