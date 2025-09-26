package com.ucamp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBL_ORDER")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ORDER")
	@SequenceGenerator(name = "SEQ_ORDER", sequenceName = "SEQ_ORDER", allocationSize = 1)
	private Long orderno;
	private String userid;
	private String productid;
	private int ordercount;	
}
