package com.santt4naweb.workshop01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santt4naweb.workshop01.entities.Order;

// @Repository = Não precisa pois ja estamos herdando o JpaRepository que já é um component
public interface OrderRepository extends JpaRepository<Order, Long> {

}
