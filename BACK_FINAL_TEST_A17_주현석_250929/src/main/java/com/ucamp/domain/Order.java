package com.ucamp.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	private Long orderId;
	private Long memberId;
	private Long productId;
	
	private Date orderDate;
	private String status;
	
	private String name;
	private Long price;
  
}
