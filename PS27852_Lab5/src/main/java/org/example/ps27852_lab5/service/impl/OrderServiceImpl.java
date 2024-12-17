package org.example.ps27852_lab5.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab5.entity.Order;
import org.example.ps27852_lab5.entity.OrderDetail;
import org.example.ps27852_lab5.repository.OrderDetailRepository;
import org.example.ps27852_lab5.repository.OrderRepository;
import org.example.ps27852_lab5.service.OrderrService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderrService {

    private final OrderRepository orderRepository;

    private final OrderDetailRepository orderDetailRepository;

    @Override
    public Order create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();

        Order order = mapper.convertValue(orderData,Order.class);
        orderRepository.save(order);

        TypeReference<List<OrderDetail>> type = new TypeReference<>(){};
        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"),type)
                .stream().peek(d-> d.setOrder(order)).collect(Collectors.toList());
        orderDetailRepository.saveAll(details);
        details.forEach(x -> System.out.println(x.toString()));
        return order;
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAllOrderByUsername(String username) {
        return orderRepository.getAllOrderByUsername(username);
    }
}
