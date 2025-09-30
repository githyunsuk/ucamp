package com.ucamp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ucamp.domain.Order;
import com.ucamp.mapper.OrderMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderMapper orderMapper;
	
	//주문 생성
	public void addOrder(Order order) {
		
		orderMapper.insertOrder(order);
	}
	
	//유저별 주문 찾기
	public List<Order> searchOrderByMember(Long memberId){
		
		return orderMapper.selectAllOrderByMember(memberId);
	}
	
	//주문번호로 주문 취소
	public void modifyOrderCanceled(Long orderId) {
		
		orderMapper.updateOrderCanceled(orderId);
	}
    
}