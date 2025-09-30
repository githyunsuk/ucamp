package com.ucamp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ucamp.domain.Product;
import com.ucamp.domain.ProductOption;

@Mapper
public interface ProductMapper {

	public List<Product> selectAllProduct();
	
	public List<Product> selectProductByOption(ProductOption option);
	
	public Product selectProductById(Long productId);
}
