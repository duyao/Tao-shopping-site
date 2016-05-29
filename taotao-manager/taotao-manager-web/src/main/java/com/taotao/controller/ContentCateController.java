package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.EUTreeNode;
import com.taotao.reslut.TaotaoResult;
import com.taotao.service.ContentCateService;

@Controller
@RequestMapping("/content/category")
public class ContentCateController {
	@Autowired
	private ContentCateService contentCateService;
	
	@RequestMapping("/list")
	@ResponseBody
	//http://localhost:8080/content/category/list?id=30
	public List<EUTreeNode> getContentCateList(@RequestParam(value="id",defaultValue="0") Long parentId){
		return contentCateService.getContentCateList(parentId);
		
	}
	
	@RequestMapping("/create")
	public TaotaoResult createContentCate(Long parentId, String name){
		//数据库成功，但是页面返回404
		return contentCateService.addNode(parentId, name);
		
	}
	
	@RequestMapping("/update")
	public TaotaoResult updateNode(Long id, String name){
		//数据库成功，但是页面返回404
		return contentCateService.updateNode(id, name);
	}
	
	@RequestMapping("delete")
	public TaotaoResult deleteNode(Long parentId, Long id){
		//paerentId不能从页面传来
		return contentCateService.deleteNode(parentId, id);
	}

}
