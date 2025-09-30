package com.ucamp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ucamp.domain.Product;
import com.ucamp.domain.ProductOption;
import com.ucamp.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductMapper productMapper;
	
	//모든 상품 조회
	public List<Product> searchAllProduct(){
		
		return productMapper.selectAllProduct();
	}
	
	//일부 상품 조회
	public List<Product> searchProductByOption(ProductOption option){
		
		return productMapper.selectProductByOption(option);
	}
	
	//상품 하나 조회
	public Product selectProductById(Long productId) {
		
		return productMapper.selectProductById(productId);
	}
}

