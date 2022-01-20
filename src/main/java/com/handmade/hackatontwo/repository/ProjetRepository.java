package com.handmade.hackatontwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handmade.hackatontwo.model.Projet;

@Repository
public interface ProjetRepository  extends JpaRepository<Projet,Long>{

}
