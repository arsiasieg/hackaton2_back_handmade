package com.handmade.hackatontwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handmade.hackatontwo.model.Category;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Long>{

}
