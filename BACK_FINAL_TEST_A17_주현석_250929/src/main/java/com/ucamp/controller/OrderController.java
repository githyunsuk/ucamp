package com.ucamp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.ucamp.BackFinalTestApplication;
import com.ucamp.domain.Member;
import com.ucamp.domain.Order;
import com.ucamp.domain.Product;
import com.ucamp.service.OrderService;
import com.ucamp.service.ProductService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderController {

	private final ProductService productService;
	private final OrderService orderService;

	
	//구매 페이지로 이동
	@GetMapping("/purchase/{productId}")
	public String getPurchasePage(@PathVariable Long productId, Model model) {
		
		Product product = productService.selectProductById(productId);
		
		model.addAttribute(product);
		
		return "purchase";
	}
	
	//주문하기
	@PostMapping("/purchase/{productId}")
	public String getPurchase(@PathVariable Long productId, HttpSession session, Model model) {
		
		Member member = (Member)session.getAttribute("member");
		Order order = new Order();
		order.setMemberId(member.getMemberId());
		order.setProductId(productId);
		
		orderService.addOrder(order);
		
		return "redirect:/order";
	}
	
	//주문 조회 이동
	@GetMapping("/order")
	public String getOrderPage(HttpSession session, Model model) {
		
		Member member = (Member)session.getAttribute("member");
		List<Order> list = orderService.searchOrderByMember(member.getMemberId());
		model.addAttribute("OrderList", list);
		
		return "order";
	}
	
	//주문 취소
	@GetMapping("/order/cancel/{orderId}")
	public String cancel(@PathVariable Long orderId) {
		
		orderService.modifyOrderCanceled(orderId);
		
		return "redirect:/order";
	}
}
