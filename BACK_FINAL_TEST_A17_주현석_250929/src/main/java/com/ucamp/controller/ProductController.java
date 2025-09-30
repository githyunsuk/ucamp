package com.ucamp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ucamp.domain.Product;
import com.ucamp.domain.ProductOption;
import com.ucamp.service.OrderService;
import com.ucamp.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	
	//상품페이지(전체 조회)
	@GetMapping("/product")
	public String getProductPage(Model model) {
		
		List<Product> list = productService.searchAllProduct();
		
		model.addAttribute("ProductList", list);
		
		return "product";
		
	}
	
	//상품페이지(검색 조회)
	@PostMapping("/product")
	public String getProductOption(@ModelAttribute ProductOption productOption, Model model) {
		
		List<Product> list = productService.searchProductByOption(productOption);
		
		model.addAttribute("ProductList", list);
		return "product";
	}
	

}
