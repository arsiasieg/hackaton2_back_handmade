package com.handmade.hackatonTwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handmade.hackatonTwo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {

}
