package com.ucamp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ucamp.entity.ProductEntity;
import com.ucamp.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductMapper productMapper;

	public List<ProductEntity> searchAllProduct() {
		return productMapper.selectAllProduct();
	}

	public List<ProductEntity> searchProductByCategory(String cid) {
		return productMapper.selectProductByCategory(cid);
	}

	public ProductEntity searchProductById(String pid) {
		return productMapper.selectProductById(pid);
	}

	public ProductEntity addProduct(ProductEntity product) {
		int row = productMapper.insertProduct(product);
		
		if(row > 0) return product;
		
		return null;
	}

	public ProductEntity modifyProduct(ProductEntity product) {

		int row = productMapper.updateProduct(product);
		
		if(row > 0) return product;
		
		return null;
	}

	public int removeProduct(String pid) {
		
		int row = productMapper.deleteProduct(pid);
		
		return row;
	}
}
