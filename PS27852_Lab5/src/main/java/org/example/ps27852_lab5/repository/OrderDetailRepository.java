package org.example.ps27852_lab5.repository;


import org.example.ps27852_lab5.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
