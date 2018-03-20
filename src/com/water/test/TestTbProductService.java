package com.water.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.water.pojo.TbProduct;
import com.water.service.TbProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")  
public class TestTbProductService {
	@Autowired
	private TbProductService tbProductService;
	@Test
	public void testGetAllTbProducts(){
		List<TbProduct> tbProducts = tbProductService.getAllTbProducts(new TbProduct());
		System.out.println("==================测试开始======================");
		for (TbProduct tbProduct : tbProducts) {
			System.out.println(tbProduct);
		}
		System.out.println("==================测试结束======================");
	}
}
