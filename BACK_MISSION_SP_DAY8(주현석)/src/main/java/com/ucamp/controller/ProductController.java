package com.ucamp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ucamp.entity.ProductEntity;
import com.ucamp.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

public class ProductController {

	private final ProductService productService;
	
	@GetMapping("/product")
	public List<ProductEntity> getAllProduct(){
		
		return productService.searchAllProduct();
	}
	
	@GetMapping("/product/{cid}")
	public List<ProductEntity> getProductCategory(@PathVariable String cid){
		
		return productService.searchProductByCategory(cid);
	}
	
	@GetMapping("/product/item/{pid}")
	public ProductEntity getProduct(@PathVariable String pid) {
		
		return productService.searchProductById(pid);
	}
	
	@PostMapping("/product")
	public ProductEntity insertProduct(@RequestBody ProductEntity product) {
		
		return productService.addProduct(product);
	}
	
	@PutMapping("/product/item/{pid}")
	public ProductEntity updateProduct(@PathVariable String pid, @RequestBody ProductEntity product) {
		
		product.setPid(pid);
		return productService.modifyProduct(product);
		
	}
	
	@DeleteMapping("/product/item/{pid}")
	public ProductEntity deleteProduct(@PathVariable String pid) {
		
		ProductEntity product = productService.searchProductById(pid);
		
		int result = productService.removeProduct(pid);
		
		if(result != 0) return product;
		
		return null;
	}
}
