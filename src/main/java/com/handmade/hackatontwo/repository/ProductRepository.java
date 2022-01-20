package com.handmade.hackatontwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handmade.hackatontwo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {

}
