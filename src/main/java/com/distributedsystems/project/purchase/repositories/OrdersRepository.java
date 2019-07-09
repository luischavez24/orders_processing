package com.distributedsystems.project.purchase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.distributedsystems.project.purchase.entities.Order;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Integer>{

}
