package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.EUDataGrid;
import com.taotao.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired
	private ContentService contentSerivce;

	@RequestMapping("/query/list")
	@ResponseBody
	public EUDataGrid getContentList(Integer page, Integer rows) {
		return contentSerivce.getContentList(page, rows);

	}

}
