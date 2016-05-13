package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.taotao.rest.pojo.CateNodeList;
import com.taotao.rest.pojo.CateResult;
import com.taotao.rest.service.ItemCateService;
import com.taotao.utils.JsonUtils;

@Controller
public class ItemCateController {
	@Autowired
	private ItemCateService itemCateSerivice;

	/*
	 * @RequestMapping("/itemcate/list")
	 * 
	 * @ResponseBody public Object getItemList(String callback){ CateResult
	 * result = itemCateSerivice.getItemCateList(); MappingJacksonValue
	 * mappingJacksonValue = new MappingJacksonValue(result);
	 * mappingJacksonValue.setJsonpFunction(callback); return
	 * mappingJacksonValue;
	 * 
	 * }
	 */

	@RequestMapping(value = "/itemcate/list", 
			produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public String getItemList(String callback) {
		CateResult result = itemCateSerivice.getItemCateList();
		String json = JsonUtils.objectToJson(result);
		String s = callback + "(" + json + ");";
		return s;

	}

}
