package com.santt4naweb.workshop01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santt4naweb.workshop01.entities.Product;

// @Repository = Não precisa pois ja estamos herdando o JpaRepository que já é um component
public interface ProductRepository extends JpaRepository<Product, Long> {

}
