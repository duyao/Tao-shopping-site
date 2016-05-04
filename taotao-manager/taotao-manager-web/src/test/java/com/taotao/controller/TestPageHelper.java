package com.taotao.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;


public class TestPageHelper {
	private ApplicationContext applicationContext;

	@Test
	public void testPageHelper(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext-*.xml");
		TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(2, 10);
		List<TbItem> list = mapper.selectByExample(example);
		for (TbItem tbItem : list) {
			System.out.println(tbItem.getTitle());
		}
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("total->"+total);
		


		
		
		

	}

	
}
