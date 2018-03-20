package com.water.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.water.authen.Authen;
import com.water.pojo.TbKind;
import com.water.pojo.TbProduct;
import com.water.service.TbKindService;
import com.water.service.TbProductService;
import com.water.util.FileUtils;
import com.water.util.StringUtils;

@Controller
@RequestMapping("/tbProduct")
public class TbProductController {
	
	@Autowired
	private TbProductService tbProductService;
	@Autowired
	private TbKindService tbKindService;
	/**
	 * 展示对应商品
	 * @param tbProduct
	 * @param model
	 * @return
	 */
	@RequestMapping("/showProducts")
	public String showProducts(TbProduct tbProduct, Model model) {
		List<TbProduct> tbProducts = tbProductService.getAllTbProducts(tbProduct);
		model.addAttribute("tbProducts", tbProducts);
		return "showProducts";
	}
	/**
	 * 跳转到相应的添加或更新页面
	 * @param pictureFile
	 * @param tbProduct
	 * @param model
	 * @return
	 */
	@Authen()
	@RequestMapping("addOrUpdateTbProductPage")
	public String addOrUpdateTbProductPage(TbProduct tbProduct, Model model){
		if (null != tbProduct && !StringUtils.isBlank(tbProduct.getId())) {
			tbProduct = tbProductService.getTbProduct(tbProduct);
		}
		model.addAttribute("tbProduct", tbProduct);
		model.addAttribute("tbKinds", tbKindService.getAllTbKind(new TbKind()));
		return "addOrUpdateProduct";
	}
	
	/**
	 * 更新或添加商品
	 * @param pictureFile
	 * @param tbProduct
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Authen()
	@RequestMapping(value="/addOrUpdateTbProduct",method=RequestMethod.POST)
	public String addOrUpdateTbProduct(@RequestParam("pictureFile") MultipartFile pictureFile, TbProduct tbProduct, HttpServletRequest request) throws Exception {
		if (!StringUtils.isBlank(pictureFile.getOriginalFilename())) {
			String filePathName = FileUtils.uploadFile(request, pictureFile);
			tbProduct.setProPic(filePathName);
		}
		tbProductService.addOrUpdateTbProduct(tbProduct);
		return "redirect:"+"/tbProduct/showProducts.action";
	}
	
	/**
	 * 展示对应商品通过json进行访问
	 * @param tbProduct
	 * @param model
	 * @return
	 */
	@RequestMapping("/showProductsByJson")
	@ResponseBody
	public List<TbProduct> showProductsByJson(TbProduct tbProduct, Model model) {
		List<TbProduct> tbProducts = tbProductService.getAllTbProducts(tbProduct);
		return tbProducts;	
	}
}
