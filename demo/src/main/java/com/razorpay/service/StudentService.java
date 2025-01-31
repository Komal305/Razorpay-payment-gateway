package com.razorpay.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.dto.StudentOrder;
import com.razorpay.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Value("${razorpay.key.id}")
	private String razorpayKey;
	
	@Value("${razorpay.secret.key}")
	private String razorpaySecretKey;
	
	private RazorpayClient client;
	
	
	public StudentOrder createOrder(StudentOrder stuOrder) throws Exception {
		JSONObject orderReq = new JSONObject();
		orderReq.put("amount", stuOrder.getAmount()*100);
		orderReq.put("currency", "INR");
		orderReq.put("receipt", stuOrder.getEmail());
		
		this.client = new RazorpayClient(razorpayKey, razorpaySecretKey);
		
				
		Order razorPayOrder = client.orders.create(orderReq);
		
		stuOrder.setRazorpayOrderId(razorPayOrder.get("id"));
		stuOrder.setOrderStatus(razorPayOrder.get("status"));
		
		studentRepo.save(stuOrder);
		
		return stuOrder;
	}
	
	public StudentOrder updateOrder(Map<String, String> responsePayLoad) {
		String razorPayOrderId = responsePayLoad.get("razorpay_order_id");
		
		StudentOrder order = studentRepo.findByRazorpayOrderId(razorPayOrderId);
		order.setOrderStatus("Payment ho gaya");
		StudentOrder updatedOrder = studentRepo.save(order);
		return updatedOrder;
	}
	
	
}
