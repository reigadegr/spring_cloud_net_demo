package com.huike.order.controller;

import com.huike.order.entity.Product;
import com.huike.order.feign.ProductFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private ProductFeignClient productFeignClient;


	@RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		return productFeignClient.findById(id);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public String findOrderById(@PathVariable Long id) {
		return "调用订单系统查询订单";
	}
}
