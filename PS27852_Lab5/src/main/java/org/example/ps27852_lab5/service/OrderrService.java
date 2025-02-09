package org.example.ps27852_lab5.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.example.ps27852_lab5.entity.Order;

import java.util.List;

public interface OrderrService {
    Order create(JsonNode orderData );
    Order findById(Integer id);
    List<Order> getAllOrderByUsername(String username);
}
