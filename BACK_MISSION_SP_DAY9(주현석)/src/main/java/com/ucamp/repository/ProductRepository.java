package com.ucamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucamp.entity.ProductEntity;


public interface ProductRepository extends JpaRepository<ProductEntity, String> {
	
	//제품명으로 객체 찾기
	public ProductEntity findByPname(String pname);

}
