package com.ucamp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ucamp.domain.Order;

@Mapper
public interface OrderMapper {

	public void insertOrder(Order order);
	
	public List<Order> selectAllOrderByMember(Long memberId);
	
	public void updateOrderCanceled(Long orderId);
}
