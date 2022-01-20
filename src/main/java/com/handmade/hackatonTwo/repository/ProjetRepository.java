package com.handmade.hackatonTwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handmade.hackatonTwo.model.Projet;

@Repository
public interface ProjetRepository  extends JpaRepository<Projet,Long>{

}
