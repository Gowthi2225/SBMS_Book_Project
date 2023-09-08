package com.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {

}
