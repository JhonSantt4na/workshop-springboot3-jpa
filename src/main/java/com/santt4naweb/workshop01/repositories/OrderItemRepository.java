package com.santt4naweb.workshop01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santt4naweb.workshop01.entities.OrderItem;
import com.santt4naweb.workshop01.entities.pk.OrderItemPK;

// @Repository = Não precisa pois ja estamos herdando o JpaRepository que já é um component
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
   // O Temos que passar o OrderItemPK pq ele que é um objt
}
