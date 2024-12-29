package com.santt4naweb.workshop01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santt4naweb.workshop01.entities.Category;

// @Repository = Não precisa pois ja estamos herdando o JpaRepository que já é um component
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
