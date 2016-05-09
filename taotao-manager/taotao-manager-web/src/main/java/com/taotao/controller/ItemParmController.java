package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.EUDataGrid;
import com.taotao.reslut.TaotaoResult;
import com.taotao.service.ItemParmService;

@Controller
@RequestMapping("item/param")
public class ItemParmController {
	@Autowired
	private ItemParmService service;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGrid getItemParmList(Integer page, Integer rows){
		return service.getItemParmList(page, rows);
	}
	
	@RequestMapping("query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult getItemParmById(@PathVariable Long cid){
		return service.queryCatalogById(cid);
	}
	

}
