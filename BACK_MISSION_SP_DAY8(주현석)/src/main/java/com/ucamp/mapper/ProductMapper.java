package com.ucamp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ucamp.entity.ProductEntity;

@Mapper
public interface ProductMapper {

	public List<ProductEntity> selectAllProduct();
	public List<ProductEntity> selectProductByCategory(String cid);
	public ProductEntity selectProductById(String pid);
	
	public int insertProduct(ProductEntity product);
	public int updateProduct(ProductEntity product);
	public int deleteProduct(String pid);
}
