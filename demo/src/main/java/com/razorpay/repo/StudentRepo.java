package com.razorpay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.razorpay.dto.StudentOrder;

public interface StudentRepo extends JpaRepository<StudentOrder, Integer> {
      public StudentOrder findByRazorpayOrderId(String orderId);
}
