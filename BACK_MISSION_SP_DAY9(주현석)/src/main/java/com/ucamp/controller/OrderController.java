package com.ucamp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ucamp.entity.OrderEntity;
import com.ucamp.entity.ProductEntity;
import com.ucamp.repository.OrderRepository;
import com.ucamp.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	
	//구매
	@PostMapping("/order")
	public OrderEntity order(@RequestParam("userid") String userid, @RequestParam("pname") String pname,
			@RequestParam("ordercount") int ordercount) {
		
		ProductEntity product = productRepository.findByPname(pname);
		OrderEntity order = new OrderEntity(null, userid, product.getPid(), ordercount);
		orderRepository.save(order);

		return order;
	}
	
	//전체 주문 조회
	@GetMapping("/order")
	public List<OrderEntity> getAllOrder(){
		
		return orderRepository.findAll();
	}
	
	//고객 아이디로 주문 조회
	@GetMapping("/order/{userid}")
	public List<OrderEntity> getOrderById(@PathVariable String userid){
		
		return orderRepository.findByUserid(userid);
	}
}
