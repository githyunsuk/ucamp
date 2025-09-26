package com.ucamp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ucamp.entity.ProductEntity;
import com.ucamp.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {

	private final ProductRepository productRepository;

	// 상품 입력
	@PostMapping("/product")
	public ProductEntity insertProduct(@RequestBody ProductEntity product) {

		product = productRepository.save(product);

		return product;
	}

	// 전체 상품 조회
	@GetMapping("/product")
	public List<ProductEntity> getAllProduct() {

		List<ProductEntity> list = productRepository.findAll();

		return list;
	}

	// 아이디로 상품 조회
	@GetMapping("/product/{pid}")
	public ProductEntity getProductById(@PathVariable String pid) {

		ProductEntity product = productRepository.findById(pid).orElseThrow(() -> new NullPointerException());

		return product;
	}

	// 아이디로 상품 수정
	@PutMapping("/product/{pid}")
	public ProductEntity updateProduct(@PathVariable String pid, @RequestBody ProductEntity product) {

		
		
		product.setPid(pid);
		product = productRepository.save(product);

		return product;

	}
}
