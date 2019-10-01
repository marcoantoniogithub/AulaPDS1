package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;

	public List<OrderDTO> findAll(){
		List<Order> list = repository.findAll();
		return list.stream().map(e -> new OrderDTO(e)).collect(Collectors.toList());
	}
	
	public OrderDTO findById(Long id) {
		 Optional<Order> obj = repository.findById(id);
		 Order entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		 return new OrderDTO(entity);
	}
}
