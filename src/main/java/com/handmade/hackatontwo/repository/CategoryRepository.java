package com.handmade.hackatonTwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handmade.hackatonTwo.model.Category;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Long>{

}
