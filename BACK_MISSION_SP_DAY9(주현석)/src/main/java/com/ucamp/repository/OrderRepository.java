package com.ucamp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucamp.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

	public List<OrderEntity> findByUserid(String userid);
}
